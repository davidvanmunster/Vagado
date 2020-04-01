package nl.han.ooad;

import java.util.ArrayList;
import java.util.List;

public class Topic {

    private String name;
    private List<Quiz> quizzes = new ArrayList<>();

    public Topic(String name) {
        this.name = name;
    }

    public void addQuiz(Quiz quiz) {
        quizzes.add(quiz);
    }
}
