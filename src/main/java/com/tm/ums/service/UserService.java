/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.tm.ums.service;

import com.tm.ums.delegate.DelegateFactory;
import com.tm.ums.delegate.UserDelegate;
import com.tm.ums.model.User;
import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;


/**
 *
 * @author Sohail Ahmad
 */

@Path("/user")
public class UserService {

    UserDelegate userDelegate;

    public UserService() {
        this.userDelegate = DelegateFactory.getUserDelegate();
    }
    
    @POST    
    @Consumes(MediaType.APPLICATION_XML)
    @Produces(MediaType.TEXT_PLAIN)
    public String createUser(User user) {
        return userDelegate.createUser(user)+"";
    }

    @GET
    @Path("/{id}")
    @Produces(MediaType.APPLICATION_XML)
    public User readUser(@PathParam("id")Long id) {
        return userDelegate.readUser(id);
    }

    @PUT
    @Path("/{id}")
    @Consumes(MediaType.APPLICATION_XML)
    @Produces(MediaType.TEXT_PLAIN)
    public String updateUser(User user) {
        return userDelegate.updateUser(user)+"";
    }

    @DELETE
    @Path("/{id}")
    @Produces(MediaType.TEXT_PLAIN)
    public String deleteUser(@PathParam("id")Long id) {
        return userDelegate.deleteUser(id)+"";
    }
    
//    @GET
//    @Path("/{msg}")
//    @Produces(MediaType.TEXT_PLAIN)
//    public String getMsg(@PathParam("msg") String msg) {
//
//        return "You sent:"+msg;
//    }
}
