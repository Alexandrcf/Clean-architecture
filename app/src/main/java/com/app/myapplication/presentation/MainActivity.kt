package com.app.myapplication.presentation

import android.content.SharedPreferences
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import com.app.myapplication.R
import com.app.myapplication.data.repository.UserRepositoryImpl
import com.app.myapplication.data.storage.sharedprefs.SharedPrefUserStorage
import com.app.myapplication.domain.models.SaveUserNameParam
import com.app.myapplication.domain.models.UserName
import com.app.myapplication.domain.useCase.GetUserNameUseCase
import com.app.myapplication.domain.useCase.SaveUserNameUseCase

class MainActivity : AppCompatActivity() {

    private lateinit var vm: MainViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        Log.e("AAA", "Activity created")

        vm = ViewModelProvider(this, MainViewModelFactory(this))[MainViewModel::class.java]

        val dataTextView = findViewById<TextView>(R.id.data_text_view)
        val firstNameET = findViewById<EditText>(R.id.et_first_name)
        val lastNameET = findViewById<EditText>(R.id.et_last_name)
        val buttonGet = findViewById<Button>(R.id.button_get_data)
        val buttonSave = findViewById<Button>(R.id.button_save_data)

        //Подписка на изменения данных
        vm.resultLive.observe(this, Observer {
            dataTextView.text = it
        })

        buttonSave.setOnClickListener {
            val firstName = firstNameET.text.toString()
            val lastName = lastNameET.text.toString()
            vm.save(firstName, lastName)
        }

        buttonGet.setOnClickListener {
            vm.load()
        }
    }
}