/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.tm.ums.service.filters;

import javax.ws.rs.container.ContainerRequestContext;
import javax.ws.rs.container.ContainerRequestFilter;
import javax.ws.rs.core.Response;
import javax.ws.rs.ext.Provider;

/**
 *
 * @author Imran
 */
@Provider
public class CheckRequestFilter implements ContainerRequestFilter {

    @Override
    public void filter(ContainerRequestContext requestContext) {
        System.out.println("request filter");
        if (requestContext.getHeaders().get("Client-Name") == null) {
            requestContext.abortWith(
                    Response.status(Response.Status.BAD_REQUEST)
                    .entity("Client-Name header must be defined.")
                    .build());
            
        }
        
    }
}
