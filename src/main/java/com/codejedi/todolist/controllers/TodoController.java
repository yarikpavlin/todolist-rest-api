package com.codejedi.todolist.controllers;

import com.codejedi.todolist.models.Todo;
import com.codejedi.todolist.services.TodoService;
import org.bson.types.ObjectId;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/todos")
public class TodoController {
    @Autowired
    private TodoService todoService;

    @GetMapping
    public ResponseEntity<List<Todo>> allTodos() {
        return new ResponseEntity<List<Todo>>(todoService.getAllTodos(), HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<Todo> saveTodo(@RequestBody Todo newTodo) {
        return new ResponseEntity<Todo>(todoService.saveTodo(newTodo), HttpStatus.OK);
    }

    @PutMapping
    public ResponseEntity<Todo> updateTodo(@RequestBody Todo updatedTodo) {
        return new ResponseEntity<Todo>(todoService.updateTodo(updatedTodo), HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<ObjectId> deleteTodo(@PathVariable ObjectId id) {
        todoService.deleteTodo(id);
        return new ResponseEntity<ObjectId>(id, HttpStatus.OK);
    }
}
