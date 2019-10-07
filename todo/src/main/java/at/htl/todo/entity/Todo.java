package at.htl.todo.entity;

import javax.persistence.*;

@Entity()
@NamedQueries({
	@NamedQuery(name = "Todo.findAll", query = "select t from Todo t")
})
public class Todo{
	@Id()
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
	@Column(name = "text")
	private String text;
	@Column(name = "is_done")
    private Boolean isDone;

	public String getText() {
		return text;
	}
	public void setText(String text) {
		this.text = text;
	}
	public Boolean getIsDone() {
		return isDone;
	}
	public void setIsDone(Boolean isDone) {
		this.isDone = isDone;
	}
	public void toggleIsDone() {
		this.isDone = !this.isDone;
	}

	public Todo(String text, Boolean isDone) {
		this.text = text;
		this.isDone = isDone;
	}

    
}