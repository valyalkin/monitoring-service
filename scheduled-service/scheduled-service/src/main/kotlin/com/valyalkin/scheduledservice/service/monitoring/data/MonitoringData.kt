package com.valyalkin.scheduledservice.service.monitoring.data

import jakarta.persistence.Entity
import jakarta.persistence.GeneratedValue
import jakarta.persistence.GenerationType
import jakarta.persistence.Id
import java.sql.Timestamp
import java.time.Instant.now

@Entity
class MonitoringData(
    val time: Timestamp = Timestamp(now().toEpochMilli()),
    val service: String = "",
    val status: Boolean = false,
    val environment: String = "",
    @Id @GeneratedValue(strategy = GenerationType.AUTO)
    val id: Long = -1
)
