package com.ramazanov.khidirkhan.main.components;

import com.ramazanov.khidirkhan.main.exceptions.AddExitingWordException;

/**
 * Created by Хидир on 14.02.2017.
 */
public class Writer {
    private static final Object lock = new Object();

    /**
     * Данный метод записывает уникальные слова в поле DataSet.Words и в случае
     * нахождения дубликата он выдает ошибку AddExitingWordException()
     * @param word Слово
     */
    public void setWord(String word) throws AddExitingWordException {

        synchronized (lock) {
                if (!DataSet.Words.contains(word))
                    DataSet.Words.add(word);
                else {
                    throw new AddExitingWordException();
                }
            }
    }
}
