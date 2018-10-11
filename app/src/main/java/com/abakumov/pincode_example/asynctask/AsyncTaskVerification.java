package com.abakumov.pincode_example.asynctask;

import android.content.res.Resources;
import android.os.AsyncTask;
import android.widget.Toast;

import com.abakumov.pincode_example.R;
import com.abakumov.pincode_example.model.PinCodeModel;

import java.util.ArrayList;

public class AsyncTaskVerification extends AsyncTask<Void, Void, Boolean> {

    ArrayList<String> pinCodeModelArrayList;
    ArrayList<PinCodeModel> imageViewList;
    Resources resources;
    String string = "1111";
    public AsyncTaskVerification(ArrayList<String> pinCodeModelArrayList, ArrayList<PinCodeModel> imageViewList,  Resources resources){
        this.pinCodeModelArrayList = pinCodeModelArrayList;
        this.imageViewList = imageViewList;
        this.resources = resources;
    }


    @Override
    protected Boolean doInBackground(Void... voids) {
        Boolean verificationOnOff = null;
        String pinCode = pinCodeModelArrayList.get(0) + pinCodeModelArrayList.get(1) +
                pinCodeModelArrayList.get(2) + pinCodeModelArrayList.get(3);
        if(string.equals(pinCode)){
            verificationOnOff = true;
        }
        else {

            verificationOnOff = false;
        }
        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        return verificationOnOff;
    }

    @Override
    protected void onPostExecute(Boolean b) {


        if (b == false) {
            for (int i = 0; i < pinCodeModelArrayList.size(); i++) {
                imageViewList.get(i).getImageView().setImageDrawable(resources.getDrawable(R.mipmap.oval));
                imageViewList.get(i).setBooleanOnOff(false);
            }
        } else {

        }
    }
}
