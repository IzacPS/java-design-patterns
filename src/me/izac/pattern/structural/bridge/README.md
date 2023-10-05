
O padrão de design Bridge é um padrão que permite dividir uma classe ou um grande 
conjunto de classes estreitamente relacionadas nas hierarquias de abstração e 
implementação onde os dois podem variar de forma independente. O padrão traz a ideia
de utilizar composição sobre herança.

O padrão possui uma interface que age como uma ponte que torna a funcionalidade de
classes concretas, independente das classes que impolementam a interface.

Podemos exemplificar com uma interface **DrawDPI** que age como uma ponte que implementa
as classes **RedCircle**, **GreenCircle**. **Shape** é uma classe abstrata que usará
 o objeto do tipo **DrawDPI**.

https://www.tutorialspoint.com/design_pattern/bridge_pattern.htm
https://medium.com/xp-inc/desing-patterns-parte-9-bridge-5ca127f72de
https://www.digitalocean.com/community/tutorials/bridge-design-pattern-java