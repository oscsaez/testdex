package com.testdex.remote.model

sealed class RemoteErrorType {
    object NotFoundRemoteError: RemoteErrorType()
    object ServerRemoteError: RemoteErrorType()
    object ExceptionRemoteError: RemoteErrorType() // Only while developing
}
