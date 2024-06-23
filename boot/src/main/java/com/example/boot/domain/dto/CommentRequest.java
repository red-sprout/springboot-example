package com.example.boot.domain.dto;

import com.example.boot.domain.entity.Board;
import lombok.Getter;
import lombok.Setter;

public class CommentRequest {
    @Getter
    @Setter
    public static class CreateDTO {
        private Long boardId;
        private String userId;
        private String contents;
    }

    @Getter
    @Setter
    public static class UpdateDTO {
        private Long commentId;
        private Long boardId;
        private String userId;
        private String contents;
    }
}
