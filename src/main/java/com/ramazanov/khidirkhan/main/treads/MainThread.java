package com.ramazanov.khidirkhan.main.treads;

import com.ramazanov.khidirkhan.main.Application;
import com.ramazanov.khidirkhan.main.components.*;
import com.ramazanov.khidirkhan.main.exceptions.AddExitingWordException;
import com.ramazanov.khidirkhan.main.exceptions.NotValidStringException;
import com.ramazanov.khidirkhan.main.exceptions.ResourceNotFoundException;

import java.io.IOException;
import java.util.HashSet;

import static com.ramazanov.khidirkhan.main.Application.logger;

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
            //System.out.println("-------------"+Thread.currentThread().getName()+"---------------");
            //System.out.println("Ошибка чтения файла!");
            logger.error("Не удалось открыть ресурс!");
        }
        this.handler = new HandlerStrings(new Writer());
    }

    @Override
    public void run() {
        readResourceAndWriteResult();
    }

    private void readResourceAndWriteResult(){
        String line;
        Boolean stop = Application.stop;

        while(!stop && (line = readLine()) != null) {
            System.out.println(line);
            try {
                handler.handleLine(line);
            } catch (NotValidStringException e) {
                //System.out.println("-------------"+Thread.currentThread().getName()+"---------------");
                //System.out.println("Найден запрещенный символ в строке! "+ line);
                logger.error("Найден запрещенный символ в строке! "+ line);
                Application.stop = true;
            } catch (AddExitingWordException e) {
                //System.out.println("-------------"+Thread.currentThread().getName()+"---------------");
                //System.out.println("Найден дубликат слова " + e.getWord() + "!");
                logger.error("Найден дубликат слова " + e.getWord() + "!");
                Application.stop = true;
            }
        }
    }

    private String readLine(){
        String line;
        try {
            line = this.reader.readLine();
            return line;
        } catch (IOException e) {
            //e.printStackTrace();
            logger.error("Ошибка чтения ресурса");
            return null;
        }
    }
}
