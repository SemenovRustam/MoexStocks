package com.semenov.moexstocks

import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication

@SpringBootApplication
class MoexStocksApplication

fun main(args: Array<String>) {
    runApplication<MoexStocksApplication>(*args)
}

