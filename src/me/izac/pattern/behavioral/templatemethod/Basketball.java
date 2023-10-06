package me.izac.pattern.behavioral.templatemethod;

public class Basketball extends Game {

    @Override
    void endPlay() {
        System.out.println("Jogo de Basketball finalizado!");
    }

    @Override
    void initialize() {
        System.out.println("Jogo de Basketball inicializado! Comece a jogar.");
    }

    @Override
    void startPlay() {
        System.out.println("Jogo de Basketball começou. Divirta-se!");
    }
}
