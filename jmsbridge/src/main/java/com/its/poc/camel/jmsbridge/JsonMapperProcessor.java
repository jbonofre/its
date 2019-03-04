package com.its.poc.camel.jmsbridge;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.apache.camel.Exchange;
import org.apache.camel.Processor;

public class JsonMapperProcessor implements Processor {

    private ObjectMapper objectMapper = new ObjectMapper();

    @Override
    public void process(Exchange exchange) throws Exception {
        String json = exchange.getIn().getBody(String.class);
        CanonicalModel model = objectMapper.readValue(json, CanonicalModel.class);
        exchange.getIn().setBody(model, CanonicalModel.class);
    }

}
