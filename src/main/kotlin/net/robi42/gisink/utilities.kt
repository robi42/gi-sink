package net.robi42.gisink

import org.slf4j.LoggerFactory.getLogger
import kotlin.reflect.full.companionObject

/** @see <https://stackoverflow.com/a/34462577/6079644> */
internal fun <R : Any> R.logger() = lazy { getLogger(unwrapCompanionClass(this::class.java).name) }

private fun <T : Any> unwrapCompanionClass(ofClass: Class<T>) =
        if (ofClass.enclosingClass != null && ofClass.enclosingClass.kotlin.companionObject?.java == ofClass)
            ofClass.enclosingClass
        else
            ofClass
