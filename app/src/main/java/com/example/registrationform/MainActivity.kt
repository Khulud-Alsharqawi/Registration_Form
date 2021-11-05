package com.example.registrationform



import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.PatternMatcher
import android.provider.ContactsContract
import android.util.Patterns
import android.widget.Toast
import com.example.registrationform.databinding.ActivityMainBinding


class MainActivity : AppCompatActivity() {
     lateinit var binding: ActivityMainBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        binding.regButton.setOnClickListener { regeneration() }
    }

    fun regeneration() {
        val stringInTextFiled = binding.userName.text.toString()
        val stringInEmail = binding.userEmail.text.toString()
        val stringInPassword = binding.userPw.text.toString()
        val stringInRePassword = binding.userRePw.text.toString()
        val stringInDataInput = binding.userBD.text.toString()
        val gender = when (binding.radioGroup.checkedRadioButtonId) {
            R.id.radioFemale -> "Female"
            else -> "Male"
        }


    if (stringInDataInput.isNotEmpty() && stringInEmail.isNotEmpty() && stringInPassword.isNotEmpty()
        && stringInRePassword.isNotEmpty() && stringInDataInput.isNotEmpty()) {
        if (!Patterns.EMAIL_ADDRESS.matcher(stringInEmail).matches())            {

        Toast.makeText(this, "Invalid Email Address, Please Enter right email form ", Toast.LENGTH_SHORT).show()

        }
            else    if (stringInPassword == stringInRePassword) {
                    binding.output.text = "Hello: $stringInTextFiled, your Email $stringInEmail,and your password is: $stringInPassword  "
                } else {
                    Toast.makeText(this,"the password not matching!!please re_enter a gain",Toast.LENGTH_SHORT).show()
                  //  binding.output.text = "the password not matching!!please re_enter a gain "
                }

            } else {
                Toast.makeText(this,"fill the all the fields right", Toast.LENGTH_SHORT).show()
                // binding.output.text = "fill the all the fields right"
            }
        }
    }

