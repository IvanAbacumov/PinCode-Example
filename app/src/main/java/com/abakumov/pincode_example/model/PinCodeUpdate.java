package com.abakumov.pincode_example.model;

import android.content.res.Resources;
import android.os.Handler;
import android.util.Log;

import com.abakumov.pincode_example.R;

import java.util.ArrayList;
import java.util.Timer;
import java.util.TimerTask;

public class PinCodeUpdate implements  PinCodeState {

    ArrayList<PinCodeModel> pinCodeModelArrayList;
    ArrayList<String> arrayListPINcode;
    Resources resources;
    int count = 0;

    //Handler handler;

    public PinCodeUpdate(ArrayList<PinCodeModel> pinCodeModelArrayList, Resources resources) {
        this.pinCodeModelArrayList = pinCodeModelArrayList;
        this.resources = resources;
    }

    @Override
    public void onSetClickNumber(String number) {
        Log.d("asdasdasdasd", number);
        arrayListPINcode = new ArrayList<>();
        arrayListPINcode.add(number);
        count++;
        if(count > 4){
            for (int i = 0; i < pinCodeModelArrayList.size(); i++) {
                pinCodeModelArrayList.get(i).getImageView().setImageDrawable(resources.getDrawable(R.mipmap.oval));
                pinCodeModelArrayList.get(i).setBooleanOnOff(false);
            }
            count = 0;
        }
        else {
            pinCodeModelArrayList.get(count - 1).getImageView().setImageDrawable(resources.getDrawable(R.mipmap.ovalfull));
            pinCodeModelArrayList.get(count - 1).setBooleanOnOff(true);
        }
    }

  /*  private void setValues() {
        Timer timer = new Timer();

        timer.scheduleAtFixedRate(new TimerTask() {
            //Random r = new Random();
            @Override
            public void run() {
                //final   int a = r.nextInt((100-10)+1)+10;

                runOnUiThread(new Runnable() {
                    @Override
                    public void run() {
                        //Log.i("Info", "Value: " + String.valueOf(a));
                        //getCheckServer();
                    }
                });
            }
        }, 0, 3000); // 1000*60*60 - 1 час
    }

    private void runOnUiThread(Runnable runnable) {
        handler.post(runnable);
    }*/
}
