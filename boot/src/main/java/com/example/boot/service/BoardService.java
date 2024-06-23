package com.example.boot.service;

import com.example.boot.domain.dto.BoardRequest;
import com.example.boot.repository.BoardResponse;

import java.util.List;

public interface BoardService {
    Boolean create(BoardRequest.CreateDTO request) throws Exception;

    public List<BoardResponse> getList() throws Exception;
}
