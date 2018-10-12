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
import com.abakumov.pincode_example.model.PinCodeUpdate;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    // for UI
    LinearLayout linearLayout;
    TextView logotype;
    Typeface customFont;
    ImageView imageViewNum1, imageViewNum2, imageViewNum3, imageViewNum4;


    // for set Image
    Resources resources;

    // for list(PIN-code) and list(Image)
    ArrayList<String> listPINcode;
    ArrayList<ImageView> listImageView;


    // for set full PIN-code(****)
    PinCodeUpdate pinCodeUpdate;


    Toast toast;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
          super.onCreate(savedInstanceState);
          setContentView(R.layout.activity_main);
          linearLayout = findViewById(R.id.linearLayoutPin);
          imageViewNum1= findViewById(R.id.num1);
          imageViewNum2= findViewById(R.id.num2);
          imageViewNum3= findViewById(R.id.num3);
          imageViewNum4= findViewById(R.id.num4);

          // add font for main title
          logotype = findViewById(R.id.logotype);
          installFont(logotype);

          // for Animation
          resources = getResources();

          // initial list for numbers(PIN-code)
          listPINcode = new ArrayList<>();
          // initial list for ImageView
          listImageView= new ArrayList<>();
          // add ImageView in list
          listImageView.add(imageViewNum1);
          listImageView.add(imageViewNum2);
          listImageView.add(imageViewNum3);
          listImageView.add(imageViewNum4);

          // send listImageView and resources(for animation)
          pinCodeUpdate = new PinCodeUpdate(listImageView, resources, linearLayout);
    }



    @Override
    public void onClick(View v) {
        int id = v.getId();
        switch (id) {
            case R.id.btn_1:
                addNumber("1");
                break;
            case R.id.btn_2:
                addNumber("2");
                break;
            case R.id.btn_3:
                addNumber("3");
                break;
            case R.id.btn_4:
                addNumber("4");
                break;
            case R.id.btn_5:
                addNumber("5");
                break;
            case R.id.btn_6:
                addNumber("6");
                break;
            case R.id.btn_7:
                addNumber("7");
                break;
            case R.id.btn_8:
                addNumber("8");
                break;
            case R.id.btn_9:
                addNumber("9");
                break;
            case R.id.btn_0:
                addNumber("0");
                break;
        }
    }

    private void addNumber(String number){
        toast = Toast.makeText(getApplicationContext(), number, Toast.LENGTH_SHORT);
        toast.show();
        pinCodeUpdate.onSetNumber(number);
    }

    public void installFont(TextView textView) {
        customFont = Typeface.createFromAsset(getAssets(),  "fonts/Lato-Bold.ttf");
        textView.setTypeface(customFont);
    }
}
