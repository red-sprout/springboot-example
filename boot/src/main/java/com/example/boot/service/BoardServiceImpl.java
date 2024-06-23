package com.example.boot.service;

import com.example.boot.domain.dto.BoardRequest;
import com.example.boot.domain.entity.Board;
import com.example.boot.mapper.BoardMapper;
import com.example.boot.repository.BoardRepository;
import com.example.boot.repository.BoardResponse;
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
public class BoardServiceImpl implements BoardService{

    private final BoardMapper boardMapper;
    private final BoardRepository boardRepository;

    @Override
    public Boolean create(BoardRequest.CreateDTO request) throws Exception {

        // 400 - 데이터 미입력(userId, pwd, title, contents 모두 입력해야 함)
        if(request.getUserId() == null || request.getPwd() == null ||request.getTitle() == null || request.getContents() == null)
            throw new RuntimeException("data is null");

        /*
         @Builder를 추가하면 빌더 클래스가 자동으로 생성되어 객체 생성을 보다 간편하게 할 수 있다.
         객체가 가질 필드들을 설정하는 메서드들을 체이닝 방식으로 연결하여 객체를 생성하는 패턴
         */
        try {
            Board board = Board.builder()
                    .title(request.getTitle())
                    .contents(request.getContents())
                    .userId(request.getUserId())
                    .pwd(request.getPwd())
                    .build();

            boardMapper.create(board);
        }
        catch (Exception e) {
            e.printStackTrace();
            throw new RuntimeException("insert board error");
        }
        return true;
    }

    @Override
    public List<BoardResponse> getList() throws Exception {
        List<Board> Board = boardRepository.findAllByOrderByCreateAtDesc();
        List<BoardResponse> getListDTO = new ArrayList<>();
        Board.forEach(s -> getListDTO.add(BoardResponse.GetBoardDTO(s)));
        return getListDTO;
    }
}