package com.sajal.onlinebooklibraryapplication.controller;
import com.sajal.onlinebooklibraryapplication.dto.BookRequest;
import com.sajal.onlinebooklibraryapplication.dto.BookResponse;
import com.sajal.onlinebooklibraryapplication.service.BookService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

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

    @GetMapping("author-title/{authorName}/{bookTitle}")
    public ResponseEntity<BookResponse> getBookByAuthorNameAndTitle(@PathVariable String authorName ,@PathVariable String bookTitle){
        return ResponseEntity.ok(bookService.getBookByAuthorNameAndBookTitle(authorName, bookTitle));
    }

    @GetMapping("/author/{authorName}")
    public ResponseEntity<List<BookResponse>> getBooksByAuthorName(@PathVariable String authorName){
        return ResponseEntity.ok(bookService.getAllBooksByAuthorName(authorName));
    }

    @PostMapping("/create")
    public ResponseEntity<BookResponse> createBook(@RequestBody BookRequest bookRequest){
        return ResponseEntity.ok(bookService.createBook(bookRequest));
    }

    @PutMapping("/update/bookId/{bookId}")
    public ResponseEntity<BookResponse> updateBook(@RequestBody BookRequest bookRequest,@PathVariable String bookId){
        return ResponseEntity.ok(bookService.updateBookById(Long.parseLong(bookId),bookRequest));
    }

    @DeleteMapping("/delete/bookId/{bookId}")
    public ResponseEntity<Object> deleteBook(@PathVariable String bookId){
        return ResponseEntity.ok(bookService.deleteBookById(Long.parseLong(bookId)));
    }



}
