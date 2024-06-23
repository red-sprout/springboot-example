package com.example.boot.domain.entity;

import jakarta.persistence.*;
import lombok.*;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import java.time.LocalDateTime;

@Table(name = "COMMENT")
@Entity
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@AllArgsConstructor
@Data
@Builder
public class Comment {
    @Id // 엔티티의 기본 키(Primary Key)임을 나타냄
    @GeneratedValue(strategy = GenerationType.IDENTITY) //기본키가 자동으로 증가하는 방식을 사용한다.
    @Column(unique = true)
    private Long commentId;

    @ManyToOne(cascade = CascadeType.REMOVE) // 다대일 관계와 부모 삭제 시 자식 삭제를 설정합니다.
    @JoinColumn(name = "board_id", nullable = false) // 외래 키로 'board_id'를 사용합니다.
    private Board board;

    @Column(nullable = false)
    private String userId;

    @Column(nullable = false, columnDefinition = "TEXT")
    private String contents;

    @CreationTimestamp
    @Column
    private LocalDateTime createdDate;

    @UpdateTimestamp
    @Column
    private LocalDateTime updatedDate;
}
