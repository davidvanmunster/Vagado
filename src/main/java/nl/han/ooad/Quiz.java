package nl.han.ooad;

import org.apache.commons.lang3.time.StopWatch;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.TimeUnit;

public class Quiz {

    private String name;
    private StopWatch stopWatch = new StopWatch();
    private ScoreStrategy scoreStrategy = new DefaultScoreStrategy();
    private List<Question> questions = new ArrayList<>();
    private List<Boolean> playerAnswers = new ArrayList<>();
    private int highScore;
    private int price;
    private boolean unlocked;

    public Quiz(String name, int price, boolean unlocked) {
        this.name = name;
        this.price = price;
        this.unlocked = unlocked;
    }

    public String getName() {
        return name;
    }

    public boolean answerQuestion(Answer answer, int currentQuestion) {
        boolean checkedAnswer = questions.get(currentQuestion).checkAnswer(answer);
        playerAnswers.add(checkedAnswer);
        return checkedAnswer;
    }

    public Results getResults() {
        stopWatch.stop();
        Results results = new Results();
        playerAnswers.stream().filter(answer -> answer).mapToInt(answer -> scoreStrategy.getScoreCorrect()).forEach(results::addTotalScore);
        if (playerAnswers.stream().allMatch(answer -> answer)) {
            results.addCoins(2);
            results.addCoins(scoreStrategy.getScoreAllCorrect());
        }
        if (results.getTotalScore() > highScore) {
            results.setHighScoreBeaten(true);
            highScore = results.getTotalScore();
        }
        int bonusScore = scoreStrategy.calculateScoreSpeed((int) stopWatch.getTime(TimeUnit.SECONDS));
        stopWatch.reset();
        results.addTotalScore(bonusScore);
        results.setBonusScore(bonusScore);
        return results;
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

    public void startStopWatch() {
        stopWatch.start();
    }
}
