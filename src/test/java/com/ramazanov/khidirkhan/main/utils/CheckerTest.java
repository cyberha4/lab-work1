package com.ramazanov.khidirkhan.main.utils;

import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.*;

/**
 * Created by Хидир on 14.02.2017.
 */
class CheckerTest {
    @org.junit.jupiter.api.Test
    void validate() {
        assertFalse(Checker.validate(""));

        assertTrue(Checker.validate("Слово с английской а"));
    }

    @org.junit.jupiter.api.Test
    void isUrl() {
        assertFalse(Checker.isUrl(""));
        assertFalse(Checker.isUrl("C:\\Users\\Хидир\\Downloads"));
        assertFalse(Checker.isUrl("/feed"));

        assertTrue(Checker.isUrl("http://music.yandex.ru/feed"));
        assertTrue(Checker.isUrl("https://music.yandex.ru/feed"));
        assertTrue(Checker.isUrl("www.music.yandex.ru/feed"));
    }


    @org.junit.jupiter.api.Test
    void splitLine() {

        String someWords = "слово слово2 слово3 слово4";

        ArrayList<String> list = Checker.splitLine(someWords);

        System.out.println(someWords);

        assertTrue(list.contains("слово"));
        assertTrue(list.contains("слово2"));
        assertTrue(list.contains("слово3"));
        assertTrue(list.contains("слово4"));
        assertEquals(4, list.size());

    }

}