package com.johupe.samples.controller

import com.johupe.bootfx.Controller
import com.johupe.bootfx.dsl.*
import javafx.scene.Scene
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
        stage.scene = scene
        stage.show()
    }

    private val parent = vbox{

    }

    private val scene = Scene(parent)


}

