package br.com.rdrbatista.kotlinapi

import org.springframework.boot.autoconfigure.EnableAutoConfiguration
import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication
import org.springframework.context.annotation.ComponentScan
import org.springframework.context.annotation.Configuration

@SpringBootApplication
class KotlinApiApplication

fun main(args: Array<String>) {
    runApplication<KotlinApiApplication>(*args)
}
