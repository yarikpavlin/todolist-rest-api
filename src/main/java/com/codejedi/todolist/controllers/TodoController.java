package com.codejedi.todolist.controllers;

import com.codejedi.todolist.models.Todo;
import com.codejedi.todolist.services.TodoService;
import org.bson.types.ObjectId;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(
        value = "/api/v1/todos",
        consumes = MediaType.APPLICATION_JSON_VALUE,
        produces = MediaType.APPLICATION_JSON_VALUE
)
public class TodoController {
    @Autowired
    private TodoService todoService;

    @GetMapping
    public ResponseEntity<List<Todo>> allTodos() {
        return new ResponseEntity<>(todoService.getAll(), HttpStatus.OK);
    }

    @GetMapping(value = "/{id}")
    public ResponseEntity<Todo> getTodo(@PathVariable ObjectId id) {
        return new ResponseEntity<>(todoService.getById(id), HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<Todo> saveTodo(@RequestBody Todo newTodo) {
        return new ResponseEntity<>(todoService.create(newTodo), HttpStatus.CREATED);
    }

    @PutMapping
    public ResponseEntity<Todo> updateTodo(@RequestBody Todo updatedTodo) {
        return new ResponseEntity<>(todoService.update(updatedTodo), HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteTodo(@PathVariable ObjectId id) {
        todoService.delete(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }

    // TODO Add exception handler later
}
