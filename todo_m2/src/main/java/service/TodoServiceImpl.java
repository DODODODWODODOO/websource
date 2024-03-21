package service;

import java.util.List;

import dao.TodoDao;
import dto.TodoDto;

public class TodoServiceImpl implements TodoService {

    TodoDao dao = new TodoDao();

    @Override
    public List<TodoDto> list() {
        return dao.getList();
    }

    @Override
    public TodoDto getRow(String no) {
        return dao.getRow(no);
    }

    @Override
    public boolean insert(TodoDto insertDto) {
        // 결과가 1 이면 true, 아니면 false
        // boolean flag = dao.insert(insertDto)==1?true:false;
        // return flag;
        return dao.insert(insertDto) == 1;
    }

    @Override
    public boolean update(TodoDto updateDto) {
        return dao.update(updateDto) == 1;
    }

    @Override
    public boolean delete(String no) {
        return dao.delete(no) == 1;
    }

}
