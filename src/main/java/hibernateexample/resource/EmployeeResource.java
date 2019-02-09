package hibernateexample.resource;

import javax.ws.rs.DefaultValue;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.Response;

import hibernateexample.Manager.EmployeeManager;
import hibernateexample.TO.EmployeeTO;
import hibernateexample.Utils.HibernateUtil;
import hibernateexample.resourcehelper.EmployeeResourceHelper;

import org.hibernate.Session;

@Path("/employee")
public class EmployeeResource {	
	@GET
    @Path("/create")
    public Response responseMsg( @PathParam("parameter") String parameter,
      @DefaultValue("Nothing to say") @QueryParam("value") String value) {
		EmployeeResourceHelper employeeResourceHelper = new EmployeeResourceHelper();
        String output = employeeResourceHelper.create();
          return Response.status(200).entity(output).build();
       }
}
