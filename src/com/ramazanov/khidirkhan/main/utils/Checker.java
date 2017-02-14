package com.ramazanov.khidirkhan.main.utils;

import java.util.ArrayList;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * Created by Хидир on 08.02.2017.
 */
public class Checker {
    public static boolean validate(String str) {
        if (str.matches("[а-яА-Я0-9ёЁ\\s\\.,;:\\?!-]+"))
            return true;
        return false;
    }

    public static boolean isUrl(String str){
        return str.matches("[-a-zA-Z0-9@:%_\\+.~#?&//=]{2,256}\\.[a-z]{2,4}\\b(\\/[-a-zA-Z0-9@:%_\\+.~#?&//=]*)?");
    }

    public static boolean fileExist(String str){
        return true;
    }

    public ArrayList<String> splitLine(String line){
        Pattern p = Pattern.compile("\\b[а-яА-Я0-9-]{2,}");
        Matcher m = p.matcher(line);

        ArrayList<String> ArrayMain = new ArrayList<>();
        int i = 0;
        while(m.find()){
            ArrayMain.add(m.group());
            //System.out.println("--- " + m.group());
        }
        return ArrayMain;
    }
    //[(http(s)?):\/\/(www\.)?a-zA-Z0-9@:%._\+~#=]{2,256}\.[a-z]{2,6}\b([-a-zA-Z0-9@:%_\+.~#?&//=]*)
    //\b[а-яА-Я09-]{2,}
}
