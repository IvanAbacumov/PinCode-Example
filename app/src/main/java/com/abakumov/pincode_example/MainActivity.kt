package com.abakumov.pincode_example


import androidx.appcompat.app.AppCompatActivity

import android.graphics.Typeface
import android.os.Bundle


// for UI elements
import android.view.View
import android.widget.ImageView
import android.widget.LinearLayout
import android.widget.TextView
import android.widget.Toast

import com.abakumov.pincode_example.model.PinCodeUpdate

import java.util.ArrayList

class MainActivity : AppCompatActivity(), View.OnClickListener {

    // for UI
    private lateinit var linearLayout: LinearLayout
    private lateinit var logotype: TextView
    private lateinit var customFont: Typeface
    private lateinit var imageViewNum1: ImageView
    private lateinit var imageViewNum2: ImageView
    private lateinit var imageViewNum3: ImageView
    private lateinit var imageViewNum4: ImageView



    // for list(PIN-code) and list(Image)
    private lateinit var listPINcode: ArrayList<String>
    private lateinit var listImageView: ArrayList<ImageView>


    // for set full PIN-code(****)
    private lateinit var pinCodeUpdate: PinCodeUpdate


    private lateinit var toast: Toast

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        linearLayout = findViewById(R.id.linearLayoutPin)
        imageViewNum1 = findViewById(R.id.num1)
        imageViewNum2 = findViewById(R.id.num2)
        imageViewNum3 = findViewById(R.id.num3)
        imageViewNum4 = findViewById(R.id.num4)

        // add font for main title
        logotype = findViewById(R.id.logotype)
        installFont(logotype)


        // initial list for numbers(PIN-code)
        listPINcode = ArrayList()
        // initial list for ImageView
        listImageView = ArrayList()
        // add ImageView in list
        listImageView.add(imageViewNum1)
        listImageView.add(imageViewNum2)
        listImageView.add(imageViewNum3)
        listImageView.add(imageViewNum4)

        // send listImageView and resources(for animation)
        pinCodeUpdate = PinCodeUpdate(listImageView, resources, linearLayout, this@MainActivity)
    }


    override fun onClick(v: View) {
        when (v.id) {
            R.id.btn_1 -> addNumber("1")
            R.id.btn_2 -> addNumber("2")
            R.id.btn_3 -> addNumber("3")
            R.id.btn_4 -> addNumber("4")
            R.id.btn_5 -> addNumber("5")
            R.id.btn_6 -> addNumber("6")
            R.id.btn_7 -> addNumber("7")
            R.id.btn_8 -> addNumber("8")
            R.id.btn_9 -> addNumber("9")
            R.id.btn_0 -> addNumber("0")
            R.id.btn_delete -> addNumber("-1")
        }
    }

    private fun addNumber(number: String) {
        toast = Toast.makeText(applicationContext, number, Toast.LENGTH_SHORT)
        toast.show()
        pinCodeUpdate.onSetNumber(number)
    }

    private fun installFont(textView: TextView) {
        customFont = Typeface.createFromAsset(assets, "fonts/Lato-Bold.ttf")
        textView.typeface = customFont
    }
}
