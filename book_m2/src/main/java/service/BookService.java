package service;

import java.util.List;

import dto.BookDto;
import dto.ChangeDto;
import dto.MemberDto;

public interface BookService {
    // DAO 호출
    // CRUD - 조회, 검색, 삽입, 삭제, 수정
    BookDto read(int code);

    List<BookDto> listAll();

    List<BookDto> searchListAll(String criteria, String keyword);

    boolean create(BookDto insertDto);

    boolean update(BookDto insertDto);

    boolean delete(int code);

    // Member 작업
    MemberDto login(MemberDto loginDto);

    boolean change(ChangeDto changeDto);

    boolean register(MemberDto insertDto);

}
