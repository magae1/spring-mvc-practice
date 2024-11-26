package org.conan.utils;

import lombok.Setter;
import lombok.extern.log4j.Log4j;
import org.conan.domain.Board;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.springframework.test.util.AssertionErrors.fail;

import org.conan.service.BoardService;


@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("file:src/main/webapp/WEB-INF/spring/root-context.xml")
@Log4j
public class BoardServiceTest {
    @Setter(onMethod_ = {@Autowired})
    private BoardService boardService;

    @Test
    public void testInit()  {
        System.out.println(boardService);
        assertNotNull(boardService);
    }

    @Test
    public void testGetAllBoards() {
        boardService.getAllBoards().forEach(System.out::println);
    }

    @Test
    public void testWrite() {
        Board board = new Board();
        board.setTitle("새새새로운 제목");
        board.setContent("새새새로운 내용");
        board.setWriter("newnewbie");
        boardService.write(board);
        System.out.println("생성된 게시물의 번호: "+board.getBno());
    }

    @Test
    public void testRead() {
        System.out.println(boardService.read(6).getTitle());
    }

    @Test
    public void testDelete() {
        System.out.println("REMOVED: " + boardService.remove(6));
    }

    @Test
    public void testModify() {
        Board board = boardService.read(17);
        if (board == null) {
            fail("찾을 수 없는 레코드입니다.");
        }
        board.setTitle("수정된 제목");
        System.out.println("MODIFY: " + boardService.modify(board));
    }
}
