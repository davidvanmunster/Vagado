package nl.han.ooad;

import java.util.ArrayList;
import java.util.List;

public class Quiz {

    private List<Question> questions = new ArrayList<>();
    private List<Boolean> playerAnswers = new ArrayList<>();
    private int highscore;
    private int price;
    private boolean unlocked;

    public Quiz(int price, boolean unlocked) {
        this.price = price;
        this.unlocked = unlocked;
    }

    public boolean answerQuestion(Answer answer, int currentQuestion) {
        boolean checkedAnswer = questions.get(currentQuestion).checkAnswer(answer);
        playerAnswers.add(checkedAnswer);
        return checkedAnswer;
    }

    public void addOpenQuestion(String question, List<Answer> correctAnswers) {
        questions.add(new OpenQuestion(question, correctAnswers));
    }

    public void addMultipleChoiceQuestion(String question, Answer correctAnswer, List<Answer> wrongAnswers) {
        questions.add(new MultipleChoiceQuestion(question, correctAnswer, wrongAnswers));
    }

    public int getQuestionsCount() {
        return questions.size();
    }

    public Question getQuestion(int index) {
        return questions.get(index);
    }
}
