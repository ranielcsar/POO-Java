### Como interagir com a lista:

Antes de começar a ler sobre **Iterator**, veja [ArrayList](https://github.com/ranielcsar/POO-Java/blob/master/Collections/ArrayList.md).

O que é o iterator? Nada mais é do que uma parte da Collections que é usado para "interagir" (eu falo assim) com a lista. Nesse caso, usamos para percorrer toda a lista em busca de elementos. Tanto para exibir informações quanto para removê-las.

A iterator possui métodos como:

* next() - próximo
* hasNext() - há próximo

Primeiramente precisamos importar a biblioteca do Iterator com **java.util.Iterator**.

```java
import java.util.Iterator;
```

Digamos que tenhamos uma classe **Anime** onde vamos ter como atributo: nome e autor.

! Lembre-se que estamos usando uma lista do tipo **ArrayList**.

```java
List<Anime> listaAnimes = new ArrayList<>();
```

Adicionamos animes à lista:

```java
Anime dbz = new Anime("Dragon Ball", "Akira Toriyama");
Anime onepiece = new Anime("One Piece", "Eiichiro Oda");

listaAnimes.add(dbz);
listaAnimes.add(onepiece);
```

Ok.

Quando damos um print na tela, só aparecem os nomes:

```java
System.out.println(listaAnimes);
```

A saída será os nomes: Dragon Ball e One Piece.

Mas, e se quisermos mostrar o nome do autor também? Explicarei com exemplo usando Iterator:

```java
// Exemplo com iterator
Iterator<Anime> animeIterator = listaAnimes.iterator();

while (animeIterator.hasNext())
{
    System.out.println(animeIterator.next());
}
```

Usando o método **hasNext()** que retorna *true* ou *false*, verificamos se ainda existem elementos na lista. Pois o método "pergunta" se existe próximo. Se tiver próximo, usamos o método **next()** para pegar esse próximo elemento e usarmos. Podemos usar também, já que o Iterator tá interagindo com nossa lista, alguns métodos da classe Anime. Como o **getNome()** por exemplo.

```java
System.out.println(animeIterator.next().getNome());
System.out.println(animeIterator.next().getAutor());
```

Assim ele irá mostrar o nome e autor que está associado a esse elemento.

* Existem outros métodos para percorrer a lista, citarei mais dois exemplos:

```java
// Exemplo com for
for (int i = 0; i < listaAnimes.size(); i++)
{
    System.out.println(listaAnimes.get(i));
}

// Exemplo com for each
for (Anime animes : listaAnimes)
{
    System.out.println(animes);
}
```

O método **size()** que está no exemplo com *for* é usado para determinar quantos elementos existem naquela lista.

___

### REFERÊNCIAS

CRUNCHIFY. How to iterate through java list? five (5) ways to iterate through loop in java. **Crunchify**. Disponível em: <https://crunchify.com/how-to-iterate-through-java-list-4-way-to-iterate-through-loop/>. Acesso em: 10 ago. 2018.

LANHELLAS, R. Java collections: set, list e iterator. **DevMedia**. Disponível em: <https://www.devmedia.com.br/java-collections-set-list-e-iterator/29637>. Acesso em: 10 ago. 2018.
