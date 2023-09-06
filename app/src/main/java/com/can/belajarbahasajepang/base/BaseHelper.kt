package com.can.belajarbahasajepang.base

import com.can.belajarbahasajepang.network.ClientService

open class BaseHelper {
    val ApiServiceServer by lazy { ClientService().create(file = false) }
}