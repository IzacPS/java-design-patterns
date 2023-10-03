package me.izac.pattern.creational.prototype;

import java.util.List;

public class TestPrototype {
    public static void main(String[] args) throws CloneNotSupportedException {
        Empregados empregados = new Empregados();

        empregados.buscaDadosEmpregados();

        Empregados empregados1 = (Empregados) empregados.clone();
        Empregados empregados2 = (Empregados) empregados.clone();
        List<String> list = empregados1.getEmpList();
        list.add("Marcelo");
        List<String> list1 = empregados2.getEmpList();
        list1.remove("Isaac");

        System.out.println("lista original de empregados: " + empregados.getEmpList());
        System.out.println("lista modificada com adição de empregado: " + list);
        System.out.println("lista modificada com remoção de empregado: " + list1);
    }
}
