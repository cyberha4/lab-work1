package com.ramazanov.khidirkhan.main.components;

import com.ramazanov.khidirkhan.main.exceptions.AddExitingWordException;
import com.ramazanov.khidirkhan.main.exceptions.NotValidStringException;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

/**
 * Created by Хидир on 15.02.2017.
 */
class HandlerStringsTest {
    @Test
    void handleLine() throws AddExitingWordException, NotValidStringException {
        HandlerStrings handle = new HandlerStrings(new Writer());

        handle.handleLine("слово1 слово2 слово3-");
        assertNotNull(DataSet.getWords());
        assertEquals(3, DataSet.getWords().size());


        assertThrows(NotValidStringException.class, () -> {
            handle.handleLine("слово1Bad");
        });

        assertThrows(AddExitingWordException.class, () -> {
            handle.handleLine("слово1");
        });
    }

}