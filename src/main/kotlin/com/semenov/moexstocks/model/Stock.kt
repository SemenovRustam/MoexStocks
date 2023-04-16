package com.semenov.moexstocks.model

class Stock(
    private val ticker: String,
    private val figi: String,
    private val name: String,
    private val type: String,
    private val currency: Currency,
    private val source: String
) {
}