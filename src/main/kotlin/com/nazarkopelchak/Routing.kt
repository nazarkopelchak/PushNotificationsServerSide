package com.nazarkopelchak

import io.ktor.server.application.*
import io.ktor.server.routing.*

fun Application.configureRouting() {
    routing {
        sendNotification()
    }
}
