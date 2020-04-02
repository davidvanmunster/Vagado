package nl.han.ooad;

import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class MultipleChoiceQuestion extends Question {

    private Answer correctAnswer;
    private List<Answer> allAnswers;
    private Map<Character, String> letterAnswerMap = new HashMap<>();

    public MultipleChoiceQuestion(String question, Answer correctAnswer, List<Answer> wrongAnswers) {
        this.question = question;
        this.correctAnswer = correctAnswer;
        this.allAnswers = wrongAnswers;
        this.allAnswers.add(correctAnswer);
        Collections.shuffle(allAnswers);
        letterAnswerMap.put('A', allAnswers.get(0).getAnswer());
        letterAnswerMap.put('B', allAnswers.get(1).getAnswer());
        letterAnswerMap.put('C', allAnswers.get(2).getAnswer());
        letterAnswerMap.put('D', allAnswers.get(3).getAnswer());
    }

    @Override
    public boolean checkAnswer(Answer inputAnswer) {
        return correctAnswer.getAnswer().equals(letterAnswerMap.get(inputAnswer.getAnswer().toUpperCase().charAt(0))) || correctAnswer.getAnswer().equals(inputAnswer.getAnswer());
    }

    @Override
    public String getQuestion() {
        return this.question +
                "\nA: " + letterAnswerMap.get('A') +
                "\nB: " + letterAnswerMap.get('B') +
                "\nC: " + letterAnswerMap.get('C') +
                "\nD: " + letterAnswerMap.get('D');
    }
}
