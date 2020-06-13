package com.johupe.samples


import com.johupe.bootfx.BootFxApplication
import org.springframework.context.event.EventListener
import org.springframework.stereotype.Component

@Component
class StartupListener {
    @EventListener()
    fun onApplicationEvent(event: BootFxApplication.ApplicationSetupCompleted<TestApplication>) {
        try {
            val controller = event.source.controller
            controller.show()

        } catch (e: Exception) {
            e.printStackTrace()
        }
    }
}