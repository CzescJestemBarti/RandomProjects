package Bin2Dec;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotEquals;

public class Binary2DecimalTest {

    private Binary2Decimal binary2Decimal;

    @BeforeEach
    public void setUp() {
        binary2Decimal = new Binary2Decimal();
    }

    @Test
    public void testBinary2Decimal_correct() {
        // Given
        String binary = "0101010";
        Integer decimal = 42;

        // When
        Integer result = binary2Decimal.getDecimalFromBinary(binary);

        // Then
        assertEquals(result, decimal);
    }

    @Test
    public void testBinary2Decimal_incorrect() {
        // Given
        String binary = "0101010";
        Integer decimal = 17;

        // When
        Integer result = binary2Decimal.getDecimalFromBinary(binary);

        // Then
        assertNotEquals(result, decimal);
    }

    @Test
    public void testBinary2Decimal_invalidLength(){
        // Given
        String binary = "010101010"; //9 digits

        try {
            // When
            Integer result = binary2Decimal.getDecimalFromBinary(binary);
        } catch (IllegalArgumentException e) {
            // Then
            assertEquals("Input may be only 8 chars long.", e.getMessage());
        }
    }

    @Test
    public void testBinary2Decimal_invalidContent(){
        // Given
        String binary = "01010102"; //content different that 0's and 1's

        try {
            // When
            Integer result = binary2Decimal.getDecimalFromBinary(binary);
        } catch (IllegalArgumentException e) {
            // Then
            assertEquals("Input may only contain 0's and 1's.", e.getMessage());
        }
    }
}
