package nl.han.ooad;

import java.util.Scanner;

public class App {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Player player = new Player();
        Game game = new Game(player);

        //toiletpapier
        game.selectQuiz(0);
        for (int i = 0; i <= game.getCurrentQuiz().getQuestionsCount(); i++) {
            System.out.println(game.getCurrentQuestion().getQuestion());
            String answer = scanner.nextLine();
            game.printAnswerFeedback(game.answerQuestion(new Answer(answer)));
        }

    }
}
