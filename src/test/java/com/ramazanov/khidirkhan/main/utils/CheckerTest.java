package com.ramazanov.khidirkhan.main.utils;

import static org.junit.jupiter.api.Assertions.*;

/**
 * Created by Хидир on 14.02.2017.
 */
class CheckerTest {
    @org.junit.jupiter.api.Test
    void validate() {
        assertFalse(Checker.validate(""));
        assertFalse(Checker.validate("htt://music.yandex.ru/feed"));
        assertTrue(Checker.validate("http://music.yandex.ru/feed"));
        assertTrue(Checker.validate("https://music.yandex.ru/feed"));
    }

    @org.junit.jupiter.api.Test
    void isUrl() {
    }

    @org.junit.jupiter.api.Test
    void fileExist() {

    }

    @org.junit.jupiter.api.Test
    void splitLine() {

    }

}