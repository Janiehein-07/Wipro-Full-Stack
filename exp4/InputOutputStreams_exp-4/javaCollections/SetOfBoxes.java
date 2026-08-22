package javaCollections;

import java.util.Scanner;
import java.util.Set;
import java.util.TreeSet;

public class SetOfBoxes {

    static class Box {

        Double length;
        Double width;
        Double height;

        public Box(Double length, Double width, Double height) {
            this.length = length;
            this.width = width;
            this.height = height;
        }

        // Calculate volume
        public double getVolume() {
            return length * width * height;
        }

        // Two boxes are equal when their volumes are equal
        @Override
        public boolean equals(Object obj) {

            if (this == obj) {
                return true;
            }

            if (obj == null || getClass() != obj.getClass()) {
                return false;
            }

            Box other = (Box) obj;

            return Double.compare(this.getVolume(), other.getVolume()) == 0;
        }

        // hashCode based on volume
        @Override
        public int hashCode() {
            return Double.valueOf(getVolume()).hashCode();
        }
    }

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        // TreeSet stores only unique volumes and sorts them by volume
        Set<Box> boxes = new TreeSet<Box>(
                (box1, box2) ->
                        Double.compare(box1.getVolume(), box2.getVolume())
        );

        System.out.println("Enter the number of Box");
        int numberOfBoxes = sc.nextInt();

        for (int i = 1; i <= numberOfBoxes; i++) {

            System.out.println("Enter the Box " + i + " details");

            System.out.println("Enter Length");
            Double length = sc.nextDouble();

            System.out.println("Enter Width");
            Double width = sc.nextDouble();

            System.out.println("Enter Height");
            Double height = sc.nextDouble();

            Box box = new Box(length, width, height);

            boxes.add(box);
        }

        System.out.println("Unique Boxes in the Set are");

        for (Box box : boxes) {

            System.out.printf(
                    "Length =%.1f Width =%.1f Height =%.1f Volume =%.2f%n",
                    box.length,
                    box.width,
                    box.height,
                    box.getVolume()
            );
        }

        sc.close();
    }
}