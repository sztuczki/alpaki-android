package com.example.data.usecases

import com.example.data.usecases.base.None
import com.example.data.usecases.base.UseCase
import javax.inject.Inject

class ExampleUseCase @Inject constructor() : UseCase<None, String>() {

    override suspend fun run(params: None): String {
        return "example result"
    }
}
