package com.semenov.moexstocks.exception

import java.lang.Exception
import java.lang.RuntimeException

class BondParsingException(
    message: String?
) : RuntimeException(message) {
}