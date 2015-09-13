package train.domain.service.todo;

import java.util.Collection;

import train.domain.model.Todo;

public interface TodoService {
	Collection<Todo> findAll();

	Todo create(Todo todo);

	Todo finish(String todoId);

	void delete(String todoId);
}
