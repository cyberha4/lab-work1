package com.ramazanov.khidirkhan.main.components;

import com.ramazanov.khidirkhan.main.exceptions.AddExitingWordException;
import org.junit.jupiter.api.Test;

import java.util.HashSet;

import static org.junit.jupiter.api.Assertions.*;

/**
 * Created by Хидир on 15.02.2017.
 */
class WriterTest {
    @Test
    void setWord() throws AddExitingWordException {
        Writer writer = new Writer();

        String[] words = new String[3];

        words[0] = "неряшливый";
        words[1] = "изворотливый";
        words[2] = "забор";

        for(String word:
                words){
            writer.setWord(word);
        }

        HashSet<String> savedWords = DataSet.getWords();
        assertNotNull(savedWords);

        assertEquals(3,savedWords.size());
        assertTrue(savedWords.contains(words[0]));
        assertTrue(savedWords.contains(words[1]));
        assertTrue(savedWords.contains(words[2]));

        // Узнать обязательно ли пробрасывать исключения наверх (потому что без этого не получается
        assertThrows(AddExitingWordException.class, () -> {
            //throw new AddExitingWordException();
            writer.setWord("неряшливый");
        });



    }

}