package com.semenov.moexstocks.service

import com.semenov.moexstocks.client.CorporateBondsClient
import com.semenov.moexstocks.client.GovernmentBondsClient
import com.semenov.moexstocks.dto.StocksDto
import com.semenov.moexstocks.dto.TickersDto
import com.semenov.moexstocks.parser.Parser
import org.springframework.stereotype.Service

@Service
class BondService(
    private val corporateBondsClient: CorporateBondsClient,
    private val governmentBondsClient: GovernmentBondsClient,
    private val parser: Parser
) {

    fun getBondsFromMoex(tickers: TickersDto) : StocksDto {
        return StocksDto(listOf())
    }
}