# Padrões de Desenvolvimento - *Chain Of Responsability* 

O padrão de design *Chain of Responsability* é usado para evitar o acoplamento 
entre objetos em uma cadeia onde esses objetos devem processar uma certa requisição. 
Cada objeto na cadeia tem a capacidade de decidir se ele irá processar a solicitação
ou se  essa solicitação será enviada para o próximo na objeto na cadeia.
Como um exemplo desse padrão na linguagem Java. 

Podemos observar como os blocos try-catch funcionam. Podemos desenvolver para 
cada bloco catch uma solicitação para processar uma determinada exceção. 
Se um bloco não conseguir processar a exceção, então esse bloco irá enviar essa 
solicitação para o próximo bloco catch. E mesmo que nenhum dos blocos consiga 
processar a exceção, a solicitação é enviada para o programa principal.
//exemplo try catch aqui.

https://www.digitalocean.com/community/tutorials/chain-of-responsibility-design-pattern-in-java
https://www.devmedia.com.br/design-patterns-entendendo-os-padroes-chain-of-responsibility-command-iterator-mediator-e-memento/29397