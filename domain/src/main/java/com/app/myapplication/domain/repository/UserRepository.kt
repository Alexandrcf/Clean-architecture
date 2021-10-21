package com.app.myapplication.domain.repository

import com.app.myapplication.domain.models.SaveUserNameParam
import com.app.myapplication.domain.models.UserName

interface UserRepository {

    fun saveName(saveParam: SaveUserNameParam): Boolean

    fun getName(): UserName
}