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

    public Reader(String file) throws ResourceNotFoundException {
        this.file = file;
        String s;

        if (isUrl(file)) {
            try {
                URLReader urlReader = new URLReader(new URL(file));
                this.br = new BufferedReader(urlReader);
            } catch (MalformedURLException e) {
                e.printStackTrace();
                throw new ResourceNotFoundException();
            }
        } else {
            try {
                FileReader fileReader = new FileReader(file);
                this.br = new BufferedReader(fileReader);
            } catch (FileNotFoundException e) {
                Application.stop = true;
                e.printStackTrace();
                throw new ResourceNotFoundException();
            }
        }
    }

    public BufferedReader getBr(){
        return br;
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

    private boolean isUrl(String str){
        return str.matches("[-a-zA-Z0-9@:%_\\+.~#?&//=]{2,256}\\.[a-z]{2,4}\\b(\\/[-a-zA-Z0-9@:%_\\+.~#?&//=]*)?");
    }
}
