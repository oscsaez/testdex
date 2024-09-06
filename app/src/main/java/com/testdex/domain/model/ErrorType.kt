package com.testdex.domain.model

sealed class ErrorType {
    object NetworkError: ErrorType()
}
