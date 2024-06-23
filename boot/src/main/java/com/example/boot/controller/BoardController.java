package com.example.boot.controller;

import com.example.boot.domain.dto.BoardRequest;
import com.example.boot.repository.BoardResponse;
import com.example.boot.service.BoardService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/board")
public class BoardController {
    private final BoardService boardService; // 필드에 추가 //생성자 주입방식

    @PostMapping(consumes = MediaType.ALL_VALUE)
    public ResponseEntity<Boolean> create(BoardRequest.CreateDTO request) throws Exception {
        // 서비스 레이어에서 게시글 생성 및 파일 업로드 처리
        boolean isCreated = boardService.create(request);
        return new ResponseEntity<>(isCreated, HttpStatus.OK);
    }

    // 전체 게시글 조회 [all]
    @GetMapping
    public ResponseEntity<List<BoardResponse>> getList() throws Exception {
        return new ResponseEntity<>(boardService.getList(), HttpStatus.OK);
    }
}
