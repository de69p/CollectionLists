package phonebook;

import java.util.ArrayList;
import java.util.List;
/** Клас Телефонний Довідник зберігає безліч записів типу даних Запис */
public class TelephoneDirectory<T> {
    private static final int DEFAULT_CAPACITY = 10;
    private Object[] insideStorage = new Object[DEFAULT_CAPACITY];
    private int counterNewObjects = 0;

    /** У класі Телефонний Довідник реалізувати метод add. Метод додає Запис до Телефонного Довідника.
     Примітка: Під одним прізвищем може зберігатися кілька телефонів, тому можлива наявність декількох записів */
    public void add(T object) {
        if (counterNewObjects < insideStorage.length) {
            insideStorage[counterNewObjects] = object;
        } else {
            Object[] copyStorage = new Object[insideStorage.length + insideStorage.length / 2];
            System.arraycopy(insideStorage, 0, copyStorage, 0, insideStorage.length);
            insideStorage = copyStorage;
            insideStorage[counterNewObjects] = object;
        }
        counterNewObjects++;
    }

    public int size() {
        return counterNewObjects;
    }

    /** У класі Телефонний Довідник реалізувати метод find(). Метод здійснює пошук конкретного запису на ім'я.
     Якщо запис знайдений (перший знайдений), тоді його необхідно повернути, інакше повертається null */
    public T find(String name) {
        for (int i = 0; i < size(); i++) {
            T iterationObject = (T) insideStorage[i];
            if (iterationObject.equals(name)) {
                return iterationObject;
            }
        }
        return null;
    }

    /** У класі Телефонний Довідник реалізувати метод findAll(). Метод здійснює пошук записів на ім'я.
     Якщо записи знайдені, тоді їх необхідно повернути, інакше повертається null */
    public List<T> findAll(String name) {
        List<T> outputArray = new ArrayList<>();
        for (int i = 0; i < size(); i++) {
            T iterationObject = (T) insideStorage[i];
            if (iterationObject.equals(name)) {
                outputArray.add(iterationObject);
            }
        }
        if (outputArray.size() != 0) {
            return outputArray;
        } else {
            return null;
        }
    }
}
