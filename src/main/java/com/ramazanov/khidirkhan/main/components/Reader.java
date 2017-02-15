package com.ramazanov.khidirkhan.main.components;

import com.ramazanov.khidirkhan.main.Application;
import com.ramazanov.khidirkhan.main.exceptions.ResourceNotFoundException;
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

    /**
     * В конструктор передается файл, который в дальнейшем можно будет построчно считывать
     * @param file
     * @throws ResourceNotFoundException
     */
    public Reader(String file) throws ResourceNotFoundException {
        this.file = file;
        String s;

        if (isUrl(file)) {
            try {
                URLReader urlReader = new URLReader(new URL(file));
                this.br = new BufferedReader(urlReader);
            } catch (MalformedURLException e) {
                throw new ResourceNotFoundException();
            }
        } else {
            try {
                FileReader fileReader = new FileReader(file);
                this.br = new BufferedReader(fileReader);
            } catch (FileNotFoundException e) {
                Application.stop = true;
                throw new ResourceNotFoundException();
            }
        }
    }

    public BufferedReader getBufferedReader(){
        return this.br;
    }

    /**
     * Метод считывает строку из данного ресурса
     *
     * @return считанная с ресурса строка
     * @throws IOException
     */
    public String readLine() throws IOException {
        return br.readLine();
    }

    /**
     * Проверяем строку, содержащую URL ссылку на корректность
     *
     * @param str передаем строку для проверки
     * @return true если строка является корректным URL адресом и false, если это не так
     */
    private boolean isUrl(String str){
        return str.matches("[-a-zA-Z0-9@:%_\\+.~#?&//=]{2,256}\\.[a-z]{2,4}\\b(\\/[-a-zA-Z0-9@:%_\\+.~#?&//=]*)?");
    }
}
