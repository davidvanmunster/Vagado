package nl.han.ooad;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

class MultipleChoiceQuestionTest {

    private MultipleChoiceQuestion sut;

    @BeforeEach
    void setUp() {
        sut = new MultipleChoiceQuestion("Test question?", new Answer("yes"), new ArrayList<>(List.of(
                new Answer("no"),
                new Answer("maybe"),
                new Answer("yaes")
        )));
    }

    @Test
    void checkAnswerReturnsTrueIfCorrect() {
        Answer testAnswer = new Answer("yes");
        assertEquals(true, sut.checkAnswer(testAnswer));
    }

    @Test
    void checkAnswerReturnsFalseIfIncorrect() {
        Answer testAnswer = new Answer("maybe");
        assertEquals(false, sut.checkAnswer(testAnswer));
    }
}