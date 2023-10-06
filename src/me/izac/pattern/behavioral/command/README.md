# Padrões de Design - Command

O padrão de design **Command** é um modelo do tipo requisição-resposta
(request-response) de baixo acoplamento. Nesse modelo, a requisição é enviada
para um objeto **Invoker** que por sua vez, passa a requisição para
encapsulada para um objeto do tipo Command. Depois de receber a
requisição, o objeto Command passa a requisição para o método
apropriado executar uma ação específica.

Imagina que precisamos de um sistema de arquivos utilizado com
métodos ``open``, ``read``, ``write`` e ``close``. O sistema deve
suportar múltiplos sistemas operacionais como ``Unix`` e ``Windows``.
Primeiramente precisamos criar as classes receiver que irão realizar
ações. Para isso, criamos uma interface comum entre esses objetos
que serão criados.

````java
public interface FileSystemReceiver {
    void openFile();
    void writeFile();
    void readFile();
    void closeFile();
}
````
Agora implementamos como exemplo um objeto para os diferentes sistemas
operacionais ``Unix`` e ``Windows``.

```java
public class UnixFileSystemReceiver implements FileSystemReceiver{
    @Override
    public void openFile() {
     //Abertura de um arquivo
    }
    
    @Override
    public void writeFile() {
     //Escrita em um arquivo
    }
    
    @Override
    public void readFile() {
     //Leitura de um arquivo
    }
    
    @Override
    public void closeFile() {
     //Fecha um arquivo
    }
}

public class WindowsFileSystemReceiver implements FileSystemReceiver{
    @Override
    public void openFile() {
     //Abertura de um arquivo
    }
    
    @Override
    public void writeFile() {
     //Escrita em um arquivo
    }
    
    @Override
    public void readFile() {
     //Leitura de um arquivo
    }
    
    @Override
    public void closeFile() {
     //Fecha um arquivo
    }
}
```

Precisamos agora da interface responsável por realizar uma das
ações no arquivo. Essa será nossa interface base Command.

```java
public interface Command {
    void execute();
}
```
Agora podemos criar uma commando para cada ação que temos no
arquivo.

```java
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
//Demais implementações
public class CloseFileCommand implements Command{
    //...
    @Override
    public void execute() {
     this.fileSystem.closeFile();
    }
}

public class ReadFileCommand implements Command{
    //...
    @Override
    public void execute() {
     this.fileSystem.readFile();
    }
}

public class WriteFileCommand implements Command{
    //...
    @Override
    public void execute() {
     this.fileSystem.writeFile();
    }
}
```
A objeto invoker faz o encapsulamento do comando e passa a requisição para o objeto comando
processar a ação.

```java
public class FileInvoker {
    public Command command;

    public FileInvoker(Command command){
        this.command = command;
    }

    public void execute(){
        this.command.execute();
    }
}

```
Agora, ao executar o programa precisamos somente escolher qual
o sistema que arquivo que iremos utilizar de acordo com o sistema
operacional. Depois, podemos criar um tipo de ação como por exemplo
abrir um arquivo ``OpenFileCommand`` e criar um invocador da ação que
irá ser executado ``FileInvoker``, injetando a ação nesse objeto.

```java
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
```

## Referências
- https://medium.com/xp-inc/design-patterns-parte-16-command-9c73af726c9c
- https://www.tutorialspoint.com/design_pattern/command_pattern.htm
- https://www.digitalocean.com/community/tutorials/command-design-pattern


