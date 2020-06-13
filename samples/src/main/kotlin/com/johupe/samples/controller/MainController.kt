package com.johupe.samples.controller

import com.johupe.bootfx.Controller
import javafx.stage.Stage
import org.slf4j.Logger
import org.springframework.beans.factory.annotation.Qualifier
import org.springframework.context.annotation.Lazy
import org.springframework.stereotype.Component

@Lazy
@Component
class MainController(
        @Suppress("SpringJavaInjectionPointsAutowiringInspection")
        @Qualifier("primaryStage")
        private val stage: Stage,
        override val logger: Logger
) : Controller(logger) {

    fun show() {
        stage.show()
    }
    override val root: javafx.scene.Node
        get() = TODO("Not yet implemented")

}

