package com.can.belajarbahasajepang.base

data class BaseResponse<T>(
    val error: Boolean,
    val message: String,
    val data: T?
)