package com.ramazanov.khidirkhan.main.treads;

import com.ramazanov.khidirkhan.main.Application;
import com.ramazanov.khidirkhan.main.components.*;
import com.ramazanov.khidirkhan.main.exceptions.ResourceNotFoundException;

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
        try {
            this.reader = new Reader(resource);
        } catch (ResourceNotFoundException e) {
            e.printStackTrace();
            System.out.println("-------------"+Thread.currentThread().getName()+"---------------");
            System.out.println("Ошибка чтения файла");
        }
        this.handler = new HandlerStrings(new Writer());
    }

    @Override
    public void run() {
        String line;
        this.file = file;

        Boolean stop = Application.stop;
        while(!stop && (line = readLine()) != null) {
            System.out.println(line);
            handler.handleLine(line);
        }
    }

    private String readLine(){
        return this.reader.readLine();
    }
}
