package net.robi42.gisink

import org.slf4j.LoggerFactory.getLogger
import org.springframework.boot.SpringApplication
import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.autoconfigure.domain.EntityScan
import org.springframework.data.jpa.convert.threeten.Jsr310JpaConverters
import kotlin.reflect.full.companionObject

fun main(args: Array<String>) {
    SpringApplication.run(GiSinkApplication::class.java, *args)
}

@EntityScan(
        basePackageClasses = arrayOf(GiSinkApplication::class, Jsr310JpaConverters::class)
)
@SpringBootApplication
class GiSinkApplication


/** @see <https://stackoverflow.com/a/34462577/6079644> */
internal fun <R : Any> R.logger() = lazy { getLogger(unwrapCompanionClass(this::class.java).name) }

private fun <T : Any> unwrapCompanionClass(ofClass: Class<T>) =
        if (ofClass.enclosingClass != null && ofClass.enclosingClass.kotlin.companionObject?.java == ofClass)
            ofClass.enclosingClass
        else
            ofClass
