package com.testdex.remote.model

sealed class RemoteErrorType {
    object NotFoundError: RemoteErrorType()
    object ServerError: RemoteErrorType()
    object ExceptionError: RemoteErrorType() // Only while developing
}
