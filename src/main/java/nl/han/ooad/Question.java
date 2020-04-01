package nl.han.ooad;

public abstract class Question {

    protected String question;

    public abstract boolean checkAnswer(Answer inputAnswer);

    public abstract String getQuestion();
}
