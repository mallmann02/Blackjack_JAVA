import java.util.Scanner;

/**
 * A classe BlackJack permite jogar uma partida
 * de blackjack ou 21 entre um jogador e a máquina.
 *
 * @author Leonardo Mallmann (leomallmann020302@gmail.com)
 * @version 1.0 (2021-06-14)
 */

public class MainApp {
    static final String cardsDeck[] = { "A", "2", "3", "4", "5", "6", "7", "8", "9", "10", "J", "Q", "K" };

    public static String[] populateCardsArray(String[] cards) {
        for (int i=0;i<cards.length;i++) {
            int randomIndex = (int) (Math.random() * 13) + 1;
            String cardValue = cardsDeck[randomIndex - 1];
            cards[i] = cardValue;
        }
        return cards;
    }

    public static int countCardsValue(String[] cards) {
        int totalCardsValue = 0;
        cards = convertCardsValues(cards);
        for (int i=0;i<cards.length;i++) {
            totalCardsValue += Integer.parseInt(cards[i]);
        }
        return totalCardsValue;
    }

    public static String[] convertCardsValues(String[] playerCards) {
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

    public static void dump(String[] playerCards) {
        for (int i=0;i<playerCards.length;i++) {
            System.out.println(playerCards[i]);
        }
        int score = countCardsValue(playerCards);
        System.out.print("Score:");
        System.out.println(score);
    }

    public static String[] hitTable(String[] playerCards) {
        int lastIndex = playerCards.length + 1;
        String newCards[] = new String[lastIndex];
        for (int i=0;i<playerCards.length;i++) {
            newCards[i] = playerCards[i];
        }
        int randomIndex = (int) (Math.random() * 13) + 1;
        newCards[lastIndex - 1] = cardsDeck[randomIndex - 1];
        return newCards;
    }

    public static String[] init() {
        String playerCards[] = new String[2];
        playerCards = populateCardsArray(playerCards);

        return playerCards;
    }

    public static void main(String[] Args) {
        // Distribui as cartas para o jogador
        Scanner keyboard = new Scanner(System.in);
        Auxiliar aux = new Auxiliar();
        System.out.println("Lets start the game");
        String playerCards[] = aux.init();
        dump(playerCards);
        while (countCardsValue(playerCards) < 21) {
            System.out.print("Do you want to hit or stand: (type 'hit' or 'stand') ");
            String playerAnswer = keyboard.next();
            while (!((playerAnswer.equals("hit")) || (playerAnswer.equals("stand")))) {
                System.out.print("Please type a valid game move: ");
                playerAnswer = keyboard.next();
            }
            if (playerAnswer.equals("hit")) {
                playerCards = hitTable(playerCards);
                System.out.println("New Cards");
                dump(playerCards);
            }

            if (playerAnswer.equals("stand")) {
                break;
            }
        }

        if (countCardsValue(playerCards) > 21) {
            System.out.println("Você não conseguiu manter sua pontuação abaixo de 21 pontos");
            return;
        }

        System.out.println("Dealer turn");
        String dealerCards[] = init();
        while (countCardsValue(playerCards) > countCardsValue(dealerCards)){
            dump(dealerCards);
            System.out.println("dealer plays");
            dealerCards = hitTable(dealerCards);
        }
        if (countCardsValue(dealerCards) > 21) {
            dump(dealerCards);
            System.out.println("The dealer lost ");
        }
        dump(dealerCards);

    }
}
