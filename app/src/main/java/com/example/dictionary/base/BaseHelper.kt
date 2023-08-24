package com.example.dictionary.base

import com.example.dictionary.network.ClientService

open class BaseHelper {
    val ApiServiceServer by lazy { ClientService().create(file = false) }
}