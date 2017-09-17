package com.example.jojo.androidrssreader;

import android.content.Context;
import android.widget.Toast;

/**
 * Created by jojo on 12/9/2017.
 */

public abstract class Message {
    public static void show(Context context, String message){
        Toast.makeText(context,
                message,
                Toast.LENGTH_LONG).show();
    }
}
