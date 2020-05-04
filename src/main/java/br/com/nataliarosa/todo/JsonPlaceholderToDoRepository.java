package br.com.nataliarosa.todo;

import br.com.nataliarosa.config.JsonPlaceholderConfigProperties;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpMethod;
import org.springframework.web.client.RestTemplate;

import java.util.List;

public class JsonPlaceholderToDoRepository implements ToDoRepository {

    private final RestTemplate restTemplate;
    private final JsonPlaceholderConfigProperties properties;

    public JsonPlaceholderToDoRepository( RestTemplate restTemplate, JsonPlaceholderConfigProperties properties ) {
        this.restTemplate = restTemplate;
        this.properties = properties;
    }

    @Override
    public ToDo findOne( Integer id ) {
        return restTemplate
                .getForObject( "/todos/{id}", ToDo.class, id );
    }

    @Override
    public List< ToDo > findAll() {
        return restTemplate
                .exchange( "/todos?_sort={sort}&_order={order}&_limit={limit}",
                        HttpMethod.GET,
                        null,
                        new ParameterizedTypeReference< List< ToDo > >() {
                        },
                        properties.getTodoFindAll().getSort(),
                        properties.getTodoFindAll().getOrder(),
                        properties.getTodoFindAll().getLimit() )
                .getBody();
    }

    @Override
    public List< ToDo > findByTitle( String title ) {
        return restTemplate
                .exchange( "/todos?title_like={title}", HttpMethod.GET, null, new ParameterizedTypeReference< List< ToDo > >() {
                }, title )
                .getBody();
    }
}
