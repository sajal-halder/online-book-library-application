package com.sajal.onlinebooklibraryapplication.repository;

import com.sajal.onlinebooklibraryapplication.entity.BookEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;
@Repository
public interface BookRepository extends JpaRepository<BookEntity,Long> {
    Optional<BookEntity> findByTitleAndAuthorName(String title, String authorName);
}
