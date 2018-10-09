package com.abakumov.pincode_example;


import androidx.appcompat.app.AppCompatActivity;

import androidx.dynamicanimation.animation.DynamicAnimation;
import androidx.dynamicanimation.animation.SpringAnimation;
import androidx.dynamicanimation.animation.SpringForce;

import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;

public class MainActivity extends AppCompatActivity {

        @Override
        protected void onCreate(Bundle savedInstanceState) {
            super.onCreate(savedInstanceState);
            setContentView(R.layout.activity_main);


             final ImageView img = findViewById(R.id.test);

             final SpringAnimation springAnimation = new SpringAnimation(img, DynamicAnimation.X);
             final SpringForce springForce = new SpringForce();


            img.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {



                springForce.setFinalPosition(img.getX());
                springForce.setDampingRatio(SpringForce.DAMPING_RATIO_HIGH_BOUNCY);
                springForce.setStiffness(SpringForce.STIFFNESS_LOW);

                springAnimation.setSpring(springForce);

                springAnimation.setStartVelocity(2000f);
                springAnimation.start();
                }
            });
        }
    }
