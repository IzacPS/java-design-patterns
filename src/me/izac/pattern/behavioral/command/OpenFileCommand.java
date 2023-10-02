package me.izac.pattern.behavioral.command;

public class OpenFileCommand implements Command{
    private FileSystemReceiver fileSystem;

    OpenFileCommand(FileSystemReceiver fileSystem){
        this.fileSystem = fileSystem;
    }
    @Override
    public void execute() {
        this.fileSystem.openFile();
    }
}
