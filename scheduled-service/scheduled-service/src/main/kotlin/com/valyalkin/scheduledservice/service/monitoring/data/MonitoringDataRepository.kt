package com.valyalkin.scheduledservice.service.monitoring.data

import org.springframework.data.repository.CrudRepository
import org.springframework.stereotype.Repository

@Repository
interface MonitoringDataRepository : CrudRepository<MonitoringData, Long>
