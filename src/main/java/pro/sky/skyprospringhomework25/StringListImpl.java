package pro.sky.skyprospringhomework25;

import java.util.Arrays;
import java.util.Objects;

public class StringListImpl implements StringList {

    public static final int INITIAL_SIZE = 15;

    private final String[] date;
    private int capacity;

    public StringListImpl() {
        date = new String[INITIAL_SIZE];
        capacity = 0;
    }

    public StringListImpl(int n) {
        if (n <= 0) {
            throw new IllegalArgumentException("Размер списка должен быть положительныЙ!");
        }
        date = new String[n];
        capacity = 0;
    }

    @Override
    public String add(String item) {
        return add(capacity, item);
    }

    @Override
    public String add(int index, String item) {
        if (capacity >= date.length) {
            throw new IllegalArgumentException("Список полон!");
        }
        if (Objects.isNull(item)) {
            throw new IllegalArgumentException("Нельзя добавлять null в список!");
        }
        if (index < 0) {
            throw new IllegalArgumentException("Индекс должен быть неотрицательный!");
        }
        if (index > capacity) {
            throw new IllegalArgumentException("Индекс: " + index + ", Размер: " + capacity);
        }
        System.arraycopy(date, index, date, index + 1, capacity - index);
        date[index] = item;
        capacity++;
        return item;
    }

    @Override
    public String set(int index, String item) {
        if (Objects.isNull(item)) {
            throw new IllegalArgumentException("Нельзя устанавливать null в список!");
        }
        if (index < 0) {
            throw new IllegalArgumentException("Индекс должен быть неотрицательный!");
        }
        if (index >= capacity) {
            throw new IllegalArgumentException("Индекс: " + index + ", Размер: " + capacity);
        }

        date[index] = item;
        return item;
    }

    @Override
    public String remove(String item) {
        int indexForRemoving = indexOf(item);
        if (indexForRemoving == -1) {
            throw new IllegalArgumentException("Элемент не найден!");
        }
        return remove(indexForRemoving);
    }

    @Override
    public String remove(int index) {
        if (index < 0) {
            throw new IllegalArgumentException("Индекс должен быть неотрицательный!");
        }
        if (index >= capacity) {
            throw new IllegalArgumentException("Индекс: " + index + ", Размер: " + capacity);
        }
        String item = date[index];
        System.arraycopy(date, index + 1, date, index, capacity - 1 - index);
        date[--capacity] = null;
        return item;
    }

    @Override
    public boolean contains(String item) {
        if (Objects.isNull(item)) {
            throw new IllegalArgumentException("Нельзя добавлять null в список!");
        }
        for (int i = 0; i < capacity; i++) {
            if (date[i].equals(item)) {
                return true;
            }
        }
        return false;
    }

    @Override
    public int indexOf(String item) {
        if (Objects.isNull(item)) {
            throw new IllegalArgumentException("Нельзя добвавлять null в список!");
        }
        int index = -1;
        for (int i = 0; i < capacity; i++) {
            if (date[i].equals(item)) {
                index = i;
                break;
            }
        }
        return index;
    }

    @Override
    public int lastIndexOf(String item) {
        if (Objects.isNull(item)) {
            throw new IllegalArgumentException("Нельзя добавлять null в список!");
        }
        int index = -1;
        for (int i = capacity - 1; i >= 0; i--) {
            if (date[i].equals(item)) {
                index = i;
                break;
            }
        }
        return index;
    }


    @Override
    public String get(int index) {
        if (index < 0) {
            throw new IllegalArgumentException("Индекс должен быть неотрицательный!");
        }
        if (index >= capacity) {
            throw new IllegalArgumentException("Индекс: " + index + ", Размер: " + capacity);
        }
        return date[index];
    }

    @Override
    public boolean equals(StringList otherList) {
        if (size() != otherList.size()) {
            return false;
        }
        for (int i = 0; i < capacity; i++) {
            if (!date[i].equals(otherList.get(i)))
                return false;
        }
        return false;
    }


    @Override
    public int size() {
        return capacity;
    }

    @Override
    public boolean isEmpty() {
        return size() == 0;
    }

    @Override
    public void clear() {
        for (int i = 0; i < capacity; i++) {
            date[i] = null;
        }
        capacity = 0;
    }

    @Override
    public String[] toArray() {
        String[] result = new String[capacity];
        System.arraycopy(date, 0, result, 0, capacity);
        return result;
    }
}




