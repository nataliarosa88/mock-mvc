package br.com.nataliarosa.todo;

import org.junit.jupiter.api.Test;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

class ToDoControllerMockMvcTest extends ToDoControllerCommonsTest {

    @Test
    void findsTaskById() throws Exception {
        mockMvc.perform( get( "/tasks/1" ) )
                .andDo( print() )
                .andExpect( status().isOk() )
                .andExpect( content().json( getJsonContent( ONE_TASK_NOT_COMPLETED_JSON, ToDo.class ) ) );
    }
}