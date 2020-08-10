package com.jack.baselibrary.network

import retrofit2.Response

interface IApi<Result> {
    suspend fun getResponse(): Response<Result>
}
