package at.htl.todo.boundary;

import java.util.List;

import javax.inject.Inject;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import at.htl.todo.control.TodoDao;
import at.htl.todo.entity.Todo;

@Path("todo")
public class TodoResource {

    @Inject
    TodoDao todoDao;

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public List<Todo> getTodos(){
        return todoDao.getAll();
    }

    @POST
    public Response createTodo(@QueryParam("text") String text){
        todoDao.create(text);
        return Response.ok().build();
    }

    @POST
    @Path("toggle/{id}")
    public Response toggleTodo(@PathParam("id") Integer id){
        todoDao.toggle(id);
        return Response.ok().build();
    }

}