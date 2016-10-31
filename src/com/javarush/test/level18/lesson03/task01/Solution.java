package com.javarush.test.level18.lesson03.task01;

import java.io.BufferedReader;
import java.io.DataInputStream;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;

/* Максимальный байт
Ввести с консоли имя файла
Найти максимальный байт в файле, вывести его на экран.
Закрыть поток ввода-вывода
*/

public class Solution {
    public static void main(String[] args) throws Exception
    {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String filename = reader.readLine(); //ввод имени файла
        ArrayList<Integer> listOfBytes = new ArrayList<>();

        FileInputStream fis = new FileInputStream(filename); //создаем поток чтения

        while (fis.available() > 0)
        { //пока есть что читать!
            int nextByte = fis.read();
            listOfBytes.add(nextByte);
        }

       // System.out.println(listOfBytes);
        System.out.println(maxByte(listOfBytes)); //выводим на экран
        fis.close();//закрываем поток
    }

    public static int maxByte(ArrayList<Integer> listOfBytes) {
        int max = 0;
        for(int i = 0; i < listOfBytes.size(); i++) {
            if(listOfBytes.get(i) > max) {
                max = listOfBytes.get(i);
            }
        }

        return max;
    }
}
