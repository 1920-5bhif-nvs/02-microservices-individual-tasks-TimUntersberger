package at.htl.todo.control;

import java.util.List;

import javax.inject.Inject;
import javax.inject.Singleton;
import javax.persistence.EntityManager;

import at.htl.todo.entity.Todo;

@Singleton
public class TodoDao {
    @Inject
    EntityManager em;

    public List<Todo> getAll() {
        return this.em.createNamedQuery("Todo.findAll", Todo.class).getResultList();
    }

    public void create(String text) {
        this.em.persist(new Todo(text, false));
        this.em.flush();
    }

    public void toggle(Integer id) {
        Todo todo = this.em.find(Todo.class, id);
        todo.toggleIsDone();
        this.em.persist(todo);
        this.em.flush();
    }
}