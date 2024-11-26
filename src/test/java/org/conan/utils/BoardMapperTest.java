package org.conan.utils;

import lombok.Setter;
import lombok.extern.log4j.Log4j;
import org.conan.domain.Board;
import org.conan.mapper.BoardMapper ;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;


@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("file:src/main/webapp/WEB-INF/spring/root-context.xml")
@Log4j
public class BoardMapperTest {
    @Setter(onMethod_ = {@Autowired})
    private BoardMapper boardMapper;

    @Test
    public void testGetBoardList()  {
        boardMapper.getBoardList().forEach(System.out::println);
    }

    @Test
    public void testInsert() {
        Board board = new Board();
        board.setTitle("새 제목");
        board.setContent("새 내용");
        board.setWriter("newbie");
        int result = boardMapper.insert(board);
        System.out.println("result: " +result);
        System.out.println(board);
    }

    @Test
    public void testInsertSelectKey() {
        Board board = new Board();
        board.setTitle("새 제목");
        board.setContent("새 내용");
        board.setWriter("newbie");
        boardMapper.insertSelectKey(board);
        System.out.println(board);
    }

    @Test
    public void testRead() {
        Board board =boardMapper.read(5);
        System.out.println(board);
    }

    @Test
    public void testIncreaseHit() {
        int bno = 5;
        boardMapper.increaseHit(bno);
        Board board = boardMapper.read(bno);
        System.out.println(board);
    }

    @Test
    public void testDelete() {
        int r = boardMapper.delete(5);
        System.out.println("DELETING COUNT: " + r);
    }

    @Test
    public void testUpdate() {
        Board board = new Board();
        board.setBno(2);
        board.setTitle("수정한 제목");
        board.setContent("수정한 내용");
        int r = boardMapper.update(board);
        System.out.println("UPDATING COUNT: " + r);
    }
}
