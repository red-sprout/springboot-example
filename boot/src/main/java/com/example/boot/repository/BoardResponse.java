package com.example.boot.repository;

import com.example.boot.domain.entity.Board;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class BoardResponse {
    private Long boardId;
    private String title;
    private String contents;
    private String userId;
    private String pwd;
    private String filename;
    private LocalDateTime createAt;
    private LocalDateTime updateAt;

    public static BoardResponse GetBoardDTO(Board board) {
        return new BoardResponse(
                board.getBoardId(),
                board.getTitle(),
                board.getContents(),
                board.getUserId(),
                board.getPwd(),
                board.getFileName(),
                board.getCreateAt(),
                board.getUpdateAt()
        );
    }
}
