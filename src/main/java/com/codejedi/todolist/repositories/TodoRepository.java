package com.codejedi.todolist.repositories;

import com.codejedi.todolist.models.Todo;
import org.bson.types.ObjectId;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TodoRepository extends MongoRepository<Todo, ObjectId> {
}
