package nl.han.ooad;

import java.util.List;

public class MultipleChoiceQuestion extends Question {

    private Answer correctAnswer;
    private List<Answer> wrongAnswers;

    public MultipleChoiceQuestion(String question, Answer correctAnswer, List<Answer> wrongAnswers) {
        this.question = question;
        this.correctAnswer = correctAnswer;
        this.wrongAnswers = wrongAnswers;
    }

    @Override
    public boolean checkAnswer(Answer inputAnswer) {
        return false;
    }
}
