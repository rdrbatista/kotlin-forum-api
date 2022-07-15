package br.com.rdrbatista.kotlinapi.model

import java.time.LocalDateTime
import java.util.*

data class Topic(
        var id: Long? = null,
        val title: String,
        val message: String,
        val creationDate: LocalDateTime = LocalDateTime.now(),
        val course: Course,
        val author: User,
        val status: StatusTopic = StatusTopic.NOT_ANSWERED,
        val responses: List<Response> = ArrayList()
)