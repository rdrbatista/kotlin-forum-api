package br.com.rdrbatista.kotlinapi.controller

import br.com.rdrbatista.kotlinapi.dto.NewTopicForm
import br.com.rdrbatista.kotlinapi.dto.TopicView
import br.com.rdrbatista.kotlinapi.dto.UpdateTopicForm
import br.com.rdrbatista.kotlinapi.service.TopicService
import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.*
import org.springframework.web.util.UriComponentsBuilder
import javax.validation.Valid

@RestController
@RequestMapping("/topics")
class TopicController(private val service: TopicService) {

    @GetMapping
    fun list(): List<TopicView> {
        return service.list()
    }

    @GetMapping("/{id}")
    fun searchForId(@PathVariable id: Long): TopicView {
        return service.searchForId(id)
    }

    @PostMapping
    fun create(
            @RequestBody @Valid form: NewTopicForm,
            uriBuilder: UriComponentsBuilder
    ): ResponseEntity<TopicView> {
        val topicView = service.create(form)
        val uri = uriBuilder.path("/topics/${topicView.id}").build().toUri()
        return ResponseEntity.created(uri).body(topicView)
    }

    @PutMapping
    fun update(@RequestBody @Valid form: UpdateTopicForm): ResponseEntity<TopicView> {
        val topicView = service.update(form)
        return ResponseEntity.ok(topicView)
    }

    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    fun delete(@PathVariable id: Long) {
        service.delete(id)
    }

}