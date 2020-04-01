package nl.han.ooad;

import java.util.List;

public class OpenQuestion extends Question {

    private List<Answer> correctAnswers;

    public OpenQuestion(String question, List<Answer> correctAnswers) {
        this.question = question;
        this.correctAnswers = correctAnswers;
    }

    @Override
    public boolean checkAnswer(Answer inputAnswer) {
        for (Answer correctAnswer : correctAnswers) {
            if (inputAnswer.getAnswer() == correctAnswer.getAnswer()) {
                return true;
            }
        }
        return false;
    }
}
