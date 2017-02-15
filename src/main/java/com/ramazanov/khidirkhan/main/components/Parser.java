package com.ramazanov.khidirkhan.main.components;

import jdk.nashorn.api.scripting.URLReader;

import java.io.*;
import java.net.MalformedURLException;
import java.net.URL;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.*;

/**
 * Created by Хидир on 08.02.2017.
 */
@Deprecated
public class Parser implements Runnable {
    private String file;
    private Thread T;
    public static volatile boolean isGood = true;
    public static HashSet<Thread> threads = new HashSet<>();

    /*private ArrayList<String> splitLine(String line){
        Pattern p = Pattern.compile("\\b[а-яА-Я0-9-]{2,}");
        Matcher m = p.matcher(line);

        ArrayList<String> ArrayMain = new ArrayList<>();
        int i = 0;
        while(m.find()){
            ArrayMain.add(m.group());
            //System.out.println("--- " + m.group());
        }
        return ArrayMain;
    }*/

    private void writeWords(String line) {
        try {
            //Проверяем наличие запрещенных символов в считанной строке
            if (!validate(line))
                throw new Exception();
        } catch (Exception E){
            System.out.println("-------------"+Thread.currentThread().getName()+"---------------");
            System.out.println("Найден запрещенный символ в строке! "+ line);
            isGood=false;
        }

        ArrayList<String> words = Checker.splitLine(line);
        for(String word:words){
            System.out.println(word+" name:"+this.T.getName());
            writeWord(word);
        }
    }
    private boolean validate(String line){
        return Checker.validate(line);
    }

    private void writeWord(String word){
        DataManager.setWord(word);
    }

    public  Parser(String file){
        this.file = file;
        T = new Thread(this);
        T.start();
        threads.add(T);
    }
    @Override
    public void run() {
        try {
            readFileBuffer(file);
        } catch (Exception e) {
            System.out.println("-------------"+Thread.currentThread().getName()+"---------------");
            System.out.println("resourse is not good");
            e.printStackTrace();
        }
    }

    private void readFileBuffer(String file){
        String s;
        URL url = null;
        if (Checker.isUrl(file)) {

            try {
                url = new URL(file);
            } catch (MalformedURLException e) {
                e.printStackTrace();
            }
            try(BufferedReader br = new BufferedReader(new URLReader(url))) {
                while (isGood && (s = br.readLine()) != null) {
                    writeWords(s);
                }
            } catch (IOException e) {
                e.printStackTrace();
                System.out.println("-------------"+Thread.currentThread().getName()+"---------------");
                System.out.println("Ошибка чтения URL");
            }
        }
        else {
            try (BufferedReader br = new BufferedReader(new FileReader(file))) {
                while (isGood && (s = br.readLine()) != null) {
                    writeWords(s);
                }
            } catch (IOException e) {
                isGood = false;
                e.printStackTrace();
                System.out.println("-------------"+Thread.currentThread().getName()+"---------------");
                System.out.println("Ошибка чтения файла");
            }
        }

    }
    private List<String> readFile(String file) throws IOException {
        List<String> lines = Files.readAllLines(Paths.get(file), StandardCharsets.UTF_8);
        System.out.println(lines);
        return lines;
    }

}
