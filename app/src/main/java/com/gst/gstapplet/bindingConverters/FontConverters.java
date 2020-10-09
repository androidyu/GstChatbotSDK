package com.gst.gstapplet.bindingConverters;

import android.graphics.Typeface;
import android.text.TextPaint;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

import androidx.databinding.BindingAdapter;


public class FontConverters {
    @BindingAdapter("android:textStyle")
    public static void setTextStyle(View view, String style) {
        TextView textView = null;
        if (view instanceof TextView) {
            textView = (TextView) view;
            switch (style) {
                case "bold":
//                    textView.setTypeface(null, Typeface.BOLD);
                    TextPaint paint = textView.getPaint();
                    paint.setFakeBoldText(true);
                    break;
                case "normal":
                    textView.setTypeface(null, Typeface.NORMAL);
                    TextPaint paint2 = textView.getPaint();
                    paint2.setFakeBoldText(false);
                    break;
            }
        }
    }

    @BindingAdapter("android:text")
    public static void setTypeFace(TextView view, String text) {
        EditText editText = null;
        Typeface typeface = FontCache.getTypeface("fonts/Roboto-Regular.ttf", view.getContext());
        if (view instanceof TextView) {
            view.setTypeface(typeface);
            view.setText(text);
        } else if (view instanceof EditText) {
            editText = (EditText) view;
            editText.setTypeface(typeface);
        }
    }
}
