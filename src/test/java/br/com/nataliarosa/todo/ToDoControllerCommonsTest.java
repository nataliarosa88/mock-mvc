package br.com.nataliarosa.todo;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.web.servlet.MockMvc;

import java.io.File;
import java.io.IOException;

@SpringBootTest
@AutoConfigureMockMvc
public class ToDoControllerCommonsTest {

    protected static final String ONE_TASK_COMPLETED_JSON = "src/test/resources/one-todo-completed.json";
    protected static final String ONE_TASK_NOT_COMPLETED_JSON = "src/test/resources/one-task-not-completed.json";

    @Autowired
    protected MockMvc mockMvc;

    protected String getJsonContent( String path, Class< ? > clazz) throws IOException {
        ObjectMapper om = new ObjectMapper(  );
        return om.writeValueAsString( om.readValue( new File( path ), clazz ) );
    }

    protected ToDo generateOneTask() {
        ToDo taskToReturn = new ToDo();
        taskToReturn.setId( 1 );
        taskToReturn.setTitle( "delectus aut autem" );
        taskToReturn.setCompleted( true );
        taskToReturn.setUserId( 1 );
        return taskToReturn;
    }
}
