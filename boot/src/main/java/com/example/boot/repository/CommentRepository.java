package com.example.boot.repository;

import com.example.boot.domain.entity.Board;
import com.example.boot.domain.entity.Comment;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface CommentRepository extends JpaRepository<Comment, String> {
    List<Comment> findAllByBoardOrderByCreatedDateDesc(Board board);
}
