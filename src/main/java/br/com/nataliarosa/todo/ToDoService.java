package br.com.nataliarosa.todo;

import org.springframework.stereotype.Service;

@Service
public class ToDoService {

    private final ToDoRepository taskRepository;

    public ToDoService(ToDoRepository taskRepository) { this.taskRepository = taskRepository; }

    public ToDo findOne(Integer id){
        return taskRepository.findOne( id );
    }
}
