package com.testdex.data.model

sealed class DataErrorType {
    object NotFoundDataError: DataErrorType()
    object ServerDataError: DataErrorType()
    object WriteDataError: DataErrorType()
    object ReadDataError: DataErrorType()
}
