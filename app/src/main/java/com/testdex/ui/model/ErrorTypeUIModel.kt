package com.testdex.ui.model

sealed class ErrorTypeUIModel {
    object NotFoundErrorUIModel: ErrorTypeUIModel()
    object ServerErrorUIModel: ErrorTypeUIModel()
}