package br.com.rdrbatista.kotlinapi.mapper

import br.com.rdrbatista.kotlinapi.dto.TopicView
import br.com.rdrbatista.kotlinapi.model.Topic
import org.springframework.stereotype.Component

@Component
class TopicViewMapper: Mapper<Topic, TopicView> {

    override fun map(t: Topic): TopicView {
        return TopicView(
                id = t.id,
                title = t.title,
                message = t.message,
                creationDate = t.creationDate,
                status = t.status
        )
    }
}