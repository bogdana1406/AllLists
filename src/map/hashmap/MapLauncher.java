package map.hashmap;

import java.util.*;

public class MapLauncher {
    public static void main(String[] args) {

        //создали пустой wordMap (тип HashMap)
        Map<String, Integer> wordMap = new HashMap<>();
        System.out.println("please enter some text\n");
        Scanner scanner = new Scanner(System.in);
        String string = scanner.nextLine();
        //преобразовали в массив слов
        String[] tokens = string.split(" ");

        for (String token: tokens) {
            //привели слова к нижнему регистру
            String word = token.toLowerCase();
            //counter - второе значение в map(key, value). т.е key - это value (является целым числом)
            Integer counter = wordMap.get(word);
            //когда проходится по массиву 1-й раз слово еще не записано и не существует его counter
            if (counter == null) {
                wordMap.put(word, 1);
                //если такое слово уже есть ему соответствует определенный counter. пара перезаписывается - слово тоже, counter увеличивается на единицу
            } else {
                wordMap.put(word, counter +1);
            }
        }

        //метод convertToSet - для преобразования wordMap в тип, позволяющий использовать сортировку по значениям (класс wordWrapper)
        NavigableSet<WordWrapper> wordWrappers = convertToSet(wordMap);

        printSet(wordWrappers);
//        printMap(wordMap);
    }

    private static void printSet(NavigableSet<WordWrapper> wordWrappers) {

        for (WordWrapper wordWrapper: wordWrappers) {
            System.out.println(wordWrapper);
        }
    }

    private static NavigableSet<WordWrapper> convertToSet(Map<String, Integer> wordMap) {

        wordMap.remove("to");
        wordMap.replace("a", 8);
        //создаем wordSet типа NavigableSet<WordWrapper> (параметризирован классом WordWrapper)
        NavigableSet<WordWrapper> wordSet = new TreeSet<>();

        //wordMap.entrySet() - получаем Set всех пар (key, value) -  wordMap.entrySet(). e - каждая отдельная пара. ее тип Map.Entry<String, Integer>.
        for (Map.Entry<String, Integer> e: wordMap.entrySet()) {
            //заполняем wordSet парами e (e.getKey(), e.getValue())
            wordSet.add(new WordWrapper(e.getKey(), e.getValue()));
        }

        return new TreeSet<>(wordSet);
    }

    private static void printMap(Map<String, Integer> wordMap) {

        //создаем wordTreeMap типа TreeMap<String, Integer> передаем в него wordMap (фактически преобразовываем wordMap из типа Map в TreeMap, чтобы можно было его отсортировать)
        TreeMap<String, Integer> wordTreeMap = new TreeMap<>(wordMap);

        //keys - массив ключей из wordMap (ключами являются слова из которых состоял текст) (wordMap заменили на wordTreeMap)
        Set<String> keys = wordTreeMap.keySet();
        for (String key: keys) {
            //печатаем пару ключ - значение по данному ключу. key - строка-ключ, wordMap.get(key) - достаем значение из wordMap по ключу key (цифра, которая соответствует слову)
            System.out.printf("%-20s%-20s\n", key, wordTreeMap.get(key));
        }

    }

}
