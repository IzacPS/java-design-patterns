package me.izac.pattern.structural.composite;

import java.util.ArrayList;
import java.util.List;

public class FormasSelecionadas implements Forma{
    private List<Forma> formas = new ArrayList<>();
    @Override
    public void mover(int x, int y) {
        System.out.println("Movendo formas selecionadas");
        for (Forma forma : formas){
            forma.mover(x, y);
        }
    }

    public void adicionarForma(Forma forma){
        this.formas.add(forma);
    }

    public void removerForma(Forma forma){
        this.formas.remove(forma);
    }

    public void removerTudo(){
        System.out.println("Removendo todas as formas");
        this.formas.clear();
    }
}
