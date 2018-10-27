package com.mib.bumblebee;

import android.animation.ArgbEvaluator;
import android.animation.ObjectAnimator;
import android.animation.ValueAnimator;
import android.graphics.Color;
import android.view.View;

public class Animations {

    public static void rgbBackground(View layoutId){
        ValueAnimator skyAnim = ObjectAnimator.ofInt
                (layoutId, "backgroundColor",
                        Color.rgb(85, 212, 255),
                        Color.rgb(255, 127, 255),
                        Color.rgb(170, 127, 255),
                        Color.rgb(69, 196, 154));
        skyAnim.setDuration(7000);
        skyAnim.setRepeatCount(ValueAnimator.INFINITE);
        skyAnim.setRepeatMode(ValueAnimator.REVERSE);
        skyAnim.setEvaluator(new ArgbEvaluator());
        skyAnim.start();

    }
}
