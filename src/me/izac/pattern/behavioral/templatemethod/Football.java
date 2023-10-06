package me.izac.pattern.behavioral.templatemethod;

public class Football extends Game {

   @Override
   void endPlay() {
      System.out.println("Jogo de Futebol finalizado!");
   }

   @Override
   void initialize() {
      System.out.println("Jogo de Futebol inicializado! Comece a jogar.");
   }

   @Override
   void startPlay() {
      System.out.println("Jogo de Futebol começou. Divirta-se!");
   }
}
