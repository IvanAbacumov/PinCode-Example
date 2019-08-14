package com.abakumov.pincode_example.asynctask


import android.content.Context
import android.content.res.Resources
import android.os.AsyncTask
import android.util.Log
import android.widget.ImageView
import android.widget.LinearLayout
import android.widget.Toast

import com.abakumov.pincode_example.R
import com.abakumov.pincode_example.animation.AnimationPack

import java.util.ArrayList

class AsyncTaskVerification(private var pinCodeModelList: ArrayList<String>, private var imageViewList: ArrayList<ImageView>, // for set image in ImageView
                            private var resources: Resources, // counter for Click, for clean state ImageView
                            private var countClick: Int, private var linearLayout: LinearLayout, private var context: Context) : AsyncTask<Void, Void, Boolean>() {
    // param for verification(successful or unsuccessful)
    private var verificationOnOff: Boolean? = null
    // successful verification if pin-code = 1111
    private var string = "1111"
    private var pinCode = ""

    // for Animation
    private lateinit var animationPack: AnimationPack


    override fun doInBackground(vararg voids: Void): Boolean? {

        pinCode = pinCodeModelList[0] + pinCodeModelList[1] +
                pinCodeModelList[2] + pinCodeModelList[3]

        Log.d("pincodepincode", pinCode)

        verificationOnOff = string == pinCode
        try {
            Thread.sleep(100)
        } catch (e: InterruptedException) {
            e.printStackTrace()
        }

        return verificationOnOff
    }

    override fun onPostExecute(b: Boolean?) {


        if (b == false) {

            // initial class AnimationPack and start method for "Spring" animation
            animationPack = AnimationPack(linearLayout)
            animationPack.startSpringAnimation()
            getImageOval()
        } else {


            val toast = Toast.makeText(context,
                    "Success!",
                    Toast.LENGTH_SHORT)

            toast.show()
            getImageOval()

        }
    }

    private fun getImageOval() {

        for (i in 0 until countClick) {
            imageViewList[i].setImageResource(R.mipmap.oval)
        }
        pinCodeModelList.clear()
    }
}
