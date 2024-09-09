package com.testdex.domain.model

sealed class ErrorType {
    object NotFoundError: ErrorType()
    object ServerError: ErrorType()
}
