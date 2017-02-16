package com.ramazanov.khidirkhan.main;

import com.ramazanov.khidirkhan.main.treads.MainThread;
import com.ramazanov.khidirkhan.main.components.DataManager;
import com.ramazanov.khidirkhan.main.components.DataSet;
import com.ramazanov.khidirkhan.main.components.Parser;
import org.apache.log4j.Logger;
import org.apache.log4j.xml.DOMConfigurator;

import java.util.*;

/**
 * Created by Хидир on 08.02.2017.
 */
public class Application {
    public static final Logger logger = Logger.getLogger(Application.class);
    static {
        DOMConfigurator.configure("src/main/resources/log4j.xml");
    }

    private String[] recources;
    private HashSet<String> result;

    public static volatile boolean stop = false;

    public static void main(String[] args) {

        String resources[] = args;
        resources = getResources();

        Application app = new Application(resources);

        logger.trace("Application started");
        app.run();


        if (!stop)
            app.printResult();
        else {
            System.out.println("-----------------------------------");
            System.out.println("Что-то пошло не так!");
            logger.error("Что-то пошло не так!");
        }
    }

    private Application(String[] recources){
        this.recources = recources;
        init();
    }

    private void init(){

    }

    private void run(){
        String[] resources = this.recources;

        for (String res : resources) {
            if (!stop) {
                System.out.println(res);
                Thread thread = new Thread ( new MainThread(res));
                thread.start();
                MainThread.threads.add(thread);

            }
        }

        //Цепляем главному трэд к массиву, чтобы он ждал их окончания
        for(Thread thread:
                MainThread.threads) {
            try {
                thread.join();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }

        // Запоминаем результаты работы потоков
        if (!stop)
            this.result = getResult();
    }

    private HashSet<String> getResult(){
        return DataSet.getWords();

    }

    private void printResult(){
        HashSet<String> words = this.result;
        System.out.println("\n---------------------------------------------\n");
        for (String word:
                words
                ) {
            System.out.println(word);
        }
        System.out.println("\n--------Количество уникальных слов в ресурсах "+words.size()+"----------\n");
    }

    private static String[] getResources(){
        String fileLocation = "C:\\files\\text1.txt";
        String fileLocation1 = "C:\\files\\text2.txt";
        String fileLocation2 = "C:\\files\\text3.txt";
        String urlLocation = "https://raw.githubusercontent.com/kiberhach/lectorium-view/master/README.md";

        String[] resources = new String[4];

        resources[0] = fileLocation;
        resources[1] = fileLocation1;
        resources[2] = fileLocation2;
        resources[3] = urlLocation;

        return resources;
    }



}
