package com.ramazanov.khidirkhan.main.utils;

import java.util.ArrayList;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * Created by Хидир on 08.02.2017.
 */
public class Checker {
    /**
     * Проверяем, что строка содержит только разрешенные
     * символы (русские буквы, цифры, знаки препинания)
     *
     * @param str передаем строку для проверки
     * @return true если строка не содержит запрещенных символов, false в случае, если содержит
     */
    public static boolean validate(String str) {
        return str.matches("[а-яА-Я0-9ёЁ\\s\\.,;:\\?!-]+");
    }

    /**
     * Проверяем строку, содержащую URL ссылку на корректность
     *
     * @param str передаем строку для проверки
     * @return true если строка является корректным URL адресом и false, если это не так
     */
    public static boolean isUrl(String str){
        return str.matches("[-a-zA-Z0-9@:%_\\+.~#?&//=]{2,256}\\.[a-z]{2,4}\\b(\\/[-a-zA-Z0-9@:%_\\+.~#?&//=]*)?");
    }

    /**
     * Разбиваем строку на массив символов (игнорируя знаки препинания)
     *
     * @param line передаем строку, которую будем разбивать
     * @return ArrayList<String> со словами из переданной строки.
     */
    public static ArrayList<String> splitLine(String line){
        Pattern p = Pattern.compile("\\b[а-яА-Я0-9-]{2,}\\b");
        Matcher m = p.matcher(line);

        ArrayList<String> ArrayMain = new ArrayList<>();
        int i = 0;
        while(m.find()){
            ArrayMain.add(m.group());
            //System.out.println("--- " + m.group());
        }
        return ArrayMain;
    }
}
