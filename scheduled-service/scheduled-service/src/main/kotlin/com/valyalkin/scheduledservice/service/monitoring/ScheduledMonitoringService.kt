package com.valyalkin.scheduledservice.service.monitoring

import com.valyalkin.scheduledservice.config.MonitoringServicesConfiguration
import com.valyalkin.scheduledservice.service.monitoring.data.MonitoringData
import com.valyalkin.scheduledservice.service.monitoring.data.MonitoringDataRepository
import com.valyalkin.scheduledservice.service.monitoring.status.DefaultStatusStrategy
import com.valyalkin.scheduledservice.service.monitoring.status.Status
import org.apache.logging.log4j.LogManager
import org.springframework.scheduling.annotation.Scheduled
import org.springframework.stereotype.Component

@Component
class ScheduledMonitoringService(
    private val servicesConfiguration: MonitoringServicesConfiguration,
    private val defaultStatusStrategy: DefaultStatusStrategy,
    private val monitoringDataRepository: MonitoringDataRepository
) {
    private val logger = LogManager.getLogger(this::class.java)

    @Scheduled(fixedRate = 10000)
    fun runScheduledTask() {
        logger.info("Running scheduled task on thread ${Thread.currentThread()}")
        servicesConfiguration.services.forEach {
            val status = defaultStatusStrategy.getStatus(statusUrl = it.healthUrl)
            logger.info("Service ${it.name} Url: ${it.healthUrl} is ${status.statusString}")
            monitoringDataRepository.save(
                MonitoringData(
                    service = it.name,
                    status = when (status) {
                        Status.UP -> true
                        Status.DOWN -> false
                    },
                    environment = "dev"
                )
            )
        }
    }
}
