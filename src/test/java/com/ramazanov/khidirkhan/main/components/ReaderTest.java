package com.ramazanov.khidirkhan.main.components;

import com.ramazanov.khidirkhan.main.exceptions.ResourceNotFoundException;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

/**
 * Created by Хидир on 15.02.2017.
 */
class ReaderTest {

    @Test
    void reader() throws ResourceNotFoundException {
        Reader reader = new Reader("C:\\files\\text1.txt");
        assertNotNull(reader.getBr());

        Reader reader2 = new Reader("https://raw.githubusercontent.com/kiberhach/lectorium-view/master/README.md");
        assertNotNull(reader2.getBr());

        Reader reader3 = new Reader("");
        assertNull(reader3.getBr());

        //Осталось обработать ошибки
    }
    @Test
    void readLine() {


    }

}