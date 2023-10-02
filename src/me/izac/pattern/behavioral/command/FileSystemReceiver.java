package me.izac.pattern.behavioral.command;

public interface FileSystemReceiver {
    void openFile();
    void writeFile();
    void closeFile();
}
