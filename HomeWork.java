package HomeWorkJava;

import java.util.*;

public class HomeWork {

    public static void printStats(String text) {
        // 1. Преобразование текста: приведение к нижнему регистру и удаление запятых и точек.
        text = text.replaceAll("[.,]", "").toLowerCase();

        // 2. Разделение текста на слова.
        String[] words = text.split("\\s+");

        // 3. Сбор структуры со статистикой.
        Map<Integer, List<String>> stats = new TreeMap<>(); // Используем TreeMap для автоматической сортировки ключей.

        for (String word : words) {
            if (!word.isEmpty() && !word.equals("-")) { // Пропускаем пустые строки и дефисы.
                int length = word.length();
                List<String> wordsWithSameLength = stats.getOrDefault(length, new ArrayList<>());
                wordsWithSameLength.add(word);
                stats.put(length, wordsWithSameLength);
            }
        }

        // 4. Вывод статистики.
        for (Map.Entry<Integer, List<String>> entry : stats.entrySet()) {
            int length = entry.getKey();
            List<String> wordList = entry.getValue();
            System.out.println(length + " -> " + wordList);
        }
    }

    public static void main(String[] args) {
        String text = "Это мой первый текст. Он состоит из каких-то тестовых слов и нужен для того, чтобы " +
                "выполнить тестовое задание GB. Данный текст не несет в себе какого-либо смысла, он просто содержит набор слов.";

        printStats(text);
    }
}

