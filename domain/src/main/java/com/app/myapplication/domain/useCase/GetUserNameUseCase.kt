package com.app.myapplication.domain.useCase

import com.app.myapplication.domain.models.UserName
import com.app.myapplication.domain.repository.UserRepository

class GetUserNameUseCase(private val userRepository: UserRepository) {

    fun execute(): UserName {
        return userRepository.getName()
    }
}