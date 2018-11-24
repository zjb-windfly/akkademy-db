package com.akkademy;

import akka.actor.AbstractActor;
import akka.event.Logging;
import akka.event.LoggingAdapter;
import akka.japi.pf.ReceiveBuilder;
import com.akkademy.messages.SetRequest;

import java.util.HashMap;
import java.util.Map;

/**
 * @author Joel
 * @create 2018-11-24 20:21
 **/
public class AkkademyDb extends AbstractActor {
    protected final LoggingAdapter log = Logging.getLogger(context().system(), this);
    protected final Map<String, Object> map = new HashMap<>();

    @Override
    public Receive createReceive() {
        return ReceiveBuilder.create().match(SetRequest.class, message -> {
            log.info("Received Set request: {}", message);
            map.put(message.getKey(), message.getValue());
        }).matchAny(o -> {
            log.info("received unknown message: {}", o);
        }).build();
    }
}