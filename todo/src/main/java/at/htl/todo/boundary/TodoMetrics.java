package at.htl.todo.boundary;

import org.eclipse.microprofile.metrics.MetricUnits;
import org.eclipse.microprofile.metrics.annotation.Counted;
import org.eclipse.microprofile.metrics.annotation.Timed;

import at.htl.todo.control.TodoDao;

import javax.inject.Inject;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;

@Path("/")
public class TodoMetrics{

    @Inject
    TodoDao todoDao;

    @GET
    @Path("/todoLength")
    @Produces("text/plain")
    @Counted(name = "performedChecks", description = "How many checks have been performed.")
    @Timed(name = "checksTimer", description = "A measure of how long it takes to perform the check.", unit = MetricUnits.MILLISECONDS)
    public Integer getTodoLength() {
        return this.todoDao.getAll().size();
    }

};