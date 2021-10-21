package com.app.myapplication.presentation

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.app.myapplication.domain.models.SaveUserNameParam
import com.app.myapplication.domain.models.UserName
import com.app.myapplication.domain.useCase.GetUserNameUseCase
import com.app.myapplication.domain.useCase.SaveUserNameUseCase

class MainViewModel(private val getUserNameUseCase: GetUserNameUseCase,
                    private val saveUserNameUseCase: SaveUserNameUseCase
) : ViewModel() {

    private var resultLiveMutable = MutableLiveData<String>()
    val resultLive: LiveData<String> = resultLiveMutable

    init {
        Log.e("AAA", "VM created")
    }

    override fun onCleared() {
        Log.e("AAA", "VM onCleared")
        super.onCleared()
    }

    fun save(firstName: String, lastName: String) {
        val params = SaveUserNameParam(firstName = firstName, lastName = lastName)
        val resultData = saveUserNameUseCase.execute(param = params)
        resultLiveMutable.value =  "Save result = $resultData"
    }

    fun load() {
        val userName: UserName = getUserNameUseCase.execute()
        resultLiveMutable.value = "${userName.firstName} ${userName.lastName}"
    }
}