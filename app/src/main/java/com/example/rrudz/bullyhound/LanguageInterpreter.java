/**
 * Created by aassadjr on 2/25/2017.
 */

package com.example.rrudz.bullyhound;


//import android.app.ListActivity;
import android.content.res.Resources;
//import android.os.Bundle;

public class LanguageInterpreter {

    static String[] badWords = Resources.getSystem().getStringArray(R.array.bad_words);

    public static boolean CheckString(String inputStr){
        for(String current : badWords){
            if(inputStr.toLowerCase().contains(current.toLowerCase()))
                return true;
        }
        return false;
    }
}
