package com.ramazanov.khidirkhan.main.components;

import java.util.HashSet;

/**
 * Created by Хидир on 08.02.2017.
 */
@Deprecated
public class DataManager {
    public static Object lock = new Object();
    private static HashSet<String> Words = new HashSet<>();

    public static HashSet<String> getWords() {
        return Words;
    }

    public static void setWord(String word) {
        synchronized (lock) {
            try {
                if (!Words.contains(word))
                    Words.add(word);
                else {
                    throw new Exception();
                }
            } catch (Exception e) {
                System.out.println("-------------"+Thread.currentThread().getName()+"---------------");
                System.out.println("Найден дубликат слова "+word);
                Parser.isGood = false;
            }
        }
    }

}