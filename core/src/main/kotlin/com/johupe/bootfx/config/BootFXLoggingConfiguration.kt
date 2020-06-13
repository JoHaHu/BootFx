package com.johupe.bootfx.config

import org.slf4j.Logger
import org.slf4j.LoggerFactory
import org.springframework.beans.factory.InjectionPoint
import org.springframework.boot.autoconfigure.condition.ConditionalOnMissingBean
import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration
import org.springframework.context.annotation.Scope

@ConditionalOnMissingBean(Logger::class)
@Configuration
class BootFXLoggingConfiguration {
    @Bean
    @Scope("prototype")
    fun logger(injectionPoint: InjectionPoint): Logger {
        return LoggerFactory.getLogger(
                injectionPoint.methodParameter?.containingClass // constructor
                        ?: injectionPoint.field?.declaringClass) // or field injection
    }
}
