package me.izac.pattern.behavioral.observer;

public interface Subject {
    void register(Observer obs);
    void unregister(Observer obs);

    void notifyObservers();

    <T> T getUpdate(Observer obs);
}
