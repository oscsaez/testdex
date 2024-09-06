package com.testdex.data.model

sealed class DataErrorType {
    object NetworkDataError: DataErrorType()
}
