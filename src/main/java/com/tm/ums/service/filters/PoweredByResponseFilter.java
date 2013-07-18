/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.tm.ums.service.filters;

import javax.ws.rs.container.ContainerRequestContext;
import javax.ws.rs.container.ContainerResponseContext;
import javax.ws.rs.container.ContainerResponseFilter;
import javax.ws.rs.ext.Provider;

/**
 *
 * @author Imran
 */
@Provider
public class PoweredByResponseFilter implements ContainerResponseFilter {

    @Override
    public void filter(ContainerRequestContext requestContext, ContainerResponseContext responseContext) {
        responseContext.getHeaders().add("X-Powered-By", "True Meridian");
    }
}
