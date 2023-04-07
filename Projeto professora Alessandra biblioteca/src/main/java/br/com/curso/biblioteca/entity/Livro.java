package br.com.curso.biblioteca.entity;


import jakarta.persistence.*;

import java.util.Date;

//A classe Livro não é abstrata
//extends é relacionamento de herança

@Entity
@Table(name = "TB_EXEMPLAR_LIVRO")
@PrimaryKeyJoinColumn(name = "idObra")// Para mostrar que o id vem da obra e ficou idObra
/*
Essa é uma anotação utilizada em código Java para definir consultas nomeadas em uma aplicação que usa
um banco de dados relacional.

NO FINAL DESSA CLASSE ANOTEI O QUE SIGNIFICA CADA CONSULTA COMO FORMA DE CONHECIMENTO.
 */
@NamedQueries({
        @NamedQuery(name = "buscaTodosOrdenadosTitulo", query = "FROM Livro ORDER BY titulo"),
        @NamedQuery(name = "buscaTodosOrdenadosAutor", query = "FROM Livro ORDER BY autor")
})
@NamedNativeQueries({
        @NamedNativeQuery(name = "buscaMaisAntigo", query = "SELECT \r\n"
                + " o.titulo \r\n"
                + "FROM \r\n"
                + " biblioteca.tb_exemplar_livro l,\r\n"
                + " biblioteca.tb_exemplar_obra o\r\n"
                + "WHERE\r\n"
                + " l.id_obra = o.id\r\n"
                + "ORDER BY\r\n"
                + " o.data_publicacao\r\n"
                + "LIMIT 1")
})
public class Livro extends ObraFisica {

    @Column(nullable = false)
    private String autor;

    @Column(nullable = false)
    private String isbn;



    //Construtor padrão, pois o próprio SpringBoot poderá realizar algunas instâncias
    public Livro() {
    }

    public Livro(Long id, String titulo, Date dataPublicacao, String codLocalizacao, String autor, String isbn) {
        super(id, titulo, dataPublicacao, codLocalizacao);
        this.autor = autor;
        this.isbn = isbn;
    }

    public String getAutor() {
        return autor;
    }

    public String getIsbn() {
        return isbn;
    }


    @Override   // Ao final dessa classe coloqueio o que este método faz como forma de anotação
    public String toString() {
        return "Livro [id="
                + id + ", titulo="
                + titulo + ", dataPublicacao=" +
                dataPublicacao + ", codLocalizacao="
                + codLocalizacao + ", autor="
                + autor + ", isbn="
                + isbn + "]";
    }



}


/*.

@PrimaryKeyJoinColumn(name = "idObra"):

Quando usamos uma hierarquia de classes em um sistema de mapeamento objeto-relacional (ORM)
para persistir essas classes em um banco de dados relacional, geralmente precisamos definir
como as tabelas da hierarquia de classes serão criadas no banco de dados.

A anotação @PrimaryKeyJoinColumn(name = "idObra") é usada em uma subclasse para indicar
que ela terá uma chave primária própria e que essa chave primária fará referência à chave primária
da tabela correspondente à classe pai na hierarquia de classes.

Por exemplo, se tivermos uma hierarquia de classes em que a classe pai seja Obra e a subclasse
seja Livro, podemos usar a anotação @PrimaryKeyJoinColumn(name = "idObra") na classe Livro para
indicar que ela terá uma chave primária própria e que essa chave primária fará referência
à chave primária da tabela da classe pai Obra.

Isso é necessário porque, em geral, cada tabela no banco de dados precisa ter sua própria
chave primária para identificar cada registro exclusivamente na tabela. No entanto,
a tabela da classe pai Obra já terá sua própria chave primária. Portanto, a anotação
@PrimaryKeyJoinColumn é usada para definir uma coluna na tabela da subclasse Livro que
fará referência à coluna de chave primária da tabela da classe pai Obra.

Dessa forma, ao usar a anotação @PrimaryKeyJoinColumn(name = "idObra"),
o desenvolvedor está especificando qual coluna será usada como chave primária na tabela
da subclasse Livro, bem como mantendo a relação de junção (join) com a tabela correspondente
à classe pai Obra. Isso garante que a hierarquia de classes seja mapeada para tabelas relacionais
de forma consistente e eficiente.


--------------------------------

@NamedQuery e @NamedNativeQuery:

As anotações @NamedQuery e @NamedNativeQuery são usadas para declarar as consultas nomeadas e especificar seus parâmetros.
As consultas nomeadas são consultas pré-compiladas que podem ser reutilizadas em diferentes partes do código, melhorando
a eficiência e a segurança da aplicação.

No exemplo dado, existem três consultas nomeadas definidas. As duas primeiras, buscaTodosOrdenadosTitulo
e buscaTodosOrdenadosAutor, são consultas escritas em HQL (Hibernate Query Language) e são usadas para buscar
todos os livros da biblioteca ordenados por título ou autor, respectivamente.

A terceira consulta, buscaMaisAntigo, é uma consulta nativa escrita em SQL e é usada para buscar o título do livro
mais antigo da biblioteca. Nesse caso, a consulta é escrita em SQL porque ela usa recursos específicos do banco de
dados que não são suportados pela HQL.

Essas anotações são usadas comumente em frameworks ORM (Object-Relational Mapping) como o Hibernate, que mapeia
as classes Java para tabelas do banco de dados, permitindo que as operações de banco de dados sejam realizadas
por meio de objetos Java, tornando a programação mais fácil e intuitiva.

--------

 @Override

Esse é um método toString() sobrescrito, que é comum em classes Java para fornecer uma representação em forma de
String do objeto atual.

No código fornecido, o método toString() retorna uma string contendo a representação em forma de texto dos atributos
da classe Livro, incluindo id, titulo, dataPublicacao, codLocalizacao, autor e isbn.

Essa representação em forma de texto é útil para depuração e registro, pois permite que os desenvolvedores possam
inspecionar o estado do objeto e identificar possíveis erros ou inconsistências. Além disso, é comum usar essa
representação em loggers para ajudar no diagnóstico de problemas em sistemas em produção.




...*/
