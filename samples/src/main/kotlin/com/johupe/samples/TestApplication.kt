package com.johupe.samples

import com.johupe.bootfx.BootFxApplication
import com.johupe.samples.application.TestSpringApp
import com.johupe.samples.controller.MainController
import javafx.application.Application

fun main(args : Array<String>) {
    Application.launch(TestApplication::class.java, *args)
}

class TestApplication : BootFxApplication<TestSpringApp, MainController>(TestSpringApp::class.java, MainController::class.java)