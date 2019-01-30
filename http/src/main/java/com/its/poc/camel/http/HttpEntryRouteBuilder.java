package com.its.poc.camel.http;

import org.apache.camel.builder.RouteBuilder;

public class HttpEntryRouteBuilder extends RouteBuilder {

    @Override
    public void configure() throws Exception {
        from("jetty:http://0.0.0.0:9090/its")
                .id("http-entry-route")
                .convertBodyTo(String.class)
                .to("jms:queue:ITS_REQ?connectionFactory=itsCF&replyTo=ITS_RSP");
    }

}
