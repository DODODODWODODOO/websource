package service;

import java.util.List;

import dao.BoardDao;
import dto.BoardDto;

public class BoardServiceImpl implements BoardService {

    BoardDao dao = new BoardDao();

    @Override
    public List<BoardDto> list() {
        return dao.getList();
    }

    @Override
    public boolean insert(BoardDto insertDto) {
        return dao.create(insertDto) == 1;
    }

    @Override
    public BoardDto read(int bno) {
        return dao.getRow(bno);
    }

    @Override
    public boolean update(BoardDto updateDto) {
        return dao.update(updateDto) == 1;
    }

    @Override
    public boolean delete(BoardDto deleteDto) {
        return dao.delete(deleteDto) == 1;
    }

    @Override
    public boolean reply(BoardDto replyDto) {
        return dao.reply(replyDto) == 1;
    }

}
