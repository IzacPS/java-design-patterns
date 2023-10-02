package me.izac.pattern.behavioral.command;

public class CloseFileCommand implements Command {
    private FileSystemReceiver fileSystem;


    CloseFileCommand(FileSystemReceiver fileSystem){
        this.fileSystem = fileSystem;
    }
    @Override
    public void execute() {
        this.fileSystem.closeFile();
    }
}
