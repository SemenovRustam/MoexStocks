package com.semenov.moexstocks.parser

import com.semenov.moexstocks.dto.BondDto

interface Parser {
    fun parse(ratesAsString: String): List<BondDto>
}