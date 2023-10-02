package me.izac.pattern.behavioral.command;

public class FileSystemClient {
    public static void main(String [] args){
        String osName = System.getProperty("os.name");
        System.out.println("Sistema operacional: " + osName);
        FileSystemReceiver fileSystem;
        if(osName.contains("Windows")){
            fileSystem = new WindowsFileSystemReceiver();
        }else{
            fileSystem = new UnixFileSystemReceiver();
        }

        OpenFileCommand openFileCommand = new OpenFileCommand(fileSystem);
        FileInvoker invoker = new FileInvoker(openFileCommand);
        invoker.execute();

        WriteFileCommand writeFileCommand = new WriteFileCommand(fileSystem);
        invoker = new FileInvoker(writeFileCommand);
        invoker.execute();

        CloseFileCommand closeFileCommand = new CloseFileCommand(fileSystem);
        invoker = new FileInvoker(closeFileCommand);
        invoker.execute();
    }
}
