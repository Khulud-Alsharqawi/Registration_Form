package com.example.registrationform

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.registrationform.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    lateinit var binding: ActivityMainBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        binding.regButton.setOnClickListener { regesration() }
    }

    fun regesration() {
        val stringInTextFiled = binding.PersonName.text.toString()
        val stringInEmail = binding.EmailAddress.text.toString()
        val stringInPasswor = binding.Password.text.toString()
        val stringInRePassword = binding.rePassword.text.toString()
        val stringInDataInput = binding.birthDay.text
        val selectedGender = binding.radioGroup.checkedRadioButtonId
        val gender = when (selectedGender) {
            R.id.radioFemale -> "Female"
            else -> "Male"
        }

        if (stringInDataInput.isNotEmpty() && stringInEmail.isNotEmpty() && stringInPasswor.isNotEmpty() && stringInRePassword.isNotEmpty() && stringInDataInput.isNotEmpty()) {
            if (stringInPasswor.toString() == stringInRePassword.toString()) {
                binding.output.setText(
                    "Your Info is \n " +
                            "================= \n " +
                            "Name: $stringInTextFiled  \n " +
                            "Email $stringInEmail \n" +
                            "password: $stringInPasswor \n " +
                            "re_password $stringInRePassword \n" +
                            "Birth Date: $stringInDataInput \n " +
                            "Gender $gender "
                )
            } else {
                binding.output.setText("the password not matching!!please re_enter a gain ")
            }

        } else {
            binding.output.setText("fill the all the fields right")
        }

    }
}
