package nl.han.ooad;

import java.util.Collections;
import java.util.List;

public class MultipleChoiceQuestion extends Question {

    private Answer correctAnswer;
    private List<Answer> wrongAnswers;
    private List<Answer> allAnswers;

    public MultipleChoiceQuestion(String question, Answer correctAnswer, List<Answer> wrongAnswers) {
        this.question = question;
        this.correctAnswer = correctAnswer;
        this.allAnswers = wrongAnswers;
        this.allAnswers.add(correctAnswer);
        Collections.shuffle(allAnswers);
    }

    @Override
    public boolean checkAnswer(Answer inputAnswer) {
        return inputAnswer.getAnswer().equals(correctAnswer.getAnswer());
    }

    @Override
    public String getQuestion() {
        return this.question + "\n" + allAnswers.get(0).getAnswer() + "\n" + allAnswers.get(1).getAnswer() + "\n" + allAnswers.get(2).getAnswer() + "\n" + allAnswers.get(3).getAnswer();
    }
}
