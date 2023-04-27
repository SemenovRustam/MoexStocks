package com.semenov.moexstocks

fun main() {

    val begin = System.currentTimeMillis()

    for (i in 1..100_000) {
        val person = Person("Ivan1234556", 20)
        println(person)
        println(person.trimName())
        println(person)
    }

    println(System.currentTimeMillis() - begin)

    //dif1
}

data class Person(var name: String, var age: Int)

fun Person.trimName() = this.takeIf { it.name.length > 4 }
    .apply {
        name = name.take(4)
    }