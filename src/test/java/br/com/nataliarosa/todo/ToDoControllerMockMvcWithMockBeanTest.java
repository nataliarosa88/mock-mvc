package br.com.nataliarosa.todo;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.mock.mockito.MockBean;

import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

class ToDoControllerMockMvcWithMockBeanTest extends ToDoControllerCommonsTest {

    @MockBean
    protected ToDoRepository taskRepository;

    @Test
    void findsTaskById() throws Exception {

        when( taskRepository.findOne( 1 ) ).thenReturn( generateOneTask() );

        mockMvc.perform( get( "/tasks/1" ) )
                .andDo( print() )
                .andExpect( status().isOk() )
                .andExpect( content().json( getJsonContent( ONE_TASK_COMPLETED_JSON, ToDo.class ) ) );
    }
}