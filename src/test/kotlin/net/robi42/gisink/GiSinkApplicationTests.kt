package net.robi42.gisink

import org.assertj.core.api.Assertions.assertThat
import org.junit.Test
import org.junit.runner.RunWith
import org.springframework.boot.test.context.SpringBootTest
import org.springframework.cloud.stream.annotation.Bindings
import org.springframework.cloud.stream.messaging.Sink
import org.springframework.test.context.ActiveProfiles
import org.springframework.test.context.junit4.SpringRunner
import javax.inject.Inject

@ActiveProfiles("test")
@RunWith(SpringRunner::class)
@SpringBootTest class GiSinkApplicationTests {

    @Inject
    @Bindings(LoggingSink::class)
    @Suppress("SpringKotlinAutowiring")
    private lateinit var sink: Sink

    @Test fun `context loads`() {}

    @Test fun `wires up sink input channel`() {
        assertThat(sink.input()).isNotNull()
    }

}
