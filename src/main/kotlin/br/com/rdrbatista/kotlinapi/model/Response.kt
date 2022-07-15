package br.com.rdrbatista.kotlinapi.model

import java.time.LocalDateTime

data class Response(
        val id: Long? = null,
        val message: String,
        val creationDate: LocalDateTime = LocalDateTime.now(),
        val author: User,
        val topic: Topic,
        val solution: Boolean
)