package com.codejedi.todolist.services;

import com.codejedi.todolist.exceptions.TodoNotFoundException;
import com.codejedi.todolist.models.Todo;
import com.codejedi.todolist.repositories.TodoRepository;
import org.bson.types.ObjectId;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class TodoService implements ITodoService{
    @Autowired
    private TodoRepository todoRepository;

    @Override
    public List<Todo> getAll() {
        return todoRepository.findAll();
    }

    @Override
    public Todo getById(ObjectId id) throws TodoNotFoundException{
        return todoRepository.findById(id).orElseThrow(() -> new TodoNotFoundException(id));
    }

    @Override
    public Todo create(Todo todo) {
        return todoRepository.insert(todo);
    }

    @Override
    public Todo update(Todo todo) {
        Todo dbTodo = this.getById(todo.getId());
        dbTodo.setTitle(todo.getTitle());
        dbTodo.setDone(todo.isDone());
        return todoRepository.save(dbTodo);
    }

    @Override
    public void delete(ObjectId id) {
        this.getById(id);
        todoRepository.deleteById(id);
    }
}
