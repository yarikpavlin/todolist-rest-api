package com.codejedi.todolist.services;

import com.codejedi.todolist.models.Todo;
import org.bson.types.ObjectId;

import java.util.List;

public interface ITodoService {
    public List<Todo> getAll();

    public Todo getById(ObjectId id);

    public Todo create(Todo todo);

    public Todo update(Todo todo);

    public void delete(ObjectId id);
}
