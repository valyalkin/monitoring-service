package com.valyalkin.scheduledservice.config

import org.springframework.context.annotation.Configuration
import org.springframework.scheduling.annotation.SchedulingConfigurer
import org.springframework.scheduling.concurrent.ThreadPoolTaskScheduler
import org.springframework.scheduling.config.ScheduledTaskRegistrar

@Configuration
class SchedulerConfiguration : SchedulingConfigurer {

    private val threadPoolSize = 10
    override fun configureTasks(taskRegistrar: ScheduledTaskRegistrar) {
        val threadPoolTaskScheduler = ThreadPoolTaskScheduler()

        threadPoolTaskScheduler.poolSize = threadPoolSize
        threadPoolTaskScheduler.setThreadNamePrefix("scheduled-task-thread-")
        threadPoolTaskScheduler.initialize()

        taskRegistrar.setTaskScheduler(threadPoolTaskScheduler)
    }
}
