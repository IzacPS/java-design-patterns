package me.izac.pattern.behavioral.command;

public class WindowsFileSystemReceiver implements FileSystemReceiver{
    @Override
    public void openFile() {
        System.out.println("Abrindo arquivo em um sistema operacional Windows");
    }

    @Override
    public void writeFile() {
        System.out.println("Escrevendo no arquivo em um sistema operacional Windows");
    }

    @Override
    public void readFile() {
        System.out.println("Lendo do arquivo em um sistema operacional Windows");
    }

    @Override
    public void closeFile() {
        System.out.println("Fechando arquivo em um sistema operacional Windows");
    }
}
