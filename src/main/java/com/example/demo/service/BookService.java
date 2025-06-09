package com.example.demo.service;

import com.example.demo.dto.BookDto;
import com.example.demo.entity.Book;
import com.example.demo.repository.BookRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@Slf4j
@RequiredArgsConstructor
public class BookService {
    private final BookRepository bookRepository;

    public List<Book> getBooks(String author){
        return bookRepository.findAllByAuthor(author);
    }

    public Book saveBook(BookDto dto){
        try {
            Book book = new Book();
            BeanUtils.copyProperties(dto, book);
            return bookRepository.save(book);
        } catch (Exception e) {
            e.printStackTrace();
        }

        return null;
    }
}
