package com.example.domain.usecases

import com.example.domain.models.DreamCategory
import com.example.domain.repositories.CategoriesRepository
import com.example.domain.usecases.base.None
import com.example.domain.usecases.base.UseCase
import javax.inject.Inject

class GetCategories @Inject constructor(
    private val categoriesRepository: CategoriesRepository
) : UseCase<None, List<DreamCategory>>() {

    override suspend fun run(params: None): List<DreamCategory> =
        with(categoriesRepository) {
            saveCategories()
            return getCategories()
        }
}