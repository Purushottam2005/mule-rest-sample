package com.mitrais.ice.samples;

import org.mule.api.MuleEventContext;
import org.mule.api.MuleMessage;
import org.mule.api.lifecycle.Callable;

import com.sun.jersey.spi.container.ContainerResponse;
/**
 * 
 * Gama Ogi Prayogo (gamaogi.prayogo@mitrais.com)
 *
 */
public class SampleJavaConvertingInboundMessage implements Callable{

	@Override
	public Object onCall(MuleEventContext eventContext) throws Exception {
		MuleMessage message = eventContext.getMessage();
		ContainerResponse cr  = message.getInvocationProperty("jersey_response");
		String messageString = (String) cr.getResponse().getEntity();
		return messageString;
	}
}
