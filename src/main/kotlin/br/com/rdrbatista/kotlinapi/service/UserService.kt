package br.com.rdrbatista.kotlinapi.service

import br.com.rdrbatista.kotlinapi.model.User
import org.springframework.stereotype.Service

@Service
class UserService (var users: List<User>) {
    init {
        val usuario = User(
                id = 1,
                name = "Rodrigo Batista",
                email = "rodrigo@rodrigo.com.br"
        )
        users = listOf(usuario)
    }

    fun searchForId(id: Long): User {
        return users.stream().filter { c ->
            c.id == id
        }.findFirst().get()
    }
}