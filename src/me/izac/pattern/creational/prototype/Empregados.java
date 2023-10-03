package me.izac.pattern.creational.prototype;

import java.util.ArrayList;
import java.util.List;

public class Empregados implements Cloneable{
    private List<String> empList;

    public Empregados(){
        empList = new ArrayList<>();
    }

    public Empregados(List<String> empList){
        this.empList = empList;
    }

    public void buscaDadosEmpregados(){
        //exemplo demostrando empregados vindos da base de dados.
        empList.add("Caio");
        empList.add("Mateus");
        empList.add("João");
        empList.add("Isaac");
        empList.add("Karen");
        empList.add("Luana");
    }

    public List<String> getEmpList(){
        return empList;
    }

    @Override
    public Empregados clone() throws CloneNotSupportedException{
        //copia todos os elementos de empList para emp
        List<String> temp = new ArrayList<>(this.getEmpList());
        return new Empregados(temp);
    }
}
