package ch.fhnw.algd1.converters.binary;


class BinConverter {
    static String toBinaryString(int x) {
        StringBuilder binaryStringBuilder = new StringBuilder();
        if (x < 0) {
            negative(x, binaryStringBuilder);
        } else {
            positive(x, binaryStringBuilder);

            int numberOfZerosToInsert = 8 - binaryStringBuilder.length();
            for (int i = 0; i < numberOfZerosToInsert; i++) {
                binaryStringBuilder.append(0);
            }
        }
        return binaryStringBuilder.reverse().toString();
    }

    private static void negative(int x, StringBuilder binaryStringBuilder) {
        int positiveNumberToCalculate = x + 128;
        positive(positiveNumberToCalculate, binaryStringBuilder);

        int numberOfZerosToInsert = 7 - binaryStringBuilder.length();
        for (int i = 0; i < numberOfZerosToInsert; i++) {
            binaryStringBuilder.append(0);
        }
        binaryStringBuilder.append(1);
    }

    private static void positive(int x, StringBuilder binaryStringBuilder) {
        while (x != 0) {
            binaryStringBuilder.append(x % 2);
            x = x / 2;
        }
    }

    static int parseBinaryString(String text) {
        // TODO: expect text to contain 8 binary digits, parse to int value in 2-complement

        String[] binary = text.split("");
        int value = 0;
        if (binary[0].equals("1")) {
            value = (int) Math.pow(-2, binary.length - 1); //-2^7
            System.out.println("Value is " + value);
        }

        for (int i = 1; i < binary.length; i++) {
            if (binary[i].equals("1")) {
                value += Math.pow(2, binary.length - 1 - i);
            }
        }

        return value;
    }
}