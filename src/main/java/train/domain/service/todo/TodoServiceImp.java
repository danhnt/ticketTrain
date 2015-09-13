package train.domain.service.todo;

import java.util.Collection;
import java.util.Date;
import java.util.UUID;

import javax.inject.Inject;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import train.domain.model.Todo;
import train.domain.repository.todo.TodoRepository;

@Service
@Transactional
public class TodoServiceImp implements TodoService {

	@Inject
	TodoRepository todoRepository;
	private static final long MAX_UNFINISHED_COUNT = 5;

	public Todo findOne(String todoId) {
		Todo todo = todoRepository.findOne(todoId);
		if (todo == null) {
			String messages = "[E404] The requested Todo is not found. (id="
					+ todoId + ")";
			try {
				throw new Exception(messages);
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		return todo;
	}

	@Transactional(readOnly = true)
	public Collection<Todo> findAll() {
		return todoRepository.findAll();
	}

	public Todo create(Todo todo) {
		long unfinishedCount = todoRepository.countByFinished(false);
		if (unfinishedCount >= MAX_UNFINISHED_COUNT) {
			String messages = "The count of un-finished Todo must not be over "
					+ MAX_UNFINISHED_COUNT + ".";
		}

		String todoId = UUID.randomUUID().toString();
		Date createdAt = new Date();

		todo.setTodoId(todoId);
		todo.setCreatedAt(createdAt);
		todo.setFinished(false);

		todoRepository.create(todo);

		return todo;
	}

	public Todo finish(String todoId) {
		Todo todo = findOne(todoId);
		if (todo.isFinished()) {
			String messages = "The requested Todo is already finished. (id="
					+ todoId + ")";
		}
		todo.setFinished(true);
		todoRepository.update(todo);

		return todo;
	}

	public void delete(String todoId) {
		Todo todo = findOne(todoId);
		todoRepository.delete(todo);
	}

}
