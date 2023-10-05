package me.izac.pattern.behavioral.command;

public class ReadFileCommand implements Command{
    private FileSystemReceiver fileSystemReceiver;

    public ReadFileCommand(FileSystemReceiver fileSystemReceiver){
        this.fileSystemReceiver = fileSystemReceiver;
    }

    @Override
    public void execute() {
        this.fileSystemReceiver.readFile();
    }
}
