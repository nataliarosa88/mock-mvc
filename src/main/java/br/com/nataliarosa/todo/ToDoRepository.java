package br.com.nataliarosa.todo;

import java.util.List;

public interface ToDoRepository {

    ToDo findOne( Integer id );

    List< ToDo > findAll();

    List< ToDo > findByTitle( String title );
}
