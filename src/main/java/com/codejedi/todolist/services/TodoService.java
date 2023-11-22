package com.codejedi.todolist.services;

import com.codejedi.todolist.exceptions.TodoNotFoundException;
import com.codejedi.todolist.models.Todo;
import com.codejedi.todolist.repositories.TodoRepository;
import org.bson.types.ObjectId;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class TodoService {
    @Autowired
    private TodoRepository todoRepository;

    public List<Todo> getAllTodos() {
        return todoRepository.findAll();
    }

    public Todo getTodoById(ObjectId id) {
        return todoRepository.findById(id).orElseThrow(() -> new TodoNotFoundException(id));
    }

    public Todo saveTodo(Todo newTodo) {
        return todoRepository.insert(newTodo);
    }

    public Todo updateTodo(Todo updatedTodo) {
        Todo todoFromDB = this.getTodoById(updatedTodo.getId());
        todoFromDB.setTitle(updatedTodo.getTitle());
        todoFromDB.setDone(updatedTodo.isDone());
        return todoRepository.save(todoFromDB);
    }

    public void deleteTodo(ObjectId id) {
        todoRepository.deleteById(id);
    }
}
