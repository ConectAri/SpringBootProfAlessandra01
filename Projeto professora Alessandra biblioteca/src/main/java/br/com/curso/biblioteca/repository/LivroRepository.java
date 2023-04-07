package br.com.curso.biblioteca.repository;

import java.util.List;

import br.com.curso.biblioteca.entity.Livro;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;


//Essa classe é uma interface do repositório de dados que se comunica com
// o banco de dados para acessar e manipular dados da entidade "Livro".
@Repository
public interface LivroRepository extends JpaRepository<Livro, Long> {
    //Cada repositoy é responsável pela persistencia de uma entidade
    //Entidade Livro que será a persistência e Long(é o tipo a chave primária)
    // A chave primária ID tem o tipo Long

    // Pesquisando por palavras-chaves que aqui no caso é ISBN
    public Livro findByIsbn(String isbn);

    // Pesquisando por query nativa
    @Query(value =
            "SELECT \r\n"
                    + " ROUND(DATEDIFF(NOW(), o.data_publicacao) / 365) AS anos_publicacao\r\n"
                    + "FROM \r\n"
                    + " biblioteca.tb_exemplar_livro l,\r\n"
                    + " biblioteca.tb_exemplar_obra o\r\n"
                    + "WHERE\r\n"
                    + " l.id_obra = o.id\r\n"
                    + " AND o.id = :id", nativeQuery = true)
    public Integer quantosAnosPublicacaoLivro(@Param("id") Long idLivro);

    @Query(name = "buscaTodosOrdenadosTitulo")
    public List<Livro> buscaTodosOrdenadosTitulo();

    @Query(name = "buscaTodosOrdenadosAutor")
    public List<Livro> buscaTodosOrdenadosAutor();

    @Query(name = "buscaMaisAntigo")
    public String buscaMaisAntigo();

    @Transactional(readOnly = false)
    @Modifying
    @Query("UPDATE Livro SET isbn = :isbn WHERE id = :id")
    public void atualizaIsbnLivro(@Param("id") Long idLivro, @Param("isbn") String isbn);

    @Transactional(readOnly = false)
    @Modifying
    @Query("DELETE FROM Livro WHERE id = :id")
    public void apagaLivro(@Param("id") Long idLivro);
}


/*
Essa classe é uma interface do repositório de dados que se comunica com o banco de dados para acessar e manipular dados
da entidade "Livro".

A anotação @Repository é usada para indicar que a classe é um repositório de dados e permite que o Spring faça a
injeção de dependência.

A interface estende JpaRepository<Livro, Long>, que é uma interface genérica do Spring Data JPA que fornece métodos
básicos de CRUD (Create, Retrieve, Update, Delete) e outras funcionalidades para o acesso a dados.

Os métodos definidos nessa classe são consultas personalizadas e atualizações que serão executadas pelo JPA.
Esses métodos incluem consultas por palavras-chaves, consultas por query nativa, busca por títulos e autores ordenados,
busca pelo livro mais antigo, atualização de informações de um livro e exclusão de um livro.

Esses métodos usam a anotação @Query para indicar a consulta JPA que será executada. A anotação @Modifying indica
que o método é uma operação de atualização, exclusão ou inserção no banco de dados. A anotação @Transactional indica
que a transação deve ser gerenciada pelo Spring. Os parâmetros de consulta são definidos usando a anotação @Param.

-----------------------
EXPLICANDO:

@Query(value =
            "SELECT \r\n"
                    + " ROUND(DATEDIFF(NOW(), o.data_publicacao) / 365) AS anos_publicacao\r\n"
                    + "FROM \r\n"
                    + " biblioteca.tb_exemplar_livro l,\r\n"
                    + " biblioteca.tb_exemplar_obra o\r\n"
                    + "WHERE\r\n"
                    + " l.id_obra = o.id\r\n"
                    + " AND o.id = :id", nativeQuery = true)
    public Integer quantosAnosPublicacaoLivro(@Param("id") Long idLivro);

 Esse código define uma consulta SQL nativa que calcula a idade de publicação de um livro em anos.

 A consulta é executada usando a anotação @Query com a opção nativeQuery definida como true.

 A consulta SQL seleciona a diferença em anos entre a data atual e a data de publicação do livro. A cláusula "ROUND"
  é usada para arredondar o resultado para o número inteiro mais próximo.

 A tabela "biblioteca.tb_exemplar_livro" e "biblioteca.tb_exemplar_obra" são usadas na cláusula "FROM" para realizar
  um join entre as duas tabelas. A cláusula "WHERE" é usada para filtrar as linhas onde o id do livro corresponde ao id fornecido como parâmetro.

 O resultado da consulta é mapeado para um tipo Integer pelo método "quantosAnosPublicacaoLivro", que recebe o parâmetro "id" do tipo Long. Esse método é usado para retornar a idade de publicação do livro em anos.


O que é um join entre tabelas?????

Join é um operador utilizado em banco de dados relacionais que permite combinar duas ou mais tabelas com base em uma coluna comum
 entre elas. A união de várias tabelas permite que sejam criadas consultas mais complexas e sofisticadas para obter informações
 específicas do banco de dados.

O join é realizado através de uma cláusula SQL que especifica as tabelas que serão combinadas e a relação entre elas.
A cláusula "JOIN" é usada para especificar a tabela secundária e a coluna que ela tem em comum com a tabela primária.
As tabelas são combinadas com base nas colunas que possuem os mesmos valores.

Existem diferentes tipos de join, sendo os mais comuns:

Inner Join: retorna apenas as linhas que possuem valores correspondentes nas duas tabelas;
Left Join: retorna todas as linhas da tabela da esquerda e as linhas correspondentes da tabela da direita;
Right Join: retorna todas as linhas da tabela da direita e as linhas correspondentes da tabela da esquerda;
Full Outer Join: retorna todas as linhas das duas tabelas, correspondentes ou não.
O join entre tabelas é amplamente utilizado em bancos de dados relacionais para realizar consultas complexas
 e obter informações específicas de múltiplas tabelas.




 */
