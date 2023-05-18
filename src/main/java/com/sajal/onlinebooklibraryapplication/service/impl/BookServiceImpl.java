package com.sajal.onlinebooklibraryapplication.service.impl;

import com.sajal.onlinebooklibraryapplication.dto.BookRequest;
import com.sajal.onlinebooklibraryapplication.dto.BookResponse;
import com.sajal.onlinebooklibraryapplication.entity.BookEntity;
import com.sajal.onlinebooklibraryapplication.exception.BookNotFoundException;
import com.sajal.onlinebooklibraryapplication.repository.BookRepository;
import com.sajal.onlinebooklibraryapplication.service.BookService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class BookServiceImpl implements BookService {
    private final BookRepository bookRepository;
    @Override
    public List<BookResponse> getAllBooks() {
        return null;
    }

    @Override
    public BookResponse getBookByBookId(String bookId) {
        var book = bookRepository.findById(Long.parseLong(bookId));
        if(book.isEmpty()){
            throw new BookNotFoundException("No book found with the matching id");
        }
        BookEntity bookEntity = book.get();
        return BookResponse.builder()
                .bookId(bookEntity.getBookId())
                .title(bookEntity.getTitle())
                .authorName(bookEntity.getAuthorName())
                .genre(bookEntity.getGenre())
                .price(bookEntity.getPrice())
                .description(bookEntity.getDescription())
                .build();
    }

    @Override
    public BookResponse getBookByAuthorNameAndBookTitle(String authorName, String bookTitle) {
        return null;
    }

    @Override
    public BookResponse createBook(BookRequest bookRequest) {
        return null;
    }

    @Override
    public BookResponse updateBookById(Long bookId, BookRequest bookRequest) {
        return null;
    }

    @Override
    public void deleteBookById(Long bookId) {

    }
}
