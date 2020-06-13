package com.johupe.bootfx

import javafx.event.EventDispatchChain
import javafx.event.EventTarget
import javafx.scene.Node
import org.slf4j.Logger


abstract class Controller(protected open val logger: Logger): EventTarget{
    abstract val root: Node
    override fun buildEventDispatchChain(tail: EventDispatchChain): EventDispatchChain {
        return tail.prepend { event, tail ->
            logger.debug("Test")
           return@prepend tail.dispatchEvent(event) }
    }
}