package com.ramazanov.khidirkhan.main.components;

import com.ramazanov.khidirkhan.main.extensions.AddExitingWordException;

import java.util.HashSet;

/**
 * Created by Хидир on 14.02.2017.
 */
public class Writer {
    private static final Object lock = new Object();
    private static HashSet<String> Words = new HashSet<>();

    public static HashSet<String> getWords() {
        return Words;
    }

    public void setWord(String word) {

        synchronized (lock) {
            try {
                if (!DataSet.Words.contains(word))
                    DataSet.Words.add(word);
                else {
                    throw new AddExitingWordException();
                }
            } catch (AddExitingWordException e) {
                System.out.println("-------------"+Thread.currentThread().getName()+"---------------");
                System.out.println("Найден дубликат слова "+word);
                Parser.isGood = false;
            }
        }
    }
}
