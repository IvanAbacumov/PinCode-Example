package com.abakumov.pincode_example.model;

import android.widget.ImageView;

public class PinCodeModel {



    private ImageView imageView;
    private Boolean booleanOnOff;

    public PinCodeModel(ImageView imageView, Boolean booleanOnOff){
        this.imageView = imageView;
        this.booleanOnOff = booleanOnOff;
    }

    public ImageView getImageView() {
        return imageView;
    }


    public void setImageView(ImageView imageView) {
        this.imageView = imageView;
    }

    public Boolean getaBooleanOnOff(){
        return  booleanOnOff;
    }

    public void setBooleanOnOff(Boolean booleanOnOff){
        this.booleanOnOff = booleanOnOff;
    }
}
