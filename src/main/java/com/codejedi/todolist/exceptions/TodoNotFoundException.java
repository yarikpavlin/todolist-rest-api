package com.codejedi.todolist.exceptions;

import org.bson.types.ObjectId;

public class TodoNotFoundException extends RuntimeException {
    public TodoNotFoundException(ObjectId id) {
        super("Todo with id: " + id + " not found");
    }
}
