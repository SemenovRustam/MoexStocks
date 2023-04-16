package com.semenov.moexstocks

import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication
import org.springframework.cloud.openfeign.EnableFeignClients

@SpringBootApplication
@EnableFeignClients
class MoexStocksApplication

fun main(args: Array<String>) {
    runApplication<MoexStocksApplication>(*args)
}

