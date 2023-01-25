package com.valyalkin.scheduledservice.service.monitoring.status

enum class Status(
    val statusString: String
) {
    UP("UP"),
    DOWN("DOWN")
}

interface StatusStrategy {
    fun getStatus(statusUrl: String): Status
}
