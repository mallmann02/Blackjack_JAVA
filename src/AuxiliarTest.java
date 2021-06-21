import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class AuxiliarTest {
    @Test
    public void initGame() {
        String playerCards[] = Auxiliar.init();
        assertEquals(2, playerCards.length);
    }

    @Test
    public void hitTable() {
        String playerCards[] = Auxiliar.init();
        String newCards[] = Auxiliar.hitTable(playerCards);
        assertEquals(3, newCards.length);
    }

    @Test
    public void convertCardsValues() {
        String cards[] = { "J", "K" };
        String convertedValues[] = Auxiliar.convertCardsValues(cards);
        String expectedConvertion[] = { "10", "10" };
        assertArrayEquals(expectedConvertion, convertedValues);
    }

    @Test
    public void convertAceCardsValues() {
        String cardsWithAce[] = {"5", "A"};
        String convertedValues[] = Auxiliar.convertCardsValues(cardsWithAce);
        String expectedConvertion[] = {"5", "11"};
        assertArrayEquals(expectedConvertion, convertedValues);

        String newCards[] = {"J", "K", "A"};
        convertedValues = Auxiliar.convertCardsValues(newCards);
        String newExpectedConvertion[] = {"10", "10", "1"};
        assertArrayEquals(newExpectedConvertion, convertedValues);
    }

    @Test
    public void countCardsValue() {
        String playerCards[] = {"5", "A", "5"};
        int cardsValue = Auxiliar.countCardsValue(playerCards);
        assertEquals(21, cardsValue);

        String newPlayerCards[] = {"J", "3", "A", "6"};
        cardsValue = Auxiliar.countCardsValue(newPlayerCards);
        assertEquals(20, cardsValue);
    }
}