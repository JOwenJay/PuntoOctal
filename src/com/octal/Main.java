package com.octal;
import java.util.Scanner;

public class Main {
    private static final String[] OCTAL_TO_BINARY = {
        "000", "001", "010", "011", "100", "101", "110", "111"
    };

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        StringBuilder octalNumberBuilder = new StringBuilder();

        while (true) {
            System.out.print("Enter an octal number (0-7) or 'f' to finish and complete the conversion: ");
            String input = scanner.nextLine();

            if (input.equalsIgnoreCase("f")) {
                break;
            } else if (isValidOctal(input)) {
                octalNumberBuilder.append(input);
            } else {
                System.out.println("Invalid input. Please try again.");
            }
        }

        String octalNumber = octalNumberBuilder.toString();

        if (!octalNumber.isEmpty()) {
            String binaryNumber = convertToBinary(octalNumber);
            String spacedBinaryNumber = addSpacing(binaryNumber, 3);
            System.out.println("Corresponding binary numbers: " + spacedBinaryNumber);
        } else {
            System.out.println("No octal numbers were entered.");
        }

        scanner.close();
    }

    public static boolean isValidOctal(String input) {
        return input.matches("[0-7]+");
    }

    public static String convertToBinary(String octalNumber) {
        StringBuilder binaryNumber = new StringBuilder();

        for (int i = 0; i < octalNumber.length(); i++) {
            int digit = Character.getNumericValue(octalNumber.charAt(i));
            binaryNumber.append(OCTAL_TO_BINARY[digit]);
        }

        return binaryNumber.toString();
    }

    public static String addSpacing(String binaryNumber, int spacing) {
        StringBuilder spacedBinaryNumber = new StringBuilder();

        for (int i = 0; i < binaryNumber.length(); i++) {
            if (i > 0 && i % spacing == 0) {
                spacedBinaryNumber.append(" ");
            }
            spacedBinaryNumber.append(binaryNumber.charAt(i));
        }

        return spacedBinaryNumber.toString();
    }
}
