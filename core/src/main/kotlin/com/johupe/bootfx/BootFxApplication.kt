package com.johupe.bootfx

import javafx.application.Application
import javafx.stage.Stage
import org.springframework.boot.builder.SpringApplicationBuilder
import org.springframework.context.ApplicationEvent
import org.springframework.context.ConfigurableApplicationContext
import kotlin.system.exitProcess

/**
 * @property A is the spring application
 * @property C is the main controller
 * */
abstract class BootFxApplication<A, C : Controller>(
        private val applicationClass: Class<A>,
        private val controllerClass: Class<C>) : Application() {

    private lateinit var applicationContext: ConfigurableApplicationContext
    lateinit var controller: C

    override fun init() {
        startup()
        val args = parameters.raw.toTypedArray()
        applicationContext = SpringApplicationBuilder(applicationClass).run(*args)

    }

    override fun start(primaryStage: Stage) {
        applicationContext.beanFactory.registerSingleton("primaryStage", primaryStage)
        try{
            controller = this.applicationContext.getBean(controllerClass)
        }catch (e:Exception){
            e.printStackTrace()
        }
        applicationContext.publishEvent(ApplicationSetupCompleted(this))
    }

    override fun stop() {
        teardown()
        applicationContext.close()
        exitProcess(0)
    }


    /**
     * Override this to custommize startup logic
     * */
    open fun startup() {

    }

    /**
     * Override this to implement custom teardown logi
     * */
    open fun teardown() {}

    /**
     *
     * Implement an {@link org.springframework.context.ApplicationListener } to
     *
     * */
    class ApplicationSetupCompleted<T : BootFxApplication<*, *>>(val source: T) : ApplicationEvent(source)

}


