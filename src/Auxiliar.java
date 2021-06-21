class Auxiliar {
    static final String cardsDeck[] = { "A", "2", "3", "4", "5", "6", "7", "8", "9", "10", "J", "Q", "K" };

    static String[] populateCardsArray(String[] cards) {
        for (int i=0;i<cards.length;i++) {
            int randomIndex = (int) (Math.random() * 13) + 1;
            String cardValue = cardsDeck[randomIndex - 1];
            cards[i] = cardValue;
        }
        return cards;
    }

    static int countCardsValue(String[] cards) {
        int totalCardsValue = 0;
        cards = convertCardsValues(cards);
        for (int i=0;i<cards.length;i++) {
            totalCardsValue += Integer.parseInt(cards[i]);
        }
        return totalCardsValue;
    }

    static String[] convertCardsValues(String[] playerCards) {
        for (int i=0;i<playerCards.length;i++) {
            if (playerCards[i].equals("J") || playerCards[i].equals("Q") || playerCards[i].equals("K") ) {
                playerCards[i] = "10";
            } else if (playerCards[i].equals("A")) {
                playerCards[i] = "11";
                int totalValue = countCardsValue(playerCards);
                if (totalValue > 21) {
                    playerCards[i] = "1";
                }
            }
        }
        return playerCards;
    }

    static void dump(String[] playerCards) {
        for (int i=0;i<playerCards.length;i++) {
            System.out.println(playerCards[i]);
        }
        int score = countCardsValue(playerCards);
        System.out.print("Score:");
        System.out.println(score);
    }

    static String[] hitTable(String[] playerCards) {
        int lastIndex = playerCards.length + 1;
        String newCards[] = new String[lastIndex];
        for (int i=0;i<playerCards.length;i++) {
            newCards[i] = playerCards[i];
        }
        int randomIndex = (int) (Math.random() * 13) + 1;
        newCards[lastIndex - 1] = cardsDeck[randomIndex - 1];
        return newCards;
    }

    static String[] init() {
        String playerCards[] = new String[2];
        playerCards = populateCardsArray(playerCards);

        return playerCards;
    }
}
