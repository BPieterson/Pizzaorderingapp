package com.example.pizzaorderingapp

import android.content.Intent
import android.icu.text.SimpleDateFormat
import android.os.Bundle
import android.widget.Button
import android.widget.RadioButton
import android.widget.TextView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import java.util.Calendar
import java.util.Locale

class PaymentActivity : AppCompatActivity() {
    lateinit var rbCash : RadioButton
    lateinit var rbCard: RadioButton
    lateinit var rbPay : RadioButton
    lateinit var tvTime : TextView
    lateinit var btnRec: Button
    lateinit var btnBack: Button

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_payment)
        rbCash = findViewById(R.id.rbCash)
        rbCard = findViewById(R.id.rbCard)
        rbPay = findViewById(R.id.rbPay)
        tvTime = findViewById(R.id.tvTime)
        btnRec = findViewById(R.id.btnRec)
        btnBack = findViewById(R.id.btnBack1)

        rbCash.setOnClickListener {
            rbCash.isChecked = true
            rbCard.isChecked = false
            rbPay.isChecked = false
        }
        rbCard.setOnClickListener {
            rbCash.isChecked = false
            rbCard.isChecked = true
            rbPay.isChecked = false
        }
        rbPay.setOnClickListener {
            rbCash.isChecked = false
            rbCard.isChecked = false
            rbPay.isChecked = true
        }

        //Time is displayed on the screen using a TextClock, and the current time is stored in a variable cTime
        val cTime = Calendar.getInstance()

        val formatter = SimpleDateFormat("yyyy-MM-dd HH:mm:ss", Locale.getDefault())
        val time = formatter.format(cTime.time)
        tvTime.text = time

        btnRec.setOnClickListener {
            //Code to save the payment method and proceed to the receipt screen
            val paymentMethod : String = when {
                rbCash.isChecked -> "Cash"
                rbCard.isChecked -> "Card"
                rbPay.isChecked -> "PayPal"
                else -> ""
            }

            val intent = Intent(this, ReceiptScreen::class.java)
            intent.putExtra("paymentMethod", paymentMethod)
            intent.putExtra("time", time)
            startActivity(intent)
            finish()
        }

        btnBack.setOnClickListener {
            val intent = Intent(this, AddressScreen::class.java)
            startActivity(intent)
            finish()
        }
    }
}