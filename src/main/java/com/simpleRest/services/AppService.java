package com.simpleRest.services;

import org.glassfish.jersey.media.sse.SseFeature;

import javax.ws.rs.ApplicationPath;
import javax.ws.rs.core.Application;
import java.util.HashSet;
import java.util.Set;


@ApplicationPath("webServices")
public class AppService extends Application {

    @Override
    public Set<Class<?>> getClasses() {
        Set<Class<?>> classes = new HashSet<Class<?>>();
        classes.add(SimpleSSE.class);
        classes.add(SseFeature.class);
        classes.add(CtoFService.class);
        return classes;
    }

}

/*
@ApplicationPath("webServices")
public class AppService extends ResourceConfig {
    public AppService() {
        packages("com.ticCore.restServices");
    }
}
*/
