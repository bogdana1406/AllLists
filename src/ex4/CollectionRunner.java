package ex4;

import java.util.*;

public class CollectionRunner {
    public static void main(String[] args) {

        List<Card> decOfCards = new ArrayList<>();
        for (Card.Face face: Card.Face.values()) {
            for (Card.Suit suit: Card.Suit.values()) {
                decOfCards.add(new Card(suit, face));
            }
        }

        System.out.println("Original deck of cards\n");

//        printOutput((List<Card>) decOfCards);

        System.out.println("\n\nCards after shuffle\n");

        Collections.shuffle(decOfCards);
        Collections.sort(decOfCards);

        Card card = new Card(Card.Suit.SPADES, Card.Face.Queen);
        int i = Collections.binarySearch(decOfCards, card);

//        if (i >= 0) {
//            System.out.println("Card was found at position " +i);
//        } else {
//            System.out.println("Card was not found");
//        }

        //создали массив для заполненияю инициализировали его decOfCards, чтобы был изначальный размер
        List<Card> cardList = new ArrayList<>(decOfCards);
        printOutput(cardList);

        System.out.println("+++++++++++++++++++++++++++++++");
        //заполняем созданный массив. фактически заменяем старые элементы на новые.
        Collections.fill(cardList, card);
        printOutput(cardList);

        //добавили 3 карты в конец массива
        Collections.addAll(cardList, card, card, card);
        System.out.println("+++++++++++++++++++++++++++++++");
        Collections.copy(cardList, decOfCards);

        int frequency = Collections.frequency(cardList, card);
        System.out.println("frequency of " + card + " is " + frequency);

        System.out.println(Collections.min(cardList));
        System.out.println(Collections.max(cardList));
//        printOutput(cardList);

//        printOutput(decOfCards);

//        System.out.println("\n\nDeck of cards after sorting\n");
//        Collections.sort(decOfCards, new CardComparator());
//
//        printOutput(decOfCards);

    }

    private static void printOutput(List<Card> decOfCards) {
        for (int i = 0; i < decOfCards.size(); i++) {
            System.out.printf("%-30s %s", decOfCards.get(i), (i + 1) % 4 == 0 ? "\n" : " ");
        }
    }

}
