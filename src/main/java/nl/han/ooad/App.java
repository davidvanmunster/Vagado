package nl.han.ooad;

public class App {

    public static void main(String[] args) {
        Player player = new Player();
        Game game = new Game(player);

        //toiletpapier
        game.selectQuiz(0);
        System.out.println(game.getCurrentQuestion().getQuestion());
        boolean checkedAnswer = game.answerQuestion(new Answer("toiletpapier"));
        game.printAnswerFeedback(checkedAnswer);
    }
}
