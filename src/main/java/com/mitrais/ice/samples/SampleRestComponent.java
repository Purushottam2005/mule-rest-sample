package com.mitrais.ice.samples;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;

import org.apache.log4j.Logger;
/**
 * 
 * Gama Ogi Prayogo (gamaogi.prayogo@mitrais.com)
 *
 */
@Path("/")
public class SampleRestComponent {
	Logger log = Logger.getLogger(SampleRestComponent.class);
	
	@GET
	@Path ("greet/{name}/{age}")
	@Produces ("text/plain")
	public String greet(@PathParam("name") String name, @PathParam ("age") String age){			
		log.debug("name :" + name +", age:" + age);
		MuleThreadLocalHolder.remove(); // to avoid memory leak due unclosed thread
		return "pret, " + name +", age " + age;
	}
}
