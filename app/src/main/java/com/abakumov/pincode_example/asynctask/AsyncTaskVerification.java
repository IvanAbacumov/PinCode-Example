package com.abakumov.pincode_example.asynctask;

import android.content.res.Resources;
import android.os.AsyncTask;
import android.widget.ImageView;
import android.widget.LinearLayout;

import com.abakumov.pincode_example.R;
import com.abakumov.pincode_example.animation.AnimationPack;

import java.util.ArrayList;

public class AsyncTaskVerification extends AsyncTask<Void, Void, Boolean> {


    ArrayList<String> pinCodeModelList;
    ArrayList<ImageView> imageViewList;
    LinearLayout linearLayout;

    // for set image in ImageView
    Resources resources;
    // param for verification(successful or unsuccessful)
    Boolean verificationOnOff = null;
    // counter for Click, for clean state ImageView
    int countClick;
    // successful verification if pin-code = 1111
    String string = "1111";

    // for Animation
    AnimationPack animationPack;


    public AsyncTaskVerification(ArrayList<String> pinCodeModelList, ArrayList<ImageView> imageViewList, Resources resources, int countClick, LinearLayout linearLayout){
        this.pinCodeModelList = pinCodeModelList;
        this.imageViewList = imageViewList;
        this.resources = resources;
        this.countClick = countClick;
        this.linearLayout = linearLayout;
    }


    @Override
    protected Boolean doInBackground(Void... voids) {

        String pinCode = pinCodeModelList.get(0) + pinCodeModelList.get(1) +
                pinCodeModelList.get(2) + pinCodeModelList.get(3);

        if(string.equals(pinCode)){
            verificationOnOff = true;
        }
        else {
            verificationOnOff = false;


        }
        try {
            Thread.sleep(300);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        return verificationOnOff;
    }

    @Override
    protected void onPostExecute(Boolean b) {


        if (b == false) {

            // initial class AnimationPack and start method for "Spring" animation
            animationPack = new AnimationPack(linearLayout);
            animationPack.startSpringAnimation();


            for (int i = 0; i < countClick; i++) {
                imageViewList.get(i).setImageDrawable(resources.getDrawable(R.mipmap.oval));
            }
        }
        else {
 
        }
    }
}
