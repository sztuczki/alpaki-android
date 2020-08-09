package com.example.domain.usecases

import com.example.domain.usecases.base.None
import com.example.domain.usecases.base.UseCase
import javax.inject.Inject

class ExampleUseCase @Inject constructor() : UseCase<None, String>() {

    override suspend fun run(params: None): String {
        return "example result"
    }
}
