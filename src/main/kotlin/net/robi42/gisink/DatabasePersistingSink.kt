package net.robi42.gisink

import org.springframework.cloud.stream.annotation.EnableBinding
import org.springframework.cloud.stream.annotation.StreamListener
import org.springframework.cloud.stream.messaging.Sink
import org.springframework.data.repository.CrudRepository
import org.springframework.stereotype.Repository
import java.time.Instant
import javax.persistence.Entity
import javax.persistence.GeneratedValue
import javax.persistence.Id

@EnableBinding(Sink::class)
class DatabasePersistingSink(private val repository: GreetingRepository) {

    private val log by logger()

    @StreamListener(Sink.INPUT)
    fun store(greeting: GreetingDto) {
        log.info("Received: '{}'", greeting)

        repository.save(Greeting(
                text = greeting.text,
                timestamp = greeting.timestamp
        ))
        log.debug("So far, stored {} greetings", repository.count())
    }

}

data class GreetingDto(
        val text: String,
        val timestamp: Instant
)

@Entity data class Greeting(
        @GeneratedValue
        @Id val id: Long? = null,
        val text: String,
        val timestamp: Instant
)

@Repository interface GreetingRepository : CrudRepository<Greeting, Long>
