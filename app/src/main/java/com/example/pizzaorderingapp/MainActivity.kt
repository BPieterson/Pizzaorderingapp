package com.example.pizzaorderingapp

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.CheckBox
import android.widget.RadioButton
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity

class MainActivity : AppCompatActivity() {
    lateinit var rbSmall: RadioButton
    lateinit var rbMed: RadioButton
    lateinit var rbLarge: RadioButton
    lateinit var rbThin: RadioButton
    lateinit var rbRegular: RadioButton
    lateinit var rbThick: RadioButton
    lateinit var cbMushrooms: CheckBox
    lateinit var cbOnions: CheckBox
    lateinit var cbPepper: CheckBox
    lateinit var cbSpice: CheckBox
    lateinit var cbBacon: CheckBox
    lateinit var cbChicken: CheckBox
    lateinit var cbBeef: CheckBox
    lateinit var cbHam: CheckBox
    lateinit var cbCheese: CheckBox
    lateinit var cbBasil: CheckBox
    lateinit var cbHoney: CheckBox
    lateinit var cbSauce: CheckBox
    lateinit var btnPay: Button
    lateinit var btnBack: Button

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_main)
        rbSmall = findViewById(R.id.rbSmall)
        rbMed = findViewById(R.id.rbMed)
        rbLarge = findViewById(R.id.rbLarge)
        rbThin = findViewById(R.id.rbThin)
        rbRegular = findViewById(R.id.rbReg)
        rbThick = findViewById(R.id.rbThick)
        cbMushrooms = findViewById(R.id.cbMushroom)
        cbOnions = findViewById(R.id.cbOnion)
        cbPepper = findViewById(R.id.cbPepper)
        cbSpice = findViewById(R.id.cbSpice)
        cbBacon = findViewById(R.id.cbBacon)
        cbChicken = findViewById(R.id.cbChicken)
        cbBeef = findViewById(R.id.cbBeef)
        cbHam = findViewById(R.id.cbHam)
        cbCheese = findViewById(R.id.cbCheese)
        cbBasil = findViewById(R.id.cbBasil)
        cbHoney = findViewById(R.id.cbHoney)
        cbSauce = findViewById(R.id.cbSauce)
        btnPay = findViewById(R.id.btnPay)
        btnBack = findViewById(R.id.btnBack)

        //Prices
        val small = 55.00
        val med = 70.00
        val large = 150.00

        val thin = 0.00
        val regular = 3.00
        val thick = 20.00
        val topping = 7.25

        rbMed.isChecked = true
        rbRegular.isChecked = true

        rbSmall.setOnClickListener {
            rbSmall.isChecked = true
            rbMed.isChecked = false
            rbLarge.isChecked = false
        }

        rbMed.setOnClickListener {
            rbSmall.isChecked = false
            rbMed.isChecked = true
            rbLarge.isChecked = false
        }

        rbLarge.setOnClickListener {
            rbSmall.isChecked = false
            rbMed.isChecked = false
            rbLarge.isChecked = true
        }

        rbThin.setOnClickListener {
            rbThin.isChecked = true
            rbRegular.isChecked = false
            rbThick.isChecked = false
        }

        rbRegular.setOnClickListener{
            rbThin.isChecked = false
            rbRegular.isChecked = true
            rbThick.isChecked = false
        }

        rbThick.setOnClickListener {
            rbThin.isChecked = false
            rbRegular.isChecked = false
            rbThick.isChecked = true
        }

        btnPay.setOnClickListener {

            //Size
            var sizeName = ""
            var sizePrice = 0.0
            if (rbSmall.isChecked) {
                sizeName = "Small"
                sizePrice = small
            } else if (rbMed.isChecked) {
                sizeName = "Medium"
                sizePrice = med
            } else if (rbLarge.isChecked) {
                sizeName = "Large"
                sizePrice = large
            }

            //Base
            var baseName = ""
            var basePrice = 0.0
            if (rbThin.isChecked) {
                baseName = "Thin"
                basePrice = thin
            } else if (rbRegular.isChecked) {
                baseName = "Regular"
                basePrice = regular
            } else if (rbThick.isChecked) {
                baseName = "Thick"
                basePrice = thick
            }

            //Topping
            val toppingSb = StringBuilder()
            var toppingCount = 0
            if (cbMushrooms.isChecked) {
                toppingSb.append("Mushrooms, ")
                toppingCount++
            }
            if (cbOnions.isChecked) {
                toppingSb.append("Onions, ")
                toppingCount++
            }
            if (cbPepper.isChecked) {
                toppingSb.append("Pepper, ")
                toppingCount++
            }
            if (cbSpice.isChecked) {
                toppingSb.append("Spice, ")
                toppingCount++
            }
            if (cbBacon.isChecked) {
                toppingSb.append("Bacon, ")
                toppingCount++
            }
            if (cbChicken.isChecked) {
                toppingSb.append("Chicken, ")
                toppingCount++
            }
            if (cbBeef.isChecked) {
                toppingSb.append("Beef, ")
                toppingCount++
            }
            if (cbHam.isChecked) {
                toppingSb.append("Ham, ")
                toppingCount++
            }
            if (cbCheese.isChecked) {
                toppingSb.append("Cheese, ")
                toppingCount++
            }
            if (cbBasil.isChecked) {
                toppingSb.append("Basil, ")
                toppingCount++
            }
            if (cbHoney.isChecked) {
                toppingSb.append("Honey, ")
                toppingCount++
            }
            if (cbSauce.isChecked) {
                toppingSb.append("Sauce, ")
                toppingCount++
            }

            val toppingText = if (toppingSb.isNotEmpty()) {
                toppingSb.setLength(toppingSb.length - 2) // Remove the last comma and space
                toppingSb.toString()
            } else {
                "No toppings"
            }

            //Calculate the total price of toppings
            val toppingPrice = toppingCount * topping
            val total = sizePrice + basePrice + toppingPrice

            val summary = StringBuilder()
            summary.append("Pizza summary\n")
            summary.append("Size: ").append(sizeName).append("(").append(sizePrice).append(")\n")
            summary.append("Base: ").append(baseName).append("(").append(basePrice).append(")\n")
            summary.append("Toppings: ").append(toppingText).append("(").append(toppingPrice).append(")\n")
            summary.append("Total: ").append(total)

            if (toppingCount > 5) {
                // Show an error message if more than 5 toppings are selected
                Toast.makeText(this, "You can select up to 5 toppings only", Toast.LENGTH_SHORT).show()
                return@setOnClickListener
            }

            val intent = Intent(this, PaymentActivity::class.java)
            intent.putExtra("OrderSummary", summary.toString())
            startActivity(intent)
            finish()
        }

        btnBack.setOnClickListener {
            val intent = Intent(this, InformationUserScreen::class.java)
            startActivity(intent)
            finish()
        }
    }
}