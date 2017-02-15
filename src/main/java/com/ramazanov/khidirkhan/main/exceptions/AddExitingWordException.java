package com.ramazanov.khidirkhan.main.exceptions;

/**
 * Created by Хидир on 15.02.2017.
 */
public class AddExitingWordException extends Exception {
    private String word;
    public AddExitingWordException(){

    }

    public AddExitingWordException(String word){
        this.word = word;
    }

    public String getWord(){
        return this.word;
    }
}
