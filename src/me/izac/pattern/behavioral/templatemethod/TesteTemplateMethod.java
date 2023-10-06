package me.izac.pattern.behavioral.templatemethod;

public class TesteTemplateMethod {
    public static void main(String[] args) {

        Game game = new Football();
        game.play();
        System.out.println();
        game = new Basketball();
        game.play();
        System.out.println();
        game = new Tenis();
        game.play();
    }
}
