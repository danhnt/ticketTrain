package train.domain.repository.todo;

import java.util.Collection;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

import org.springframework.stereotype.Repository;

import train.domain.model.Todo;

@Repository()
public class TodoRepositoryImpl implements TodoRepository {

	private static final Map<String, Todo> TODO_MAP = new ConcurrentHashMap<String, Todo>();

	public Todo findOne(String todoId) {
		return TODO_MAP.get(todoId);
	}

	public Collection<Todo> findAll() {
		return TODO_MAP.values();
	}

	public void create(Todo todo) {
		TODO_MAP.put(todo.getTodoId(), todo);
	}

	public boolean update(Todo todo) {
		TODO_MAP.put(todo.getTodoId(), todo);
		return true;
	}

	public void delete(Todo todo) {
		TODO_MAP.remove(todo.getTodoId());

	}

	public long countByFinished(boolean finished) {
		long count = 0;
		for (Todo todo : TODO_MAP.values()) {
			if (finished == todo.isFinished()) {
				count++;
			}
		}
		return count;
	}

}
