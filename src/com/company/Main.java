package com.company;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class Main {
    public static void main(String[] args) {
        int lim = 100;                                                             // количество бросков
        Map<Integer, Integer> numbers = new HashMap<Integer, Integer>();
        ArrayList<Integer> intermediateArray = new ArrayList<>();
        Map.Entry< Integer, Integer > maxEntry = null;
        for (int i = 0; i < lim; i++) {
            int trowBones = (int) (1 + Math.random() * 6);                          // бросаем кости
            int trowBones1 = (int) (1 + Math.random() * 6);
            int sum = trowBones + trowBones1;                                       // находим сумму очков
            intermediateArray.add(sum);                                             // записываем сумму очков во временный массив
        }
        for (int i = 0; i < intermediateArray.size(); i++) {                        // перебираем массив
            Integer tempInt = intermediateArray.get(i);
            if (!numbers.containsKey(tempInt)) {
                numbers.put(tempInt, 1);                                            //если значение встречается один раз то просто записываем его
            } else {
                numbers.put(tempInt, numbers.get(tempInt) + 1);                     // если встречается еще то добавляем 1 в значение при каждой встрече такого значения
            }
        }
        for (Map.Entry<Integer, Integer> entry : numbers.entrySet()) {                                         //выводим результаты
            System.out.println("Комбинация " + entry.getKey() + " повторяется " + entry.getValue() + " раз");
            if (maxEntry == null || entry.getValue().compareTo(maxEntry.getValue()) > 0)// если максимум не определен или очередное значение ещё больше
            {
                maxEntry = entry;                                       // то присваем максимуму новое значение
            }
        }
        System.out.println("Комбинация = максимальное количество повторений: " + maxEntry);
    }
}
