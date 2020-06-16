package br.com.guilhermealvessilve.security.jpa.resource;

import br.com.guilhermealvessilve.security.jpa.data.UserInfo;

import javax.annotation.security.PermitAll;
import javax.annotation.security.RolesAllowed;
import javax.enterprise.context.RequestScoped;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.SecurityContext;

@Path("/jdbc")
@RequestScoped
@Produces(MediaType.APPLICATION_JSON)
public class JDBCUserProfileResource {

    @GET
    @Path("/user")
    @RolesAllowed({"user", "admin"})
    public UserInfo getUserInfo(@Context SecurityContext context) {
        return new UserInfo(
                "Name",
                context.getUserPrincipal().getName(),
                "12/08/2000"
        );
    }

    @GET
    @Path("/admin")
    @RolesAllowed("admin")
    public UserInfo getAdminInfo(@Context SecurityContext context) {
        return new UserInfo(
                "Admin",
                context.getUserPrincipal().getName(),
                "07/02/1988"
        );
    }

    @GET
    @PermitAll
    @Path("/public")
    public UserInfo getInfo() {
        return new UserInfo(
                "Public",
                "Public",
                "00/00/0000"
        );
    }
}
