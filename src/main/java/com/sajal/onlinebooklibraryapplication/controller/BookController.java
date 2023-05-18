package com.sajal.onlinebooklibraryapplication.controller;
import com.sajal.onlinebooklibraryapplication.dto.BookResponse;
import com.sajal.onlinebooklibraryapplication.service.BookService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/books")
public class BookController {

    private final BookService bookService;

    @GetMapping("/all")
    public ResponseEntity<List<BookResponse>> getAllBooks(){
        return ResponseEntity.ok( bookService.getAllBooks());
    }

    @GetMapping("/id/{bookId}")
    public ResponseEntity<BookResponse> getBookById(@PathVariable String bookId ){
        return ResponseEntity.ok(bookService.getBookByBookId(bookId));
    }

}
