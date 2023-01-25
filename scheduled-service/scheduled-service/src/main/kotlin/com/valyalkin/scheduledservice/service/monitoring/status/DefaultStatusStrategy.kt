package com.valyalkin.scheduledservice.service.monitoring.status

import org.springframework.stereotype.Component
import java.net.URI
import java.net.http.HttpClient
import java.net.http.HttpRequest
import java.net.http.HttpResponse

@Component
class DefaultStatusStrategy : StatusStrategy {
    override fun getStatus(statusUrl: String): Status {
        val client = HttpClient.newHttpClient()
        val request = HttpRequest.newBuilder().uri(URI(statusUrl)).build()
        val response = client.send(request, HttpResponse.BodyHandlers.ofString())
        if (response.statusCode() != 200) return Status.DOWN

        return Status.UP
    }
}
