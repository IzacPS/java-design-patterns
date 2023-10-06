package me.izac.pattern.creational.builder;

public class Computador {

    private String RAM;
    private String HDD;

    private String placaDeVideo;

    private String processador;

    private boolean placaDeVideoHabilidata;
    private boolean bluetoothHabilitado;

    private Computador(ComputadorBuilder builder){
        this.RAM = builder.RAM;
        this.HDD = builder.HDD;
        this.processador = builder.processador;
        this.placaDeVideo = builder.placaDeVideo;
        this.bluetoothHabilitado = builder.bluetoothHabilitado;
        this.placaDeVideoHabilidata = builder.placaDeVideoHabilidata;
    }
    public static class ComputadorBuilder{
        private String RAM;
        private String HDD;

        private String placaDeVideo;

        private String processador;

        private boolean placaDeVideoHabilidata;
        private boolean bluetoothHabilitado;

        ComputadorBuilder(String processador, String RAM){
            this.processador = processador;
            this.RAM = RAM;
        }

        public ComputadorBuilder setHDD(String HDD) {
            this.HDD = HDD;
            return this;
        }

        public ComputadorBuilder setPlacaDeVideo(String placaDeVideo) {
            this.placaDeVideo = placaDeVideo;
            return this;
        }

        public ComputadorBuilder setPlacaDeVideoHabilidata(boolean placaDeVideoHabilidata) {
            this.placaDeVideoHabilidata = placaDeVideoHabilidata;
            return this;
        }

        public ComputadorBuilder setBluetoothHabilitado(boolean bluetoothHabilitado) {
            this.bluetoothHabilitado = bluetoothHabilitado;
            return this;
        }

        public Computador build(){
            return new Computador(this);
        }
    }
    @Override
    public String toString() {
        return "Computador{" +
                "RAM='" + RAM + '\'' +
                ", HDD='" + HDD + '\'' +
                ", placaDeVideo='" + placaDeVideo + '\'' +
                ", processador='" + processador + '\'' +
                ", placaDeVideoHabilidata=" + placaDeVideoHabilidata +
                ", bluetoothHabilitado=" + bluetoothHabilitado +
                '}';
    }
}
