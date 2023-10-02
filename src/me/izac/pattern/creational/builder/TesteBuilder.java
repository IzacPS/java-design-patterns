package me.izac.pattern.creational.builder;

public class TesteBuilder {
    public static void main(String[] args) {
        Computador computador = new Computador
                .ComputadorBuilder("Intel", "4 GB")
                .setHDD("1 TB")
                .setPlacaDeVideo("Nvidia")
                .setPlacaDeVideoHabilidata(true)
                .setBluetoothHabilitado(true).build();

        System.out.println(computador.toString());
    }
}
