package org.conan.service;

import java.util.List;

import lombok.Setter;
import lombok.extern.log4j.Log4j;
import org.conan.domain.Board;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import org.conan.mapper.BoardMapper;


@Log4j
@Service
public class BoardService {
    @Setter(onMethod_ = {@Autowired})
    private BoardMapper boardMapper;

    public List<Board> getAllBoards() {
        log.info("getAllBoards");
        return boardMapper.getBoardList();
    }

    public void write(Board board) {
        log.info("write: " + board);
        boardMapper.insert(board);
    }

    public Board read(Integer bno) {
        log.info("read: " + bno);
        return boardMapper.read(bno);
    }

    public boolean modify(Board board) {
        log.info("modify: " + board);
        return boardMapper.update(board) == 1;
    }

    public boolean remove(Integer bno) {
        log.info("remove: " + bno);
        return boardMapper.delete(bno) == 1;
    }
}

