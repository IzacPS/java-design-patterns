package me.izac.pattern.behavioral.observer;

public interface Observer {
    void update();
    void setSubject(Subject sub);
}
