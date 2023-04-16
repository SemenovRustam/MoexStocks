package com.semenov.moexstocks.service

import com.semenov.moexstocks.client.CorporateBondsClient
import com.semenov.moexstocks.client.GovernmentBondsClient
import com.semenov.moexstocks.dto.StocksDto
import com.semenov.moexstocks.dto.TickersDto
import org.springframework.stereotype.Service

@Service
class BondService(
    private val corporateBondsClient: CorporateBondsClient,
    private val governmentBondsClient: GovernmentBondsClient
) {

    fun getBondsFromMoex(tickers: TickersDto) : StocksDto {
        return StocksDto(listOf())
    }
}