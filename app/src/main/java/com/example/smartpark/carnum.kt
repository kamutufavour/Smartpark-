package com.example.smartpark

import android.annotation.SuppressLint
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.RadioGroup
import android.widget.Toast
import android.graphics.Bitmap
import android.graphics.Point
import android.text.TextUtils
import android.view.Display
import android.view.WindowManager
import android.widget.ImageView
import com.google.zxing.BarcodeFormat


class carnum(name: String, idNum: String, phoneNumber: String, numberPlate: String, carType: Int) : AppCompatActivity() {
    @SuppressLint("WrongViewCast")
    lateinit var qrIV: ImageView
    lateinit var msgEdt: EditText
    lateinit var generateQRBtn: Button
    lateinit var bitmap: Bitmap
    lateinit var qrEncoder: QRGEncoder

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_carnum)
        // Get the references to the UI elements
        val nameEditText = findViewById<EditText>(R.id.nameEditText)
        val idNumEditText = findViewById<EditText>(R.id.idNumEditText)
        val phoneNumberEditText = findViewById<EditText>(R.id.phoneNumberEditText)
        val numberPlateEditText = findViewById<EditText>(R.id.numberPlateEditText)
        val Typecar = findViewById<RadioGroup>(R.id.Typecar)
        val submitButton = findViewById<Button>(R.id.BtnGenerateQR)
        qrIV = findViewById(R.id.idIVQrcode)
        msgEdt = findViewById(R.id.Eidt)
        generateQRBtn = findViewById(R.id.BtnGenerateQR)
        generateQRBtn.setOnClickListener {
            if (TextUtils.isEmpty(msgEdt.text.toString())) {
                Toast.makeText(applicationContext, "Enter your message", Toast.LENGTH_SHORT).show()
            } else {
                val qrCodeEncoder = QRCodeEncoder()
                val text = "This is a QR code"
                val bitmap = qrCodeEncoder.encode(text, BarcodeFormat.QR_CODE, 500, 500)

                // Get the user input
                val windowManager: WindowManager = getSystemService(WINDOW_SERVICE) as WindowManager
                val display: Display = windowManager.defaultDisplay
                val point: Point = Point()
                val name = nameEditText.text.toString()
                val idNum = idNumEditText.text.toString()
                val phoneNumber = phoneNumberEditText.text.toString()
                val numberPlate = numberPlateEditText.text.toString()
                val carType = Typecar.checkedRadioButtonId
                // Create a new car registration object
                val carnum = carnum(name, idNum, phoneNumber, numberPlate, carType)
                // Save the car registration to the database
                // TODO: Implement this
                // Show a success message
                Toast.makeText(this, "Car registration successful!", Toast.LENGTH_SHORT).show()

            }
        }
    }
}
