# Padrões de Design - Factory

O padrão de design Factory é usado em situações onde existe uma superclasse com 
várias subiclasses e baseado em uma entrada, precisamos retornar uma dessas
subclasses. Esse padrão tira a responsabilidade criar instâncias da classe cliente
para a classe conhecida como *factory*.


````java
public class HamburgerFactory{
     
}

public class Restaurante{
    //... 
    
    public Hamburger realizarPedido(String pedido){
        
    }
    
   //... 
}
````



https://www.digitalocean.com/community/tutorials/factory-design-pattern-in-java
https://www.youtube.com/watch?v=EdFq_JIThqM&t=385s