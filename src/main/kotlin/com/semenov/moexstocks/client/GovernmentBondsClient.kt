package com.semenov.moexstocks.client

import org.springframework.cloud.openfeign.FeignClient
import org.springframework.web.bind.annotation.GetMapping

@FeignClient(name = "governmentBonds", url = "\${moex.bonds.government.url}")
interface GovernmentBondsClient {

    @GetMapping
    fun getBondsFromMoex()
}