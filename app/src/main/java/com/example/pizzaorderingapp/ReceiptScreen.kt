package com.example.pizzaorderingapp

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity

class ReceiptScreen : AppCompatActivity() {
    lateinit var tvResult : TextView
    lateinit var tvOrderNo : TextView
    lateinit var btnHome : Button

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_receipt_screen)
        tvResult = findViewById(R.id.tvResult)
        tvOrderNo = findViewById(R.id.tvOrderNo)
        btnHome = findViewById(R.id.btnHome)

        val orderNo = (1..9999).random()


        val name = intent.getStringExtra("name")
        val surname = intent.getStringExtra("surname")
        val phoneNo = intent.getStringExtra("phoneNo")
        val dob = intent.getStringExtra("dob")
        val age = intent.getStringExtra("age")
        val gender = intent.getStringExtra("gender")
        val stAddress = intent.getStringExtra("stAddress")
        val city = intent.getStringExtra("city")
        val province = intent.getStringExtra("province")
        val suburb = intent.getStringExtra("suburb")
        val postalCode = intent.getStringExtra("postalCode")
        val comb = intent.getStringExtra("comb")
        val pizzaType = intent.getStringExtra("pizzaType")
        val pizzaSize = intent.getStringExtra("pizzaSize")
        val pizzaToppings = intent.getStringExtra("pizzaToppings")
        val time = intent.getStringExtra("time")
        val paymentMethod = intent.getStringExtra("paymentMethod")

        val receipt = """
            $time           Payment Method: $paymentMethod
            Name: $name $surname
            Phone No: $phoneNo
            Date of Birth: $dob
            Age: $age
            Gender: $gender
            Street Address: $stAddress
            City: $city
            Province: $province
            Suburb: $suburb
            Postal Code: $postalCode
            Combination: $comb
            Pizza Type: $pizzaType
            Pizza Size: $pizzaSize
            Pizza Toppings: $pizzaToppings
            Payment Method: $paymentMethod
            """
        tvResult.text = receipt
        tvOrderNo.text = "#$orderNo"

        btnHome.setOnClickListener {
            val intent = Intent(this, MainActivity::class.java)
            startActivity(intent)
            finish()
        }
    }
}