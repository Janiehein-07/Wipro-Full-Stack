package javaCollections;

import java.util.ArrayList;

public class StringOperationsWithArrayList {

    public static ArrayList<String> performOperations(String S1, String S2) {

        ArrayList<String> result = new ArrayList<String>();

        // Operation 1:
        // Replace characters at alternate indexes of S1 with S2
        StringBuilder operation1 = new StringBuilder(S1);

        int index = 0;

        while (index < operation1.length()) {

            operation1.replace(
                    index,
                    index + 1,
                    S2
            );

            index += S2.length() + 1;
        }

        result.add(operation1.toString());

        // Operation 2:
        // If S2 occurs more than once in S1,
        // replace the last occurrence with reverse of S2.
        int lastIndex = S1.lastIndexOf(S2);

        int firstIndex = S1.indexOf(S2);

        String operation2 = S1;

        if (firstIndex != lastIndex && lastIndex != -1) {

            String reversedS2 =
                    new StringBuilder(S2).reverse().toString();

            operation2 =
                    S1.substring(0, lastIndex)
                    + reversedS2
                    + S1.substring(lastIndex + S2.length());
        }

        result.add(operation2);

        // Operation 3:
        // If S2 occurs more than once in S1,
        // delete the first occurrence.
        String operation3 = S1;

        if (firstIndex != lastIndex && firstIndex != -1) {

            operation3 =
                    S1.substring(0, firstIndex)
                    + S1.substring(firstIndex + S2.length());
        }

        result.add(operation3);

        // Operation 4:
        // Divide S2 into two halves and add
        // first half to beginning and second half to end.
        int mid = (S2.length() + 1) / 2;

        String firstHalf = S2.substring(0, mid);
        String secondHalf = S2.substring(mid);

        String operation4 =
                firstHalf + S1 + secondHalf;

        result.add(operation4);

        // Operation 5:
        // Replace all characters of S1 that occur in S2 with '*'.
        StringBuilder operation5 = new StringBuilder();

        for (int i = 0; i < S1.length(); i++) {

            char currentCharacter = S1.charAt(i);

            if (S2.indexOf(currentCharacter) != -1) {
                operation5.append('*');
            } else {
                operation5.append(currentCharacter);
            }
        }

        result.add(operation5.toString());

        return result;
    }

    public static void main(String[] args) {

        String S1 = "JAVAJAVA";
        String S2 = "VA";

        ArrayList<String> output =
                performOperations(S1, S2);

        System.out.println(output);
    }
}