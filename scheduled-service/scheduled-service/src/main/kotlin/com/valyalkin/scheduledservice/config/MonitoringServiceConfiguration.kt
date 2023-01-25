package com.valyalkin.scheduledservice.config

import org.springframework.boot.context.properties.ConfigurationProperties

@ConfigurationProperties(prefix = "monitoring")
data class MonitoringServicesConfiguration(
    val services: List<MonitoringService>
) {
    data class MonitoringService(
        val name: String,
        val healthUrl: String
    )
}
