package com.abakumov.pincode_example.model

import android.content.Context
import android.content.res.Resources
import android.widget.ImageView
import android.widget.LinearLayout

import java.util.ArrayList
import com.abakumov.pincode_example.R
import com.abakumov.pincode_example.asynctask.AsyncTaskVerification
import com.abakumov.pincode_example.interfaces.PinCodeState


class PinCodeUpdate(private var listImageViews: ArrayList<ImageView>, // for get image
                    private var resources: Resources, private var linearLayout: LinearLayout, internal var context: Context) : PinCodeState {


    private lateinit var asyncTaskVerification: AsyncTaskVerification
    private var listPinCode = ArrayList<String>()
    // counter for click Buttons
    private var countClick = 0

    override fun onSetNumber(s: String) {

        if (s != "-1") {
            // add number in list
            listPinCode.add(s)
            countClick++

            if (countClick == 4) {
                // if countClick = 4
                // set image full in ImageView
                // and start Verification for PIN-code
                listImageViews[countClick - 1].setImageDrawable(resources.getDrawable(R.mipmap.ovalfull))
                asyncTaskVerification = AsyncTaskVerification(listPinCode, listImageViews, resources, countClick, linearLayout, context)
                asyncTaskVerification.execute()
                countClick = 0
            } else {
                listImageViews[countClick - 1].setImageDrawable(resources.getDrawable(R.mipmap.ovalfull))
            }
        } else {
            if (listPinCode.size != 0) {
                listPinCode.removeAt(countClick - 1)
                listImageViews[countClick - 1].setImageDrawable(resources.getDrawable(R.mipmap.oval))
                countClick--
            }
        }
    }
}
