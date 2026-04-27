package com.example.todoapplication;

import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class TodoController {
    private final TodoService todoService;

    public TodoController(TodoService todoService){
        this.todoService = todoService;
    }

    @PostMapping("/todos")
    public Todo requestcreate(@RequestBody Todo todo){
        return todoService.request(todo);
    }

    @GetMapping("/todos")
    public List<Todo> getall(){
        return todoService.getalltodos();
    }

    @GetMapping("/todos/{id}")
    public Todo fetchbyid(@PathVariable long id){
        return todoService.fetchbyid(id);
    }

    @PutMapping("/todos/{id}")
    public Todo updatebyid(@PathVariable long id, @RequestBody Todo todo){
        return todoService.updatebyid(id,todo);
    }

    @DeleteMapping("/todos/{id}")
    public String deletebyid(@PathVariable long id){
        return todoService.deletebyid(id);
    }

    @PatchMapping("/todos/{id}/completed")
    public Todo status(@PathVariable long id, @RequestBody Todo todo){
        return todoService.completestatus(id, todo);
    }
}
