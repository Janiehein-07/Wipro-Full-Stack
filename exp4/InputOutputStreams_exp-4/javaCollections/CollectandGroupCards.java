package javaCollections;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Scanner;
import java.util.TreeMap;

public class CollectandGroupCards {

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

        // Map to group cards based on their symbol
        Map<String, List<Card>> cardMap =
                new TreeMap<String, List<Card>>();

        System.out.println("Enter Number of Cards :");
        int numberOfCards = sc.nextInt();
        sc.nextLine();

        // Collect card details
        for (int i = 1; i <= numberOfCards; i++) {

            System.out.println("Enter Card " + i + ":");

            String symbol = sc.nextLine();

            int number = sc.nextInt();
            sc.nextLine();

            Card card = new Card(symbol, number);

            // If symbol is not already present, create a new list
            if (!cardMap.containsKey(symbol)) {
                cardMap.put(symbol, new ArrayList<Card>());
            }

            // Add card to the list for that symbol
            cardMap.get(symbol).add(card);
        }

        // Display distinct symbols
        System.out.println("Distinct Symbols are :");

        for (String symbol : cardMap.keySet()) {
            System.out.print(symbol + " ");
        }

        System.out.println();
        System.out.println();

        // Display cards grouped by symbol
        for (String symbol : cardMap.keySet()) {

            List<Card> cards = cardMap.get(symbol);

            System.out.println("Cards in " + symbol + " Symbol");

            int sum = 0;

            for (Card card : cards) {

                System.out.println(
                        card.symbol + " " + card.number
                );

                sum += card.number;
            }

            System.out.println("Number of cards : " + cards.size());
            System.out.println("Sum of Numbers : " + sum);
        }

        sc.close();
    }
}