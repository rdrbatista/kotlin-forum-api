package br.com.rdrbatista.kotlinapi.service

import br.com.rdrbatista.kotlinapi.dto.NewTopicForm
import br.com.rdrbatista.kotlinapi.dto.TopicView
import br.com.rdrbatista.kotlinapi.dto.UpdateTopicForm
import br.com.rdrbatista.kotlinapi.exception.NotFoundException
import br.com.rdrbatista.kotlinapi.mapper.TopicFormMapper
import br.com.rdrbatista.kotlinapi.mapper.TopicViewMapper
import br.com.rdrbatista.kotlinapi.model.Topic
import org.springframework.stereotype.Service
import java.util.*
import java.util.stream.Collectors

@Service
class TopicService(
        private var topics: List<Topic> = ArrayList(),
        private val topicViewMapper: TopicViewMapper,
        private val topicFormMapper: TopicFormMapper,
        private val notFoundMessage: String = "Topic not found!"
) {

    fun list(): List<TopicView> {
        return topics.stream().map { t ->
            topicViewMapper.map(t)
        }.collect(Collectors.toList())
    }

    fun searchForId(id: Long): TopicView {
        val topic = topics.stream().filter { t ->
            t.id == id
        }.findFirst().orElseThrow{ NotFoundException(notFoundMessage) }
        return topicViewMapper.map(topic)
    }

    fun create(form: NewTopicForm): TopicView {
        val topic = topicFormMapper.map(form)
        topic.id = topics.size.toLong() + 1
        topics = topics.plus(topic)
        return topicViewMapper.map(topic)
    }

    fun update(form: UpdateTopicForm): TopicView {
        val topic = topics.stream().filter { t ->
            t.id == form.id
        }.findFirst().orElseThrow{NotFoundException(notFoundMessage)}
        val updatedTopic = Topic(
                id = form.id,
                title = form.title,
                message = form.message,
                author = topic.author,
                course = topic.course,
                responses = topic.responses,
                status = topic.status,
                creationDate = topic.creationDate
        )
        topics = topics.minus(topic).plus(updatedTopic)
        return topicViewMapper.map(updatedTopic)
    }

    fun delete(id: Long) {
        val topic = topics.stream().filter { t ->
            t.id == id
        }.findFirst().orElseThrow{NotFoundException(notFoundMessage)}
        topics = topics.minus(topic)
    }

}
