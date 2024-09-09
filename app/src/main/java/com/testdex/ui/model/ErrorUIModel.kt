package com.testdex.ui.model

sealed class ErrorUIModel {
    object NotFoundErrorUIModel: ErrorUIModel()
    object ServerErrorUIModel: ErrorUIModel()
}