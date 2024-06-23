package com.example.boot.repository;

import com.example.boot.domain.entity.Board;
import com.example.boot.domain.entity.Comment;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class CommentResponse {
    private Long commentId;
    private Board board;
    private String userId;
    private String contents;
    private LocalDateTime createdDate;
    private LocalDateTime updatedDate;

    public static CommentResponse GetCommentDTO(Comment comment) {
        return new CommentResponse(
                comment.getCommentId(),
                comment.getBoard(),
                comment.getUserId(),
                comment.getContents(),
                comment.getCreatedDate(),
                comment.getUpdatedDate()
        );
    }
}
