package com.example.boot.repository;

import com.example.boot.domain.entity.Board;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Repository
@Transactional
public interface BoardRepository extends JpaRepository<Board, String> {
    Board findBoardByBoardId(Long boardId);
    List<Board> findAllByOrderByCreateAtDesc();
}
