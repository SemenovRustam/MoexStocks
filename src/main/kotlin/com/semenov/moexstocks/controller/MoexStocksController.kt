package com.semenov.moexstocks.controller

import com.semenov.moexstocks.dto.StocksDto
import com.semenov.moexstocks.dto.TickersDto
import com.semenov.moexstocks.service.BondService
import mu.KotlinLogging
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController


@RestController
@RequestMapping("/api/v1/bonds")
class MoexStocksController(
    private val bondService: BondService
) {

    @PostMapping("/getBondsByTickers")
    fun getBondsFromMoex(@RequestBody tickersDto: TickersDto) : StocksDto =
       bondService.getBondsFromMoex(tickersDto)


    companion object {
        val LOG = KotlinLogging.logger {}
    }
}