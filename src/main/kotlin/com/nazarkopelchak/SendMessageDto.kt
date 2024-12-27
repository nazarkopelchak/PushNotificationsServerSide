package com.nazarkopelchak

import com.google.firebase.messaging.Message
import com.google.firebase.messaging.Notification

data class SendMessageDto(
    val token: String?,
    val notification: NotificationBody
)

data class NotificationBody(
    val title: String,
    val body: String
)

fun SendMessageDto.toMessage(): Message {
    return Message.builder()
        //.putData() used to send key-value data. Can be retrieved on a client
        .setNotification(
            Notification.builder()
                .setTitle(notification.title)
                .setBody(notification.body)
                .build()
        ).apply {
            if (token == null) {
                setTopic("chat")    // broadcast to all users
            }
            else {
                setToken(token)     // send the message to one user
            }
        }
        .build()    // this will create its own notification with its own notification channel. No need to worry about it on the client side
}
