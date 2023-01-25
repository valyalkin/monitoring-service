package com.valyalkin.scheduledservice

import com.valyalkin.scheduledservice.config.MonitoringServicesConfiguration
import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.context.properties.EnableConfigurationProperties
import org.springframework.boot.runApplication
import org.springframework.scheduling.annotation.EnableScheduling

@SpringBootApplication
@EnableScheduling
@EnableConfigurationProperties(MonitoringServicesConfiguration::class)
class ScheduledServiceApplication

fun main(args: Array<String>) {
    runApplication<ScheduledServiceApplication>(*args)
}
