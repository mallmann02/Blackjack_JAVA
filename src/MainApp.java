import java.util.Scanner;

/**
 * A classe BlackJack permite jogar uma partida
 * de blackjack ou 21 entre um jogador e a máquina.
 *
 * @author Leonardo Mallmann (leomallmann020302@gmail.com)
 * @version 1.0 (2021-06-14)
 */

public class MainApp {
    public static void main(String[] Args) {
        Scanner keyboard = new Scanner(System.in);
        Auxiliar aux = new Auxiliar();
        System.out.println("Lets start the game");
        String playerCards[] = aux.init();
        aux.dump(playerCards);
        while (aux.countCardsValue(playerCards) < 21) {
            System.out.print("Do you want to hit or stand: (type 'hit' or 'stand') ");
            String playerAnswer = keyboard.next();
            while (!((playerAnswer.equals("hit")) || (playerAnswer.equals("stand")))) {
                System.out.print("Please type a valid game move: ");
                playerAnswer = keyboard.next();
            }
            if (playerAnswer.equals("hit")) {
                playerCards = aux.hitTable(playerCards);
                System.out.println("New Cards");
                aux.dump(playerCards);
            }

            if (playerAnswer.equals("stand")) {
                break;
            }
        }

        if (aux.countCardsValue(playerCards) > 21) {
            System.out.println("Você não conseguiu manter sua pontuação abaixo de 21 pontos");
            return;
        }

        System.out.println("Dealer turn");
        String dealerCards[] = aux.init();
        while (aux.countCardsValue(playerCards) > aux.countCardsValue(dealerCards)){
            aux.dump(dealerCards);
            System.out.println("dealer plays");
            dealerCards = aux.hitTable(dealerCards);
        }
        if (aux.countCardsValue(dealerCards) > 21) {
            aux.dump(dealerCards);
            System.out.println("The dealer lost ");
        }
        aux.dump(dealerCards);

    }
}
