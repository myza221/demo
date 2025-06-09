package com.example.demo;

import com.example.demo.dto.BookDto;
import com.example.demo.entity.Book;
import com.example.demo.repository.BookRepository;
import com.example.demo.service.BookService;
import jakarta.annotation.PostConstruct;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.beans.BeanUtils;
import org.springframework.boot.test.context.SpringBootTest;

import java.time.LocalDate;
import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.*;

@SpringBootTest
@ExtendWith(MockitoExtension.class)
class BookServiceTests {
    @Mock
    private BookRepository bookRepository;

    @InjectMocks
    private BookService bookService;

    @PostConstruct
    void init(){
        when(bookRepository.findAllByAuthor("my"))
                .thenReturn(
                        Arrays.asList(
                                Book.builder().id(1L)
                                        .title("title")
                                        .author("my")
                                        .publishedDate(LocalDate.now())
                                        .build(),
                                Book.builder().id(2L)
                                        .title("title")
                                        .author("my")
                                        .publishedDate(LocalDate.now())
                                        .build()
                        )
                );

    }

    @Test
    void test_getBookByAuthor() {
        List<Book> bookList = bookService.getBooks("my");
        assertEquals(2, bookList.size());
    }
}
