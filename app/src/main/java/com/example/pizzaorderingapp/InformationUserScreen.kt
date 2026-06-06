package com.example.pizzaorderingapp

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.RadioButton
import android.widget.RadioGroup
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity

class InformationUserScreen : AppCompatActivity() {
    lateinit var txtName: EditText
    lateinit var txtSurname: EditText
    lateinit var txtPhoneNo: EditText
    lateinit var txtDOB: EditText
    lateinit var txtAge: EditText
    lateinit var rgGender: RadioGroup
    lateinit var rbMale: RadioButton
    lateinit var rbFemale: RadioButton
    lateinit var btnNext: Button

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_information_user)
        txtName = findViewById(R.id.txtName)
        txtSurname = findViewById(R.id.txtSurname)
        txtPhoneNo = findViewById(R.id.txtPhoneNo)
        txtDOB = findViewById(R.id.txtDOB)
        txtAge = findViewById(R.id.txtAge)
        rgGender = findViewById(R.id.rgGender)
        rbMale = findViewById(R.id.rbMale)
        rbFemale = findViewById(R.id.rbFemale)
        btnNext = findViewById(R.id.btnNext)

        btnNext.setOnClickListener {
            val name = txtName.text.toString()
            val surname = txtSurname.text.toString()
            val phoneNo = txtPhoneNo.text.toString()
            val dob = txtDOB.text.toString()
            val age = txtAge.text.toString()
            val gender = when (rgGender.checkedRadioButtonId){
                R.id.rbMale -> "Male"
                R.id.rbFemale -> "Female"
                else -> "Not Specified"
            }

            if(name.isEmpty() || surname.isEmpty() || phoneNo.isEmpty() || dob.isEmpty() || age.isEmpty() || gender.isEmpty()){
                if (name.isEmpty()){
                    txtName.error = "Please enter your name"
                }
                if (surname.isEmpty()){
                    txtSurname.error = "Please enter your surname"
                }
                if (phoneNo.isEmpty()){
                    txtPhoneNo.error = "Please enter your phone number"
                }
                if (dob.isEmpty()){
                    txtDOB.error = "Please enter your date of birth"
                }
                if (age.isEmpty()){
                    txtAge.error = "Please enter your age"
                }
                if (gender.isEmpty()){
                    Toast.makeText(this, "Please select your gender", Toast.LENGTH_SHORT).show()
                }
                Toast.makeText(this, "Please fill in all the fields", Toast.LENGTH_SHORT).show()
            }else{
                val intent = Intent(this, AddressScreen::class.java)
                intent.putExtra("name", name)
                intent.putExtra("surname", surname)
                intent.putExtra("phoneNo", phoneNo)
                intent.putExtra("dob", dob)
                intent.putExtra("age", age)
                intent.putExtra("gender", gender)
                startActivity(intent)
                finish()
            }
        }
    }
}