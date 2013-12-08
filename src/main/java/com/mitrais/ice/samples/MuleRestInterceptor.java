package com.mitrais.ice.samples;

import org.mule.api.MuleEvent;
import org.mule.api.MuleException;
import org.mule.api.construct.FlowConstruct;
import org.mule.api.processor.MessageProcessor;
import org.mule.interceptor.AbstractEnvelopeInterceptor;
import org.mule.management.stats.ProcessingTime;

import com.mitrais.ice.samples.MuleThreadLocalHolder;
/**
 * 
 * @author Gama Ogi Prayogo (gamaogi.prayogo@mitrais.com)
 *
 */
public class MuleRestInterceptor extends AbstractEnvelopeInterceptor {
	public MuleRestInterceptor() {
		super();
	}

	public MuleRestInterceptor(MessageProcessor next, FlowConstruct fc) {
		setListener(next);
		setFlowConstruct(fc);
	}

	@Override
	public MuleEvent before(MuleEvent event) throws MuleException {
		MuleThreadLocalHolder.set(event);
		return event;
	}

	@Override
	public MuleEvent after(MuleEvent event) throws MuleException {
		MuleThreadLocalHolder.remove();
		return event;
	}

	@Override
	public MuleEvent last(MuleEvent event, ProcessingTime time, long startTime,
			              boolean exceptionWasThrown) throws MuleException {
		MuleThreadLocalHolder.remove();
		return event;
	}
}
