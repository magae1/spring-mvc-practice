package org.conan.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Select;
import org.conan.domain.Board;


public interface BoardMapper {
//    @Select("SELECT * FROM BOARD WHERE BNO > 0")
    public List<Board> getBoardList();
    public int insert (Board board);
    public int insertSelectKey(Board board);
    public Board read(int bno);
    public int increaseHit(int bno);
    public int delete(int bno);
    public int update(Board board);
}
