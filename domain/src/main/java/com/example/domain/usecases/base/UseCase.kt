package com.example.domain.usecases.base

import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Job
import kotlinx.coroutines.launch

abstract class UseCase<in Params, out Type> {
    abstract suspend fun run(params: Params): Type

    operator fun invoke(
        scope: CoroutineScope,
        params: Params,
        onSuccess: (Type) -> Unit = {},
        onFailure: (Throwable) -> Unit = {}
    ): Job = scope.launch {
        runCatching { run(params) }
            .onSuccess { onSuccess(it) }
            .onFailure { onFailure(it) }
    }
}

object None
