package me.izac.pattern.creational.singleton;

public class StaticBlockSingleton {
    private static final StaticBlockSingleton instance;

    private StaticBlockSingleton(){}

    static {
        try{
            instance = new StaticBlockSingleton();
        }catch (Exception e){
            throw new RuntimeException("Uma exceção ocorreu na na criação da instancia");
        }
    }

     public static StaticBlockSingleton getInstance(){
        return instance;
     }

}
