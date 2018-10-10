package com.abakumov.pincode_example;


import androidx.appcompat.app.AppCompatActivity;

import android.content.res.Resources;
import android.graphics.Typeface;
import android.os.Bundle;




// for UI elements
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.abakumov.pincode_example.animation.AnimationPack;
import com.abakumov.pincode_example.model.PinCodeModel;
import com.abakumov.pincode_example.model.PinCodeState;
import com.abakumov.pincode_example.model.PinCodeUpdate;

import java.util.ArrayList;
import java.util.HashMap;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    // for UI
    LinearLayout linearLayout;
    ImageView imageViewNum1, imageViewNum2, imageViewNum3, imageViewNum4;
    Resources res;

    // for Animation
    AnimationPack animationPack;

    ArrayList<String> arrayListPINcode;
    ArrayList<PinCodeModel> pinCodeModelArrayList;

    PinCodeModel a1, a2, a3, a4;
    PinCodeUpdate pinCodeUpdate;

    int count = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
          super.onCreate(savedInstanceState);
          setContentView(R.layout.activity_main);
          arrayListPINcode = new ArrayList<>();
          pinCodeModelArrayList = new ArrayList<>();

         res = getResources();

          linearLayout = findViewById(R.id.linearLayoutPin);
          imageViewNum1= findViewById(R.id.num1);
          imageViewNum2= findViewById(R.id.num2);
          imageViewNum3= findViewById(R.id.num3);
          imageViewNum4= findViewById(R.id.num4);




          a1 = new PinCodeModel(imageViewNum1, false);
          a2 = new PinCodeModel(imageViewNum2, false);
          a3 = new PinCodeModel(imageViewNum3, false);
          a4 = new PinCodeModel(imageViewNum4, false);



        pinCodeModelArrayList.add(a1);
        pinCodeModelArrayList.add(a2);
        pinCodeModelArrayList.add(a3);
        pinCodeModelArrayList.add(a4);



        pinCodeUpdate = new PinCodeUpdate(pinCodeModelArrayList, res);


        // add font for main title
        TextView tx = findViewById(R.id.logotype);
        Typeface custom_font = Typeface.createFromAsset(getAssets(),  "fonts/Lato-Bold.ttf");
        tx.setTypeface(custom_font);



          // initial class AnimationPack and start method for "Spring" animation
          animationPack = new AnimationPack(linearLayout);
          animationPack.startSpringAnimation();

    }

    @Override
    public void onResume() {
        super.onResume();

    }

    /*
    public void collectPINcode(String number, int count_test){
        arrayListPINcode.add(number);
        Resources res = getResources();
        if(count_test!=0 && count_test<=4){
            pinCodeModelArrayList.get(count_test-1).getImageView().setImageDrawable(res.getDrawable(R.mipmap.ovalfull));
            pinCodeModelArrayList.get(count_test-1).setBooleanOnOff(true);
        }
        else if(count_test>=5){
            for(int i = 0;i<pinCodeModelArrayList.size(); i++){
                pinCodeModelArrayList.get(i).getImageView().setImageDrawable(res.getDrawable(R.mipmap.oval));
                pinCodeModelArrayList.get(i).setBooleanOnOff(false);
            }
            count = 0;
        }
        else{
          /*  for(int i = 0;i<pinCodeModelArrayList.size(); i++){
                pinCodeModelArrayList.get(i).getImageView().setImageDrawable(res.getDrawable(R.mipmap.oval));
                pinCodeModelArrayList.get(i).setBooleanOnOff(false);
            } */
       /* }


    } */

    @Override
    public void onClick(View v) {
        int id = v.getId();
        Toast toast;
        switch (id) {
            case R.id.btn_1:
                toast = Toast.makeText(getApplicationContext(), "1", Toast.LENGTH_SHORT);
                toast.show();
                count++;
                //collectPINcode("1", count);
                pinCodeUpdate.onSetClickNumber("1");
                break;
            case R.id.btn_2:
                toast = Toast.makeText(getApplicationContext(), "2", Toast.LENGTH_SHORT);
                toast.show();
                count++;
                //collectPINcode("2", count);
                pinCodeUpdate.onSetClickNumber("2");
                break;
            case R.id.btn_3:
                toast = Toast.makeText(getApplicationContext(), "3", Toast.LENGTH_SHORT);
                toast.show();
                count++;
                //collectPINcode("3", count);
                pinCodeUpdate.onSetClickNumber("3");
                break;
            case R.id.btn_4:
                toast = Toast.makeText(getApplicationContext(), "4", Toast.LENGTH_SHORT);
                toast.show();
                count++;
                //collectPINcode("4", count);
                pinCodeUpdate.onSetClickNumber("4");
                break;
            case R.id.btn_5:
                toast = Toast.makeText(getApplicationContext(), "5", Toast.LENGTH_SHORT);
                toast.show();
                count++;
                //collectPINcode("5", count);
                pinCodeUpdate.onSetClickNumber("5");
                break;
            case R.id.btn_6:
                toast = Toast.makeText(getApplicationContext(), "6", Toast.LENGTH_SHORT);
                toast.show();
                count++;
                //collectPINcode("6", count);
                pinCodeUpdate.onSetClickNumber("6");
                break;
            case R.id.btn_7:
                toast = Toast.makeText(getApplicationContext(), "7", Toast.LENGTH_SHORT);
                toast.show();
                count++;
                //collectPINcode("7", count);
                pinCodeUpdate.onSetClickNumber("7");
                break;
            case R.id.btn_8:
                toast = Toast.makeText(getApplicationContext(), "8", Toast.LENGTH_SHORT);
                toast.show();
                count++;
                //collectPINcode("8", count);
                pinCodeUpdate.onSetClickNumber("8");
                break;
            case R.id.btn_9:
                toast = Toast.makeText(getApplicationContext(), "9", Toast.LENGTH_SHORT);
                toast.show();
                count++;
                //collectPINcode("9", count);
                pinCodeUpdate.onSetClickNumber("9");
                break;
            case R.id.btn_0:
                toast = Toast.makeText(getApplicationContext(), "0", Toast.LENGTH_SHORT);
                toast.show();
                //collectPINcode("0", count);
                pinCodeUpdate.onSetClickNumber("0");
                break;
        }
    }
}
