package com.app.myapplication.domain.useCase

import com.app.myapplication.domain.models.SaveUserNameParam
import com.app.myapplication.domain.repository.UserRepository

class SaveUserNameUseCase(private val userRepository: UserRepository) {

    fun execute(param: SaveUserNameParam) : Boolean {
        return userRepository.saveName(saveParam = param)
    }
}