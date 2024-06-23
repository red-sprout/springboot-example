package com.example.boot.mapper;

import com.example.boot.domain.entity.Board;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.HashMap;

@Mapper
public interface BoardMapper {
    //@Param("board")은 xml에서의 파라미터명입니다.
    void create(@Param("board") Board board);
}
