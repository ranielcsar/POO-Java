### List e ArrayList:

List é uma interface implementada pela classe ArrayList, que é implementada como se fosse um **vetor[]**, porém ela cresce dinamicamente à medida em que se adiciona elementos. Ou seja, ela se adapta. Se expande conforme você quiser. Além disso pode ser útil no gerenciamento de consumo de memória de programa, já que elementos que não servem são excluídos.

Além disso, nos permite acessar os elementos usando:

* get() - pegar valor
* set() - dar valor

Adicionar novos elementos à lista com:

* add() - adicionar

E remover elementos:

* remove() - remover

#### Exemplos com código:

Para declararmos um ArrayList primeiro temos que importar as bibliotecas **java.util.List;** e **java.util.ArrayList**:

```java
import java.util.List;
import java.util.ArrayList;
```

Logo após isso, você precisa instanciar uma nova lista. Vou usar uma lista de personagens que gosto em filmes, animes, mangás, etc.

```java
List listaPersonagens = new ArrayList();
```

Digamos que já temos o objeto Personagem criado...Feito isso, já podemos adicionar elementos à nossa lista.

```java
Personagem luffy = new Personagem("Luffy", "One Piece");

listaPersonagens.add(luffy);
```
Na lista, nós podemos colocar algo além de personagem, ela está aberta a qualquer tipo de objeto. Mas, e se quisermos uma lista *apenas* com personagens? Hmm...Vejamos o que podemos fazer.

Em java, existe algo chamado Generics, que pode ser aplicado à ArrayList da seguinte maneira:

```java
List<Personagem> listaPersonagens = new ArrayList<Personagem>();
```

Que também pode ser escrito assim:

```java
List<Personagem> listaPersonagens = new ArrayList<>();
```
O que está entre chaves (**< >**) é o tipo que aquela lista vai aceitar. Caso o objeto adicionado na lista não seja do tipo Personagem, vai ocorrer um erro.

Você também pode criar lista de Strings, inteiros, etc. É só determinar entre as chaves `<String>`,`<int>`.

* Seguindo com o exemplo:

```java
List<Personagem> listaPersonagens = new ArrayList<>(); // instância da lista

Personagem luffy = new Personagem("Luffy", "One Piece");
Personagem goku = new personagem("Goku", "Dragon Ball");
Personagem lawliet = new personagem("Lawliet", "Death Note");

listaPersonagens.add(luffy);
listaPersonagens.add(goku);
listaPersonagens.add(lawliet);
```

Adicionei mais alguns personagens à lista. Viu?! Simples! Só isso. Somente só. Apenas.

Para remover é praticamente a mesma coisa:

```java
listaPersonagens.remove(goku);
```

Pronto, removemos o personagem Goku da lista.

* Caso queira limpar a lista, basta usar o método **clear()**.

```java
listaPersonagens.clear();
```

* Você pode também usar apenas o **java.util.ArrayList;** ao invés das duas.

Esse é um dos básicos para começar a usar a ArrayList do Java.
___

### REFERÊNCIAS

CAMARGO, W. B. Exemplos com arraylists e suas propriedades e métodos – coleções: estrutura da linguagem – parte 2. **DevMedia**. Disponível em: <https://www.devmedia.com.br/exemplos-com-arraylists-e-suas-propriedades-e-metodos-colecoes-estrutura-da-linguagem-parte-2/19255>. Acesso em: 09 ago. 2018.

GARBADE, M. J. Coisas que você deveria saber sobre java arraylist. **LIVEEDU.TV BLOG**. Disponível em: <http://blog.liveedu.tv/coisas-que-voce-deveria-saber-sobre-java-arraylist/>. Acesso em: 09 ago. 2018.

LANHELLAS, R. Java collections: set, list e iterator. **DevMedia**. Disponível em: <https://www.devmedia.com.br/java-collections-set-list-e-iterator/29637>. Acesso em: 10 ago. 2018.
