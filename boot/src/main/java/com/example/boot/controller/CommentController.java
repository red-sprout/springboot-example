package com.example.boot.controller;

import com.example.boot.domain.dto.CommentRequest;
import com.example.boot.repository.CommentResponse;
import com.example.boot.service.CommentService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/comments")
public class CommentController {

    private final CommentService commentService;

    // 댓글 작성
    @PostMapping(consumes = MediaType.ALL_VALUE)
    public ResponseEntity<Boolean> create(CommentRequest.CreateDTO request) throws Exception {
        boolean isCreated = commentService.create(request);
        return new ResponseEntity<>(isCreated, HttpStatus.OK);
    }

    // 댓글 목록 조회
    @GetMapping
    public ResponseEntity<List<CommentResponse>> getComments(@RequestParam(value="boardId") Long boardId) throws Exception {
        return new ResponseEntity<>(commentService.getComment(boardId), HttpStatus.OK);
    }
}
