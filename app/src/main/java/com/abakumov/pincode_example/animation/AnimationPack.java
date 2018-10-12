package com.abakumov.pincode_example.animation;


import android.widget.LinearLayout;

// for Animation effect "Spring"
import androidx.dynamicanimation.animation.DynamicAnimation;
import androidx.dynamicanimation.animation.SpringAnimation;
import androidx.dynamicanimation.animation.SpringForce;

public class AnimationPack {

    LinearLayout linearLayout;
    SpringAnimation springAnimation;
    SpringForce springForce;

    public AnimationPack(LinearLayout _linearLayout){
        this.linearLayout = _linearLayout;
    }

    public void startSpringAnimation(){
        springAnimation = new androidx.dynamicanimation.animation.SpringAnimation(linearLayout, DynamicAnimation.X);
        springForce = new SpringForce();


        springForce.setFinalPosition(linearLayout.getX());
        springForce.setDampingRatio(SpringForce.DAMPING_RATIO_HIGH_BOUNCY);
        springForce.setStiffness(1200f);

        springAnimation.setSpring(springForce);

        springAnimation.setStartVelocity(4000f);
        springAnimation.start();
    }
}

