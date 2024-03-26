package service;

import java.util.List;

import dao.BookDao;
import dto.BookDto;
import dto.ChangeDto;
import dto.MemberDto;

public class BookServiceImpl implements BookService {

    BookDao dao = new BookDao();

    @Override
    public BookDto read(int code) {
        return dao.getRow(code);
    }

    @Override
    public List<BookDto> listAll() {
        return dao.getList();
    }

    @Override
    public List<BookDto> searchListAll(String criteria, String keyword) {
        return dao.getSearchList(criteria, keyword);
    }

    @Override
    public boolean create(BookDto insertDto) {
        return dao.insert(insertDto) == 1;
    }

    @Override
    public boolean update(BookDto insertDto) {
        return dao.update(insertDto) == 1;
    }

    @Override
    public boolean delete(int code) {
        return dao.delete(code) == 1;
    }

    @Override
    public MemberDto login(MemberDto loginDto) {
        return dao.isLogin(loginDto);
    }

    @Override
    public boolean change(ChangeDto changeDto) {
        return dao.passwordChange(changeDto) == 1;
    }

    @Override
    public boolean register(MemberDto insertDto) {
        return dao.register(insertDto) == 1;
    }

    @Override
    public boolean leave(MemberDto delDto) {
        return dao.memberDel(delDto) == 1;
    }

}
