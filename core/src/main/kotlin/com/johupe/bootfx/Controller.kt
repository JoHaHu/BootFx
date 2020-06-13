package com.johupe.bootfx

import javafx.event.EventDispatchChain
import javafx.event.EventTarget
import org.slf4j.Logger


abstract class Controller(protected open val logger: Logger) : EventTarget {
    override fun buildEventDispatchChain(tail: EventDispatchChain): EventDispatchChain {
        return tail
    }
}