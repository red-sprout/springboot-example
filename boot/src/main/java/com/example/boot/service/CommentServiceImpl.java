package com.example.boot.service;

import com.example.boot.domain.dto.CommentRequest;
import com.example.boot.domain.entity.Board;
import com.example.boot.domain.entity.Comment;
import com.example.boot.repository.BoardRepository;
import com.example.boot.repository.CommentRepository;
import com.example.boot.repository.CommentResponse;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;

@Slf4j
@Service
@Transactional
@RequiredArgsConstructor
public class CommentServiceImpl implements CommentService {

    private final BoardRepository boardRepository;
    private final CommentRepository commentRepository;

    @Override
    public Boolean create(CommentRequest.CreateDTO request) throws Exception {
        if(request.getBoardId() == null || request.getUserId() == null || request.getContents() == null)
            throw new RuntimeException("data is null");

        try {
            Board board = boardRepository.findBoardByBoardId(request.getBoardId());
            Comment comment = Comment.builder()
                    .board(board)
                    .userId(request.getUserId())
                    .contents(request.getContents())
                    .build();

            commentRepository.save(comment);
        } catch (Exception e) {
            e.printStackTrace();
            throw new RuntimeException("insert comment error");
        }
        return true;
    }

    @Override
    public List<CommentResponse> getComment(Long boardId) throws Exception {
        Board board = boardRepository.findBoardByBoardId(boardId);
        List<Comment> comments = commentRepository.findAllByBoardOrderByCreatedDateDesc(board);
        List<CommentResponse> getListDTO = new ArrayList<>();
        comments.forEach( s -> getListDTO.add(CommentResponse.GetCommentDTO(s)));
        return getListDTO;
    }
}
