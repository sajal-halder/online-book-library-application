package com.sajal.onlinebooklibraryapplication.service;

import com.sajal.onlinebooklibraryapplication.dto.BookRequest;
import com.sajal.onlinebooklibraryapplication.dto.BookResponse;

import java.util.List;

public interface BookService {
 public List<BookResponse> getAllBooks();
 public BookResponse getBookByBookId(String bookId);
 public BookResponse getBookByAuthorNameAndBookTitle(String authorName,String bookTitle);

 public BookResponse createBook(BookRequest bookRequest);
 public BookResponse updateBookById(Long bookId,BookRequest bookRequest);
 public void deleteBookById(Long bookId);

}
