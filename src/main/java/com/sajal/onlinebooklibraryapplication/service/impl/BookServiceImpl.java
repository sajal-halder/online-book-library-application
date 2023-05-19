package com.sajal.onlinebooklibraryapplication.service.impl;

import com.sajal.onlinebooklibraryapplication.dto.BookRequest;
import com.sajal.onlinebooklibraryapplication.dto.BookResponse;
import com.sajal.onlinebooklibraryapplication.entity.BookEntity;
import com.sajal.onlinebooklibraryapplication.exception.BookAlreadyExistException;
import com.sajal.onlinebooklibraryapplication.exception.BookNotFoundException;
import com.sajal.onlinebooklibraryapplication.repository.BookRepository;
import com.sajal.onlinebooklibraryapplication.service.BookService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

import static com.sajal.onlinebooklibraryapplication.values.Messages.*;


@Service
@RequiredArgsConstructor
public class BookServiceImpl implements BookService {
    private final BookRepository bookRepository;
    @Override
    public List<BookResponse> getAllBooks() {
        List<BookEntity> bookEntities = bookRepository.findAll();
        List<BookResponse> bookResponses = new ArrayList<>();
        bookEntities.forEach(bookEntity -> bookResponses.add(
                BookResponse.builder()
                        .bookId(bookEntity.getBookId())
                        .title(bookEntity.getTitle())
                        .authorName(bookEntity.getAuthorName())
                        .genre(bookEntity.getGenre())
                        .price(bookEntity.getPrice())
                        .description(bookEntity.getDescription())
                        .build()
        ));
        return bookResponses;

    }

    @Override
    public BookResponse getBookByBookId(String bookId) {
        var book = bookRepository.findById(Long.parseLong(bookId));
        if(book.isEmpty()){
            throw new BookNotFoundException(NO_BOOK_WITH_ID);
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
        var book = bookRepository.findByTitleAndAuthorName(bookTitle,authorName);
        if(book.isEmpty()){
            throw new BookNotFoundException(NO_BOOK_WITH_TITLE_AUTHOR);
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
    public List<BookResponse> getAllBooksByAuthorName(String authorName) {
        List<BookEntity> bookEntities = bookRepository.findAllByAuthorName(authorName);
        List<BookResponse> bookResponses = new ArrayList<>();
        bookEntities.forEach(bookEntity -> bookResponses.add(
                BookResponse.builder()
                        .bookId(bookEntity.getBookId())
                        .title(bookEntity.getTitle())
                        .authorName(bookEntity.getAuthorName())
                        .genre(bookEntity.getGenre())
                        .price(bookEntity.getPrice())
                        .description(bookEntity.getDescription())
                        .build()
        ));
        return bookResponses;
    }

    @Override
    public BookResponse createBook(BookRequest bookRequest) {
        if(bookRepository.findByTitleAndAuthorName(bookRequest.getTitle(),bookRequest.getAuthorName()).isPresent()){
            throw new BookAlreadyExistException(BOOK_EXIST_WITH_TITLE_AUTHOR);
        }
        BookEntity bookEntity =bookRepository.save(BookEntity.builder()
                .authorName(bookRequest.getAuthorName())
                .title(bookRequest.getTitle())
                .price(bookRequest.getPrice())
                .genre(bookRequest.getGenre())
                .description(bookRequest.getDescription())
                .build());
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
    public BookResponse updateBookById(Long bookId, BookRequest bookRequest) {
        var book = bookRepository.findById(bookId);
        if(book.isEmpty()){
            throw new BookNotFoundException(NO_BOOK_WITH_ID);
        }
        BookEntity bookEntity = book.get();
        bookEntity.setAuthorName(bookRequest.getAuthorName());
        bookEntity.setDescription(bookRequest.getDescription());
        bookEntity.setTitle(bookRequest.getTitle());
        bookEntity.setGenre(bookRequest.getGenre());
        bookEntity.setPrice(bookRequest.getPrice());

        BookEntity updatedBookId = bookRepository.save(bookEntity);
        return BookResponse.builder()
                .bookId(updatedBookId.getBookId())
                .title(updatedBookId.getTitle())
                .authorName(updatedBookId.getAuthorName())
                .genre(updatedBookId.getGenre())
                .price(updatedBookId.getPrice())
                .description(updatedBookId.getDescription())
                .build();
    }

    @Override
    public String deleteBookById(Long bookId) {
        var book = bookRepository.findById(bookId);
        if(book.isEmpty()){
            throw  new BookNotFoundException(NO_BOOK_WITH_ID);
        }
        bookRepository.deleteById(bookId);
        return BOOK_DELETED;
    }
}
