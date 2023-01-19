package TesterLists;

import java.util.*;

public class Methods {
    /** Створити метод countOccurance, що приймає на вхід рядковий список як параметр і довільний рядок.
     Список заповнений довільними словами 10-20 штук, які можуть повторюватись у необмеженій кількості.
     Порахувати скільки разів зустрічається переданий рядок як другий аргумент */
    public static int countOccurance(List<String> words, String regularEx) {
        int counter = 0;
        for (String word : words) {
            if (word.equalsIgnoreCase(regularEx.trim())) {
                counter++;
            }
        }
        return counter;
    }
    /**Створити метод toList, що приймає на вхід цілісний масив довільної довжини.
     Конвертувати масив у список відповідного типу даних та повернути з методу*/

    public static List<?> toList(Object[] inputSequense) {
        List<Object> outputArray = new ArrayList<>();
        Collections.addAll(outputArray, inputSequense);
        return outputArray;
    }

    /** Створити метод findUnique, що приймає на вхід числовий список, що складається з довільних значень,
     які можуть повторюватися в необмеженій кількості.
     Необхідно повернути новий числовий список, що містить тільки унікальні числа */
    public static List<Number> findUnique(List<Number> inputSequense) {
        List<Number> uniqueSequense = new LinkedList<>();
        Collection<Number> repeatSequense = new ArrayList<>();
        for (Number number : inputSequense) {
            if (!uniqueSequense.contains(number)) {
                uniqueSequense.add(number);
            } else {
                repeatSequense.add(number);
            }
        }
        uniqueSequense.removeAll(repeatSequense);
        return uniqueSequense;
    }

    /** Створити метод calcOccurance, який приймає на вхід рядковий список як параметр.
     Список заповнений довільними словами 10-20 штук, які можуть повторюватись у необмеженій кількості.
     Обчислити скільки разів трапляється кожне слово. Результат вивести у консоль */
    public static void calcOccurance(List<String> words) {
        ArrayList<String> uniqueWords = new ArrayList<>();
        ArrayList<Integer> counter = new ArrayList<>();
        for (String word : words) {
            if (!uniqueWords.contains(word)) {
                uniqueWords.add(word);
                counter.add(1);
            } else {
                int indexOfRepeatWord = uniqueWords.indexOf(word);
                counter.set(indexOfRepeatWord, counter.get(indexOfRepeatWord) + 1);
            }
        }
        Iterator<String> iterWords = uniqueWords.iterator();
        Iterator<Integer> iterCounts = counter.iterator();
        if (iterWords.hasNext() && iterCounts.hasNext()) {
            do {
                System.out.printf("%s : %d \n", iterWords.next(), iterCounts.next());
            } while (iterWords.hasNext() && iterCounts.hasNext());
        }
    }

    /** Створити метод findOccurance, що приймає на вхід рядковий список як параметр.
     * Список заповнений довільними словами 10-20 штук, які можуть повторюватись у необмеженій кількості.
     * Обчислити скільки разів трапляється кожне слово. Результат повернути у вигляді списку структур,
     * що описують повторення кожного окремого взятого слова */
    public static List<Occurance> findOccurance(List<String> words) {
        ArrayList<Occurance> uniqueWords = new ArrayList<>();
        for (String word : words) {
            Occurance testWord = new Occurance(word);
            int localIndex = uniqueWords.indexOf(testWord);
            if (localIndex == -1) {
                uniqueWords.add(testWord);
            } else {
                uniqueWords.get(localIndex).setOccurance();
            }
        }
        return uniqueWords;
    }
}

