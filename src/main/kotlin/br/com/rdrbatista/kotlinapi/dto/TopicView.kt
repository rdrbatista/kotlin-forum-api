package br.com.rdrbatista.kotlinapi.dto

import br.com.rdrbatista.kotlinapi.model.StatusTopic
import java.time.LocalDateTime

data class TopicView(
        val id: Long?,
        val title: String,
        val message: String,
        val status: StatusTopic,
        val creationDate: LocalDateTime
)