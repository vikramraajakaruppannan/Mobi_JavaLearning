package com.example.todoapplication;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class TodoService {
    private final TodoRepository todoRepository;

    public TodoService(TodoRepository todoRepository){
        this.todoRepository = todoRepository;
    }

    public Todo request(Todo todo){
        return todoRepository.save(todo);
    }

    public List<Todo> getalltodos(){
        return todoRepository.findAll();
    }

    public Todo fetchbyid(long id){
        return todoRepository.findById(id).orElse(null);
    }

    public Todo updatebyid(long id, Todo newtodo){
        Todo existing =fetchbyid(id);
        if(existing!=null){
            existing.setTitle(newtodo.getTitle());
            existing.setDescription(newtodo.getDescription());
//            existing.setCreatedAt(newtodo.getCreatedAt());
            return todoRepository.save(existing);
        }
        return null;
    }

    public String deletebyid(long id){
        if(todoRepository.existsById(id)){
            todoRepository.deleteById(id);
            return "deleted";
        }
        return "cannot process the request";
    }

    public Todo completestatus(long id,Todo newtodo){
        Todo existing =todoRepository.findById(id).orElse(null);
        if(existing!=null) {
            existing.setCompleted(newtodo.isCompleted());
            return todoRepository.save(existing);
        }
        return null;
    }

    
}
