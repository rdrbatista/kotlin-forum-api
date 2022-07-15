package br.com.rdrbatista.kotlinapi.service

import br.com.rdrbatista.kotlinapi.model.Course
import org.springframework.stereotype.Service

@Service
class CourseService(var courses: List<Course>) {

    init {
        val course = Course(
                id = 1,
                name = "Kotlin",
                category = "Programacao"
        )
        courses = listOf(course)
    }

    fun searchForId(id: Long): Course {
        return courses.stream().filter { c ->
            c.id == id
        }.findFirst().get()
    }


}