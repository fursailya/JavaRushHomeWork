package com.javarush.test.level18.lesson03.task03;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;

/* Самые частые байты
Ввести с консоли имя файла
Найти байт или байты с максимальным количеством повторов
Вывести их на экран через пробел
Закрыть поток ввода-вывода
*/

public class Solution {
    public static void main(String[] args) throws Exception {

        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String filename = reader.readLine();
        FileInputStream fileInputStream = new FileInputStream(filename);
        ArrayList<Integer> listOfBytes = new ArrayList<>();

        while (fileInputStream.available() > 0) {
            int nextByte = fileInputStream.read();
            listOfBytes.add(nextByte);
        }

        int el = find(listOfBytes);
      //  System.out.println(listOfBytes);
        System.out.println(el);
        fileInputStream.close();

    }

    static int find(ArrayList<Integer> list) {
        int first = 1;
        int last = 1;

        for(int i = 1; i < list.size(); i++) {
            int elem = 0;

            for (int j = 0; j < list.size(); j++) {
                if(list.get(i) == list.get(j)) {
                    elem++;
                }

                if(elem > first) {
                    first = elem;
                    last = i;
                }
            }
        }
        return list.get(last);
    }
}
