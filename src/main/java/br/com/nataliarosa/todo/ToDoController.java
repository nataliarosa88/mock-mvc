package br.com.nataliarosa.todo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
class ToDoController {

    @Autowired
    public  ToDoRepository taskRepository;

    @Autowired
    public ToDoService taskService;

    @GetMapping( "/tasks/{id}" )
    ToDo findOne( @PathVariable Integer id ) {
        return taskService.findOne( id );
    }

    @GetMapping( "/tasks" )
    List< ToDo > findAll() {
        return taskRepository.findAll();
    }

    @GetMapping( value = "/tasks", params = "title" )
    List< ToDo > findByTitle( String title ) {
        return taskRepository.findByTitle( title );
    }
}
