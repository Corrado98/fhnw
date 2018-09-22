package ch.fhnw.algd1.converters.binary;


class BinConverter {
    static String toBinaryString(int x) {
        StringBuilder binaryStringBuilder = new StringBuilder();
        if (x < 0) {
            negative(x, binaryStringBuilder);
        } else {
            positive(x, binaryStringBuilder, false);
        }
        return binaryStringBuilder.reverse().toString();
    }

    private static void fillRemainingBits(StringBuilder binaryStringBuilder, boolean isPositiveNumber) {
        int numberOfZerosToInsert = 8 - binaryStringBuilder.length();
        if(!isPositiveNumber) {
            numberOfZerosToInsert--;
        }

        for (int i = 0; i < numberOfZerosToInsert; i++) {
            binaryStringBuilder.append(0);
        }

        if(!isPositiveNumber) {
            binaryStringBuilder.append(1); // MSB
        }
    }

    private static void negative(int x, StringBuilder binaryStringBuilder) {
        int positiveNumberToCalculate = x + 128;
        positive(positiveNumberToCalculate, binaryStringBuilder, true);
        fillRemainingBits(binaryStringBuilder, false);
    }

    private static void positive(int x, StringBuilder binaryStringBuilder, boolean calledFromNegative) {
        while (x != 0) {
            binaryStringBuilder.append(x % 2);
            x = x / 2;
        }

        if(!calledFromNegative) {
            fillRemainingBits(binaryStringBuilder, true);
        }
    }

    static int parseBinaryString(String text) {
        String[] binary = text.split("");
        int value = 0;
        if (binary[0].equals("1")) {
            value = (int) Math.pow(-2, binary.length - 1); //-2^7
        }

        for (int i = 1; i < binary.length; i++) {
            if (binary[i].equals("1")) {
                value += Math.pow(2, binary.length - 1 - i);
            }
        }

        return value;
    }
}