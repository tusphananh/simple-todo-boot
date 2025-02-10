import com.netflix.graphql.dgs.DgsComponent;
import com.netflix.graphql.dgs.DgsQuery;
import com.netflix.graphql.dgs.DgsMutation;

import java.util.List;

@DgsComponent
public class TodoResolver {

    private final TodoService todoService;

    public TodoResolver(TodoService todoService) {
        this.todoService = todoService;
    }

    @DgsQuery
    public List<Todo> getTodos() {
        return todoService.getAllTodos();
    }

    @DgsQuery
    public Todo getTodoById(Long id) {
        return todoService.getTodoById(id);
    }

    @DgsMutation
    public Todo createTodo(String title, String description, LocalDateTime dueDate) {
        return todoService.createTodo(title, description, dueDate);
    }

    @DgsMutation
    public Todo updateTodo(Long id, String title, String description, Boolean completed) {
        return todoService.updateTodo(id, title, description, completed);
    }

    @DgsMutation
    public boolean deleteTodo(Long id) {
        return todoService.deleteTodoById(id);
    }
}
