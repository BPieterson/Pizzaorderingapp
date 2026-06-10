package com.example.pizzaorderingapp

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity

class AddressScreen : AppCompatActivity() {
    lateinit var txtStAddress : EditText
    lateinit var txtCity: EditText
    lateinit var txtProvince: EditText
    lateinit var txtSuburb: EditText
    lateinit var txtPCode: EditText
    lateinit var txtComb: EditText
    lateinit var btnOrder: Button

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_address_screen)
        txtStAddress = findViewById(R.id.txtStAddress)
        txtCity = findViewById(R.id.txtCity)
        txtProvince = findViewById(R.id.txtProvince)
        txtSuburb = findViewById(R.id.txtSuburb)
        txtPCode = findViewById(R.id.txtPCode)
        txtComb = findViewById(R.id.txtComb)
        btnOrder = findViewById(R.id.btnOrder)

        btnOrder.setOnClickListener{
            val streetAddress = txtStAddress.text.toString()
            val city = txtCity.text.toString()
            val province = txtProvince.text.toString()
            val suburb = txtSuburb.text.toString()
            val postalCode = txtPCode.text.toString()
            val comb = txtComb.text.toString()

            if (streetAddress.isEmpty() || city.isEmpty() || province.isEmpty() || suburb.isEmpty() || postalCode.isEmpty()){
                if (streetAddress.isEmpty()){
                    txtStAddress.error = "Please enter your street address"
                }
                if (city.isEmpty()){
                    txtCity.error = "Please enter your city"
                }
                if (province.isEmpty()){
                    txtProvince.error = "Please enter your province"
                }
                if (suburb.isEmpty()){
                    txtSuburb.error = "Please enter your suburb"
                }
                if (postalCode.isEmpty()){
                    txtPCode.error = "Please enter your postal code"
                }

                Toast.makeText(this, "Fill in all the fields", Toast.LENGTH_LONG).show()
            } else {
                // Proceed with order processing
                val intent = Intent(this, PaymentActivity::class.java)
                intent.putExtra("streetAddress", streetAddress)
                intent.putExtra("city", city)
                intent.putExtra("province", province)
                intent.putExtra("suburb", suburb)
                intent.putExtra("postalCode", postalCode)
                intent.putExtra("comb", comb)
                startActivity(intent)
                finish()
            }
        }
    }
}