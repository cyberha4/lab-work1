package com.ramazanov.khidirkhan.main.treads;

import com.ramazanov.khidirkhan.main.components.*;

import java.util.HashSet;

/**
 * Created by Хидир on 14.02.2017.
 */
public class MainThread implements Runnable {
    String file;
    public static HashSet<Thread> threads = new HashSet<>();

    private Reader reader;
    private HandlerStrings handler;

    public MainThread(String resource){
        this.reader = new Reader(resource);
        this.handler = new HandlerStrings(new Writer());
    }

    @Override
    public void run() {
        String line;
        this.file = file;

        while(Parser.isGood && (line = readLine()) != null) {
            System.out.println(line);
            handler.handleLine(line);
        }
    }

    private String readLine(){
        return this.reader.readLine();
    }

    private void writeWord(String word){
        DataManager.setWord(word);
    }
}
