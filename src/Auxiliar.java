/**
 * A classe Auxiliar contém os métodos usados na classe MainApp
 * para tornam possível implementação completa da lógica do programa.
 *
 * @author Leonardo Mallmann (leomallmann020302@gmail.com)
 * @version 1.0 (2021-06-20)
 */
class Auxiliar {
    static final String cardsDeck[] = { "A", "2", "3", "4", "5", "6", "7", "8", "9", "10", "J", "Q", "K" };

    /**
     *
     * @param cards - Um array vazio a ser populado com cartas
     * @return - Um array com tamanho previamente definido preenchido
     * com números e/ou caractéres que representam as cartas de um baralho.
     */
    static String[] populateCardsArray(String[] cards) {
        for (int i=0;i<cards.length;i++) {
            int randomIndex = (int) (Math.random() * 13) + 1;
            String cardValue = cardsDeck[randomIndex - 1];
            cards[i] = cardValue;
        }
        return cards;
    }

    /**
     *
     * @param cards - Cartas a serem contabilizadas
     * @return - Um número inteiro que é a soma dos valores que são atribuídos
     * para cada carta presente na mão de quem joga.
     */
    static int countCardsValue(String[] cards) {
        int totalCardsValue = 0;
        cards = convertCardsValues(cards);
        for (int i=0;i<cards.length;i++) {
            totalCardsValue += Integer.parseInt(cards[i]);
        }
        return totalCardsValue;
    }

    /**
     *
     * @param playerCards - Um array com valores brutos das cartas
     * @return - Um array com valores de 0 a 10 que são originados a partir da
     * conversão das cartas distribuĩdas para o valor que as mesmas representam dentro das
     * regras do jogo.
     */
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

    /**
     * Método para exibir para quem joga as cartas que estão em sua mão e a
     * sua pontuação.
     *
     * @param playerCards - Um array representando as cartas do jogador
     */
    static void dump(String[] playerCards) {
        for (int i=0;i<playerCards.length;i++) {
            System.out.println(playerCards[i]);
        }
        int score = countCardsValue(playerCards);
        System.out.print("Score:");
        System.out.println(score);
    }

    /**
     *
     * @param playerCards - Um array representando as cartas do jogador
     * @return - Um array contendo todas as cartas atribuídas anteriormente
     * ao jogador, com o acréscimo de mais uma posição no array, representando
     * uma nova carta.
     */
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

    /**
     *
     * @return - Um array com duas posições populadas com duas cartas do baralho,
     * representado na constante "cardsDeck".
     */
    static String[] init() {
        String playerCards[] = new String[2];
        playerCards = populateCardsArray(playerCards);

        return playerCards;
    }
}
