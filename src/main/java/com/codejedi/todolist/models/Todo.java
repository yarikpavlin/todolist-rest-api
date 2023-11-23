package com.codejedi.todolist.models;

import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.fasterxml.jackson.databind.ser.std.ToStringSerializer;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.bson.types.ObjectId;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection = "todos")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Todo {
    @Id
    @JsonSerialize(using = ToStringSerializer.class)
    private ObjectId id;

    private String title;

    private boolean done;
}
