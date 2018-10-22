package com.abakumov.pincode_example.model;

import android.content.Context;
import android.content.res.Resources;
import android.widget.ImageView;
import android.widget.LinearLayout;

import java.util.ArrayList;
import com.abakumov.pincode_example.R;
import com.abakumov.pincode_example.asynctask.AsyncTaskVerification;
import com.abakumov.pincode_example.interfaces.PinCodeState;


public class PinCodeUpdate implements PinCodeState {


    AsyncTaskVerification asyncTaskVerification;

    LinearLayout linearLayout;
    ArrayList<ImageView> listImageViews;
    ArrayList<String> listPinCode =  new ArrayList<>();
    Context context;

    // for get image
    Resources resources;
    // counter for click Buttons
    int countClick = 0;


    public PinCodeUpdate(ArrayList<ImageView> listImageViews, Resources resources, LinearLayout linearLayout, Context context) {
        this.listImageViews = listImageViews;
        this.resources = resources;
        this.linearLayout = linearLayout;
        this.context = context;
    }

    @Override
    public void onSetNumber(String number) {

        // add number in list
        listPinCode.add(number);
        countClick++;

        if(countClick == 4){
            // if countClick = 4
            // set image full in ImageView
            // and start Verification for PIN-code
            listImageViews.get(countClick - 1).setImageDrawable(resources.getDrawable(R.mipmap.ovalfull));
            asyncTaskVerification = new AsyncTaskVerification(listPinCode, listImageViews, resources, countClick, linearLayout,context);
            asyncTaskVerification.execute();
            countClick = 0;
        }
        else {
            listImageViews.get(countClick - 1).setImageDrawable(resources.getDrawable(R.mipmap.ovalfull));
        }
    }
}
