package me.izac.pattern.behavioral.command;

public class WriteFileCommand implements Command {
    private FileSystemReceiver fileSystem;

    WriteFileCommand(FileSystemReceiver fileSystem){
        this.fileSystem = fileSystem;
    }

    @Override
    public void execute() {
        this.fileSystem.writeFile();
    }
}
