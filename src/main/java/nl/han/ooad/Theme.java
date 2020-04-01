package nl.han.ooad;

import java.util.ArrayList;
import java.util.List;

public class Theme {

    private String name;
    private List<Topic> topics = new ArrayList<>();

    public Theme(String name) {
        this.name = name;
    }

    public void addTopic(Topic topic) {
        topics.add(topic);
    }
}
