package com.ramazanov.khidirkhan.main.components;

import jdk.nashorn.api.scripting.URLReader;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;

/**
 * Created by Хидир on 14.02.2017.
 */
public class Reader {
    private String file;
    private BufferedReader br;

    public Reader(String file){
        this.file = file;
        String s;

        if (Checker.isUrl(file)) {
            URLReader urlReader;
            try {
                urlReader = new URLReader(new URL(file));
                br = new BufferedReader(urlReader);
                this.br = br;
            } catch (MalformedURLException e) {
                e.printStackTrace();
            }

        } else {
            FileReader fileReader = null;
            try {
                fileReader = new FileReader(file);
                this.br = new BufferedReader(fileReader);
                this.br = br;
            } catch (FileNotFoundException e) {
                Parser.isGood = false;
                e.printStackTrace();
                System.out.println("-------------"+Thread.currentThread().getName()+"---------------");
                System.out.println("Ошибка чтения файла");
            }
        }
    }

    public String readLine() {
        String line = null;

        try {
            line = br.readLine();
        } catch (IOException e) {
            e.printStackTrace();
        }

        return line;
    }
}
