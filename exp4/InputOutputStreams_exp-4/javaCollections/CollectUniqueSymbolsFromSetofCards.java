package javaCollections;

import java.util.Comparator;
import java.util.Scanner;
import java.util.Set;
import java.util.TreeSet;

public class CollectUniqueSymbolsFromSetofCards {

    // Card class
    static class Card {

        String symbol;
        int number;

        public Card(String symbol, int number) {
            this.symbol = symbol;
            this.number = number;
        }
    }

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        // Set to store cards based on unique symbols
        Set<Card> cards = new TreeSet<Card>(
                new Comparator<Card>() {

                    @Override
                    public int compare(Card c1, Card c2) {
                        return c1.symbol.compareTo(c2.symbol);
                    }
                }
        );

        // Collect 8 cards
        for (int i = 0; i < 8; i++) {

            System.out.println("Enter a card :");

            System.out.println();
            String symbol = sc.nextLine();

            int number = Integer.parseInt(sc.nextLine());

            Card card = new Card(symbol, number);

            cards.add(card);
        }

        System.out.println(
                cards.size() + " symbols gathered in 8 cards."
        );

        System.out.println("Cards in Set are :");

        for (Card card : cards) {
            System.out.println(card.symbol + " " + card.number);
        }

        sc.close();
    }
}