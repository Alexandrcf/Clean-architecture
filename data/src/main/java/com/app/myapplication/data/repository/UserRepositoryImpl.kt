package com.app.myapplication.data.repository

import com.app.myapplication.data.storage.models.User
import com.app.myapplication.data.storage.UserStorage
import com.app.myapplication.domain.models.SaveUserNameParam
import com.app.myapplication.domain.models.UserName
import com.app.myapplication.domain.repository.UserRepository


class UserRepositoryImpl(private val userStorage: UserStorage) : UserRepository {

    override fun saveName(saveParam: SaveUserNameParam): Boolean {
        return userStorage.save(User(firstName = saveParam.firstName, lastName = saveParam.lastName))
    }

    override fun getName(): UserName {
        return UserName(firstName = userStorage.get().firstName, lastName = userStorage.get().lastName)
    }
}