package com.testdex.remote.utils

import arrow.core.Either
import arrow.core.left
import arrow.core.right
import com.testdex.data.model.DataErrorType
import com.testdex.remote.model.RemoteErrorType
import io.ktor.client.HttpClient
import io.ktor.client.request.request
import io.ktor.client.statement.HttpResponse
import io.ktor.http.HttpMethod

suspend fun <T> safeApiCall(
    client: HttpClient,
    url: String,
    method: HttpMethod = HttpMethod.Get,
    onSuccess: suspend (HttpResponse) -> T
): Either<DataErrorType, T>  {
    return try {
        val response: HttpResponse = client.request(url) {
            this.method = method
        }

        when (response.status.value) {
            in 200..299 -> {
                onSuccess(response).right()
            }
            in 400..499 -> {
                RemoteErrorType.NotFoundRemoteError.toDataErrorType().left()
            }
            else -> {
                RemoteErrorType.ServerRemoteError.toDataErrorType().left()
            }
        }
    } catch (e: Exception) {
        RemoteErrorType.ExceptionRemoteError.toDataErrorType().left()
    }
}