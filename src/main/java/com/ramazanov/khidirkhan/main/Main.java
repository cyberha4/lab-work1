package com.ramazanov.khidirkhan.main;

import com.ramazanov.khidirkhan.main.utils.DataManager;
import com.ramazanov.khidirkhan.main.utils.Parser;

import java.util.*;

/**
 * Created by Хидир on 08.02.2017.
 */
public class Main {
    public static void main(String[] args) {

        String res[] = args;
        res = getResources();

        for (String re : res) {
            if (Parser.isGood) {
                System.out.println(re);
                new Parser(re);
            }
        }

        //Цепляем массивы к главному трэду, чтобы он ждал их окончания
        for(Thread thread:
                Parser.threads) {
            try {
                thread.join();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }

        if (Parser.isGood)
            printResult();
        else {
            System.out.println("-----------------------------------");
            System.out.println("Что-то пошло не так!");
        }

    }

    private static void printResult(){
        HashSet<String> words = DataManager.getWords();
        System.out.println("\n--------Количество уникальных слов в ресурсах "+words.size()+"----------\n");

        for (String word:
                words
                ) {
            System.out.println(word);
        }
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
