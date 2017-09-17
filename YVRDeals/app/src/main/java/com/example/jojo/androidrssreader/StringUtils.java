package com.example.jojo.androidrssreader;

/**
 * Created by jojo on 12/9/2017.
 */

public abstract class StringUtils {

    public static String removeNBSPs(String texto){
        return texto.replace("nbsp", "");
    }
}
