package Bin2Dec;

/**
 * Purpose of this practice class is to implement binary to decimal converter.
 */
public class Binary2Decimal {

    private static final Integer BASE = 2;

    public Integer getDecimalFromBinary(String binary) {
        validateInput(binary);

        int result = 0, power = 0;
        for (int positionFromRight = binary.length() - 1; positionFromRight >= 0; positionFromRight--, power++) {
            if (binary.charAt(positionFromRight) == '1') {
                result += (int) Math.pow(BASE, power);
            }
        }

        return result;
    }

    private void validateInput(String input) {
        if (input.length() > 8) {
            throw new IllegalArgumentException("Input may be only 8 chars long.");
        }
        for (char number : input.toCharArray()) {
            if (number != '1' && number != '0') {
                throw new IllegalArgumentException("Input may only contain 0's and 1's.");
            }
        }
    }
}