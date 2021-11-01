package com.example.registrationform

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.textservice.TextInfo

import com.example.registrationform.databinding.ActivityMainBinding
import java.text.NumberFormat

class MainActivity : AppCompatActivity() {
    lateinit var binding: ActivityMainBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding= ActivityMainBinding.inflate(layoutInflater)
            setContentView(binding.root)

        binding.regButton.setOnClickListener{ regesration() }
    }
     fun regesration() {
         //=================name part=====================
         val stringInTextFiled = binding.PersonName.text
         //=================email part=====================
         val stringInEmail = binding.EmailAddress.text
        //=================birthdate part=====================
         val stringInDataInput = binding.birthDay.toString()
         //=================gender selection part=====================
         val selectedGender = binding.radioGroup.checkedRadioButtonId
         val gender = when (selectedGender) {
             R.id.radioFemale -> "Female"
             else -> "Male"         }
         //=================password part=====================
         val stringInPasswor = binding.Password.text
         val stringInRePassword = binding.rePassword.text
         val missMatch = if (stringInPasswor != stringInRePassword) {
             println("the password not matching!!plase re_enter a gain .")
         } else {  binding.output.setText(    "Your Info is /n " +
                          "================= /n " +
                         "Name: $stringInTextFiled /n " +
                         "Email $stringInEmail /n" +
                         "password: $stringInPasswor /n " +
                         "re_password $stringInRePassword /n" +
                         "Birth Date: $stringInDataInput /n " +
                         "Gender $gender /n" )
         }

     }

     }