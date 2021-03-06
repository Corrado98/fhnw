package ch.fhnw.algd1.converters.binary;


class BinConverter {
    static String toBinaryString(int x) {
        StringBuilder binaryStringBuilder = new StringBuilder();
        if (x < 0) {
            negative(x, binaryStringBuilder);
        } else {
            positive(x, binaryStringBuilder);
        }
        return binaryStringBuilder.reverse()
            .toString();
    }

    private static void negative(int x, StringBuilder binaryStringBuilder) {
        positive(x + 256, binaryStringBuilder);
    }

    private static void positive(int x, StringBuilder binaryStringBuilder) {
        while (binaryStringBuilder.length() < 8) {
            binaryStringBuilder.append(x % 2);
            x = x / 2;
        }
    }

    static int parseBinaryString(String text) {
        int value = 0;
        for (int i = 0; i < text.length(); i++) {
            if (text.charAt(i) == '1') {
                value += 1 << (text.length() - 1- i);
            }
        }
        if(value > 127) {
            value -= 256;
        }

        return value;
    }
}