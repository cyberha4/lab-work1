package com.ramazanov.khidirkhan.main.treads;

import com.ramazanov.khidirkhan.main.components.DataSet;
import com.sun.javaws.Main;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

/**
 * Created by Хидир on 15.02.2017.
 */
class MainThreadTest {
    @Test
    void run() {
        MainThread thread = new MainThread("C:\\files\\text1.txt");

        thread.run();

        assertNotNull(DataSet.getWords());
        assertEquals(8, DataSet.getWords().size());
    }

}