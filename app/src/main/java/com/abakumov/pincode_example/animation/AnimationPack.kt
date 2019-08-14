package com.abakumov.pincode_example.animation


import android.widget.LinearLayout

// for Animation effect "Spring"
import androidx.dynamicanimation.animation.DynamicAnimation
import androidx.dynamicanimation.animation.SpringAnimation
import androidx.dynamicanimation.animation.SpringForce

class AnimationPack(private var linearLayout: LinearLayout) {
    private lateinit var springAnimation: SpringAnimation
    private lateinit var springForce: SpringForce

    fun startSpringAnimation() {
        springAnimation = SpringAnimation(linearLayout, DynamicAnimation.X)
        springForce = SpringForce()


        springForce.finalPosition = linearLayout.x
        springForce.dampingRatio = SpringForce.DAMPING_RATIO_HIGH_BOUNCY
        springForce.stiffness = 1200f

        springAnimation.spring = springForce

        springAnimation.setStartVelocity(4000f)
        springAnimation.start()
    }
}

