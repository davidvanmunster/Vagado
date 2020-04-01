package nl.han.ooad;

import java.util.ArrayList;
import java.util.List;

public class Game {

    private Quiz currentQuiz;
    private List<Quiz> quizzes = new ArrayList<>();
    private Player player;
    private int currentQuestionIndex = 0;

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
        currentQuestionIndex = 0;
    }

    public boolean answerQuestion(Answer inputAnswer) {
        boolean checkedAnswer = currentQuiz.answerQuestion(inputAnswer, currentQuestionIndex);
        currentQuestionIndex++;
        return checkedAnswer;
    }

    public void printAnswerFeedback(boolean checkedAnswer) {
        if (checkedAnswer) {
            System.out.println("Correct answer!");
        } else {
            System.out.println("Incorrect answer!");
        }
    }

    public Question getCurrentQuestion() {
        return currentQuiz.getQuestion(currentQuestionIndex);
    }
}
