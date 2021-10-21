package com.app.myapplication.data.storage

import com.app.myapplication.data.storage.models.User

interface UserStorage {

    fun save(user: User): Boolean

    fun get(): User
}