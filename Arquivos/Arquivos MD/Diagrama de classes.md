### Diagrama de classe:

Usado para descrever quais classes serão usadas em determinado sistema. E, quando eu falo classes, eu falo todos as suas características. Ou seja, nome, atributos, métodos e sua relação com os objetos.

Dentro da UML existem 3 tipos de diagramas, que são eles: de comportamento, de interação e de estrutura. O diagrama de classe é um estrutural porque mostra o que deve estar no sistema a ser implementado. Quem mais usa esse tipo de diagrama são engenheiros de software.

A forma da classe em um diagrama possui 3 linhas. Na primeira linha, o nome da classe; na do meio, os atributos; por último, os métodos/funções da classe.

Como exemplo, usarei uma carta de baralho. O que temos numa carta de baralho? Um naipe e um número. Usei alguns métodos básicos para demonstrar com ficaria um modelo completo. Os símbolos ao lado de cada parte são os modificadores de acesso.

* Público (+)
* Privado (-)
* Protegido (#)


<br>

* Exemplo:


| Carta |
|   -   |
| # numero: **int**<br> # naipe: **String**
| + getNumero: **int**<br> + getNaipe: **String**<br> + mostrarCarta: **void**|

___ 


### Interação com outros objetos/classes:

Interações com objetos ou outras classes no diagrama, são de suma importância.

![alt text](https://raw.githubusercontent.com/ranielcsar/POO-Java/master/Arquivos/Diagramas/diagramaHeran%C3%A7a.png "Herança")

Acima vemos um exemplo de herança, representada por essa seta com uma ponta *fechada*. Onde o naipe *herda* os atributos da classe *Carta* mudando apenas o tipo do naipe e o número.

![alt text](https://raw.githubusercontent.com/ranielcsar/POO-Java/master/Arquivos/Diagramas/DiagramaAssosciado.png "Associado")

Temos aqui a representação de associação bidirecional, representada pela linha que liga um a outro. As classes sabem que se relacionam.

Existe também as associações unidirecionais em que é representada por uma seta com a ponta *aberta*, diferente da herança. A diferença é que aqui, uma classe está associada a outra classe e que não tem relação nenhuma.

Por exemplo, um radar de velocidade ao detectar algum veículo se aproximando, ele dispara os sensores e faz o que tem de fazer. Já o veículo não tem essa de detectar o radar, ele simplesmente não tem nada associado ao radar.

___

### REFERÊNCIAS

LUCIDCHART. Tutorial de diagrama de classe. Disponível em: <https://www.lucidchart.com/pages/pt/diagrama-de-classe>. Acesso em: 07 ago. 2018.
