package com.abakumov.pincode_example.asynctask;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.content.res.Resources;
import android.os.AsyncTask;
import android.util.Log;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.Toast;

import com.abakumov.pincode_example.R;
import com.abakumov.pincode_example.animation.AnimationPack;

import java.util.ArrayList;

public class AsyncTaskVerification extends AsyncTask<Void, Void, Boolean> {


    ArrayList<String> pinCodeModelList;
    ArrayList<ImageView> imageViewList;
    LinearLayout linearLayout;
    Context context;

    // for set image in ImageView
    Resources resources;
    // param for verification(successful or unsuccessful)
    Boolean verificationOnOff = null;
    // counter for Click, for clean state ImageView
    int countClick;
    // successful verification if pin-code = 1111
    String string = "1111";
    String pinCode = "";

    // for Animation
    AnimationPack animationPack;

    // for start next Activity
    Intent intent;


    public AsyncTaskVerification(ArrayList<String> pinCodeModelList, ArrayList<ImageView> imageViewList, Resources resources, int countClick, LinearLayout linearLayout, Context context){
        this.pinCodeModelList = pinCodeModelList;
        this.imageViewList = imageViewList;
        this.resources = resources;
        this.countClick = countClick;
        this.linearLayout = linearLayout;
        this.context = context;
    }


    @Override
    protected Boolean doInBackground(Void... voids) {

        pinCode = pinCodeModelList.get(0) + pinCodeModelList.get(1) +
                pinCodeModelList.get(2) + pinCodeModelList.get(3);

        Log.d("pincodepincode", pinCode);

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
            getImageOval();
        }
        else {


            Toast toast = Toast.makeText(context,
                    "Success!",
                    Toast.LENGTH_SHORT);

            toast.show();
            getImageOval();

        }
    }

   private void getImageOval(){
        for (int i = 0; i < countClick; i++) {
            imageViewList.get(i).setImageDrawable(resources.getDrawable(R.mipmap.oval));
        }
        pinCodeModelList.clear();
    }
}
