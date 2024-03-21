package service;

import java.util.List;

import dto.TodoDto;

// DAO 의 CRUD 메소드를 호출

public interface TodoService {
    List<TodoDto> list();

    TodoDto getRow(String no);

    boolean insert(TodoDto insertDto);

    boolean update(TodoDto updateDto);

    boolean delete(String no);
}
