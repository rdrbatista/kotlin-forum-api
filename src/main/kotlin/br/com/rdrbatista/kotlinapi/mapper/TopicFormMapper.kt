package br.com.rdrbatista.kotlinapi.mapper

import br.com.rdrbatista.kotlinapi.dto.NewTopicForm
import br.com.rdrbatista.kotlinapi.model.Topic
import br.com.rdrbatista.kotlinapi.service.CourseService
import br.com.rdrbatista.kotlinapi.service.UserService
import org.springframework.stereotype.Component

@Component
class TopicFormMapper(
        private val courseService: CourseService,
        private val userService: UserService
): Mapper<NewTopicForm, Topic> {
    override fun map(t: NewTopicForm): Topic {
        return Topic(
                title = t.title,
                message = t.message,
                course = courseService.searchForId(t.idCourse),
                author = userService.searchForId(t.idAuthor)
        )
    }

}