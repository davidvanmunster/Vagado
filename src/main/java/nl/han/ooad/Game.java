package nl.han.ooad;

import java.util.ArrayList;
import java.util.List;

public class Game {

    private Quiz currentQuiz;
    private List<Quiz> quizzes = new ArrayList<>();
    private Player player;
    private int currentQuestion;

    public Game(Player player) {
        this.player = player;


        quizzes.add(new Quiz(5, true));
        quizzes.get(0).addOpenQuestion(
                "Wat is het snelst verkocht product in winkels de laatste periode?", new ArrayList<>(List.of(
                        new Answer("toiletpapier"),
                        new Answer("toilet papier")
                )));

        quizzes.get(0).addMultipleChoiceQuestion(
                "1 + 1 = ?", new Answer("2"), new ArrayList<>(List.of(
                        new Answer("3"),
                        new Answer("4"),
                        new Answer("5")
                )));
    }

    public void selectQuiz(int quizId) {
        currentQuiz = quizzes.get(quizId);
        currentQuestion = 0;
    }

    public void answerQuestion(Answer inputAnswer, int currentQuestion) {
//        currentQuiz
    }
}
