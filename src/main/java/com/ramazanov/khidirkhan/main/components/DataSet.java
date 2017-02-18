package com.ramazanov.khidirkhan.main.components;

import java.util.HashSet;

/**
 * Created by Хидир on 14.02.2017.
 */
public class DataSet {
    /**
     * Подумать над размром коллекции!!!!
     */
    private static HashSet<String> Words = new HashSet<>();

    /**
     * Данный метод метод возвращает набор уникальных слов, полученных при обработки всех ресурсов.
     * @return HashSet набор уникальных слов
     */
    public static HashSet<String> getWords() {
        return Words;
    }
}
