package me.izac.pattern.structural.decorator;

public class SportsCar extends CarDecorator{
    public SportsCar(Car car){
        super(car);
    }

    @Override
    public void assemble() {
        super.assemble();
        System.out.println(" Personalizando para um carro esportivo (Sports Car)");
    }
}
