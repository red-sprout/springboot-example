package com.example.boot.service;

import com.example.boot.domain.dto.CommentRequest;
import com.example.boot.repository.CommentResponse;

import java.util.List;

public interface CommentService {
    Boolean create(CommentRequest.CreateDTO request) throws Exception;

    public List<CommentResponse> getComment(Long boardId) throws Exception;
}
