package net.robi42.gisink

import org.springframework.cloud.stream.annotation.EnableBinding
import org.springframework.cloud.stream.annotation.StreamListener
import org.springframework.cloud.stream.messaging.Sink

@EnableBinding(Sink::class)
class LoggingSink {

    private val log by logger()

    @StreamListener(Sink.INPUT)
    fun log(greeting: Greeting) {
        log.info("Received: '$greeting'")
    }

}
