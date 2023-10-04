package me.izac.pattern.structural.composite;

public class TesteComposite {
    public static void main(String[] args) {
        Forma circulo = new Circulo();
        Forma quadrado = new Quadrado();
        Forma triangulo = new Triangulo();

        FormasSelecionadas formasSelecionadas = new FormasSelecionadas();
        formasSelecionadas.adicionarForma(circulo);
        formasSelecionadas.adicionarForma(quadrado);
        formasSelecionadas.adicionarForma(triangulo);

        formasSelecionadas.mover(10, 20);

        formasSelecionadas.removerTudo();
        formasSelecionadas.adicionarForma(quadrado);
        formasSelecionadas.adicionarForma(triangulo);

        formasSelecionadas.mover(-15, 10);

    }
}
