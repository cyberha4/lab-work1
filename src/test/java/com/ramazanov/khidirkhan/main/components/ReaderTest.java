package com.ramazanov.khidirkhan.main.components;

import com.ramazanov.khidirkhan.main.exceptions.ResourceNotFoundException;
import org.junit.jupiter.api.Test;

import java.io.IOException;

import static org.junit.jupiter.api.Assertions.*;

/**
 * Created by Хидир on 15.02.2017.
 */
class ReaderTest {

    @Test
    void reader() throws ResourceNotFoundException {
        Reader reader = new Reader("C:\\files\\text1.txt");
        assertNotNull(reader.getBufferedReader());

        Reader reader2 = new Reader("https://raw.githubusercontent.com/kiberhach/lectorium-view/master/README.md");
        assertNotNull(reader2.getBufferedReader());

        assertThrows(ResourceNotFoundException.class, () -> {
            Reader reader3 = new Reader("");
            assertNull(reader3.getBufferedReader());
        });
    }

    @Test
    void readLine() throws IOException, ResourceNotFoundException {
        Reader reader = new Reader("C:\\files\\text1.txt");

        String line = reader.readLine();
        assertNotNull(line);
        assertTrue(line.split(" ").length == 3);


        try {
            Reader reader2 = new Reader("C:\\files\\text1.txt2");
            assertThrows(IOException.class, reader2::readLine);
        } catch (ResourceNotFoundException e) {
            //e.printStackTrace();
        }



    }

}