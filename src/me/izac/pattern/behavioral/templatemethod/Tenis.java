package me.izac.pattern.behavioral.templatemethod;

public class Tenis extends Game {

    @Override
    void endPlay() {
        System.out.println("Jogo de Tênis finalizado!");
    }

    @Override
    void initialize() {
        System.out.println("Jogo de Tênis inicializado! Comece a jogar.");
    }

    @Override
    void startPlay() {
        System.out.println("Jogo de Tênis começou. Divirta-se!");
    }
}
