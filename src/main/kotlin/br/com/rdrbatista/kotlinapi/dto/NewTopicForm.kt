package br.com.rdrbatista.kotlinapi.dto

import javax.validation.constraints.NotEmpty
import javax.validation.constraints.NotNull
import javax.validation.constraints.Size

data class NewTopicForm(
        @field:NotEmpty(message = "Title cant be empty")
        @field:Size(min = 5, max = 100, message = "Title must have between 5 and 100 characters")
        val title: String,
        @field:NotEmpty(message = "Message cant be empty")
        val message: String,
        @field:NotNull
        val idCourse: Long,
        @field:NotNull
        val idAuthor: Long
)