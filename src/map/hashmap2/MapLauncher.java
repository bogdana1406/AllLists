package map.hashmap2;

import java.util.*;


public class MapLauncher {
    public static void main(String[] args) {
        Map<String, Integer> wordMap = new HashMap<>();
        System.out.println("Please enter some text");
        Scanner scanner = new Scanner(System.in);
        String string = scanner.nextLine();

        String[] tokens = string.split(" ");

        for (String token : tokens) {
            String word = token.toLowerCase();

            Integer count = wordMap.get(word);

            if (count == null) {
                wordMap.put(word, 1);
            } else {
                wordMap.put(word, count + 1);
            }

        }

        Set<WordWrapper> wordWrappers = convertToSet(wordMap);

        wordWrappers.add(new WordWrapper("trula", 8));
//        printSet(wordWrappers);
//        printMap(wordMap);
    }

    private static void printSet(NavigableSet<WordWrapper> wordWrappers) {
        for (WordWrapper wordWrapper: wordWrappers) {
            System.out.println(wordWrapper);
        }

    }

    private static Set<WordWrapper> convertToSet(Map<String, Integer> wordMap) {

        wordMap.replace("the", 5, 9);
        NavigableSet<WordWrapper> wordSet = new TreeSet<>();
        for (Map.Entry<String, Integer> e : wordMap.entrySet()) {

            wordSet.add(new WordWrapper(e.getKey(), e.getValue()));
        }

        return Collections.unmodifiableSet(wordSet);
//        return new TreeSet<>(wordSet);

    }

    private static void printMap(Map<String, Integer> wordMap) {

        Map<String, Integer> wordTreeMap = new TreeMap<>(wordMap);
        Set<String> keys = wordTreeMap.keySet();
        for (String key : keys) {

            System.out.printf("%-20s%-20s\n", key, wordTreeMap.get(key));

        }
    }
}
