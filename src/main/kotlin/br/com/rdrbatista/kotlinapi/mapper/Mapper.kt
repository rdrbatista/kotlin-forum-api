package br.com.rdrbatista.kotlinapi.mapper

interface Mapper<T, U> {

    fun map(t: T): U

}