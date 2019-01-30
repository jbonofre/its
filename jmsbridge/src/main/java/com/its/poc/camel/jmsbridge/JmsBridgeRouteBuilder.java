package com.its.poc.camel.jmsbridge;

import org.apache.camel.Exchange;
import org.apache.camel.Processor;
import org.apache.camel.builder.RouteBuilder;

public class JmsBridgeRouteBuilder extends RouteBuilder {

    @Override
    public void configure() throws Exception {
        from("jms:queue:ITS_REQ?connectionFactory=itsCF")
                .id("its-rsp-route")
                .process(new Processor() {
                    public void process(Exchange exchange) throws Exception {
                        exchange.getOut().setBody("Hello ITS", String.class);
                    }
                })
                .to("jms:queue:ITS_RSP?connectionFactory=itsCF&disableReplyTo=true");
    }

}
