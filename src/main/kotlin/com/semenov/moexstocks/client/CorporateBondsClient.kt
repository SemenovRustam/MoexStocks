package com.semenov.moexstocks.client

import org.springframework.cloud.openfeign.FeignClient
import org.springframework.web.bind.annotation.GetMapping

@FeignClient(name = "corporateBonds", url = "\${moex.bonds.corporate.url}")
interface CorporateBondsClient {

    @GetMapping
    fun getBondsFromMoex()
}