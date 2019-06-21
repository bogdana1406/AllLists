package map.hashmap;

import java.util.Objects;

//класс обертка для слова, который необходим для того, чтобы элементы wordMap (пара ключ, значение) можно было отсортировать по значению (частота с которой встречается слово)
//имплементирует Comparable<WordWrapper>, поскольку используется при сортировке
public class WordWrapper implements Comparable<WordWrapper>{
    private final String word;
    private final Integer count;

    public WordWrapper(String word, Integer count) {
        this.word = word;
        this.count = count;
    }

    public String getWord() {
        return word;
    }

    public Integer getCount() {
        return count;
    }

    //сравнивается по count (количество повторений слова в тексте)
    @Override
    public int compareTo(WordWrapper thatWord) {

        if (count < thatWord.getCount()) {
            return -1;
        }
        if (count > thatWord.getCount()) {
            return 1;
        }

        //если counter у слов равны (условие > и условие < не выполняются) вызываем метод compareTo у ключей (слов)
        return word.compareTo(thatWord.getWord());
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        WordWrapper that = (WordWrapper) o;
        return Objects.equals(word, that.word) &&
                Objects.equals(count, that.count);
    }

    @Override
    public int hashCode() {
        return Objects.hash(word, count);
    }

    @Override
    public String toString() {
        return word + " -> " + count;
    }
}
