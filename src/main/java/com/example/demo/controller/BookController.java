package com.example.demo.controller;

import com.example.demo.dto.ApiResponse;
import com.example.demo.dto.BookDto;
import com.example.demo.entity.Book;
import com.example.demo.service.BookService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.util.ObjectUtils;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.util.List;

@RestController
@RequestMapping("/api/books")
@RequiredArgsConstructor
@Slf4j
public class BookController {

    private final BookService bookService;

    @GetMapping("/{author}")
    public ResponseEntity<List<Book>> getBooksByAuthor(@PathVariable("author") String author) {
        log.info("getBooksByAuthor :: {}" , author);
        List<Book> list = bookService.getBooks(author);
        return ResponseEntity.ok(list);
    }

    @PostMapping("/save")
    public ResponseEntity<ApiResponse> saveBooks(@Valid @RequestBody BookDto dto) {
        log.info("saveBooks :: {}" , dto.getAuthor());
        ApiResponse response;

        LocalDate date = dto.getPublishedDate();
        if (date == null) {
            response = initResponse(HttpStatus.BAD_REQUEST,"publishedDate is not null");
            return ResponseEntity.ok(response);
        }

        int year = date.getYear();
        int currentYear = LocalDate.now().getYear();
        if (year > 1000 && year <= currentYear) {
            Book book = bookService.saveBook(dto);
            if (ObjectUtils.isEmpty(book)) {
                response = initResponse(HttpStatus.INTERNAL_SERVER_ERROR,"");
            } else {
                response = initResponse(HttpStatus.OK, "");
            }
            response.setData(book);

        } else {
            response = initResponse(HttpStatus.BAD_REQUEST,"Invalid Date must be year > 1000 and <= current year");
        }

        return ResponseEntity.ok(response);
    }

    private ApiResponse initResponse(HttpStatus code, String message) {
        return new ApiResponse<>(code.value(), message);
    }

}
