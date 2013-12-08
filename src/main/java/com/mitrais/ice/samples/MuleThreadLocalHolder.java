package com.mitrais.ice.samples;

import org.mule.api.MuleEvent;

/**
 * 
 * @author Gama Ogi Prayogo (gamaogi.prayogo@mitrais.com)
 *
 */
public class MuleThreadLocalHolder {
    public static final ThreadLocal<MuleEvent> MULE_EVENT_THREAD_LOCAL = new ThreadLocal<MuleEvent>();
    
    public static void set(MuleEvent event) {
        MULE_EVENT_THREAD_LOCAL.set(event);
    }
    
    public static MuleEvent get() {
        return MULE_EVENT_THREAD_LOCAL.get();
    }
    
    public static void remove() {
        MULE_EVENT_THREAD_LOCAL.remove();
    }
    
}