package br.com.curso.biblioteca.entity;


import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.PrimaryKeyJoinColumn;
import jakarta.persistence.Table;

//extends é relacionamento de herança
@Entity // a classe é uma entidade JPA, o que significa que ela será mapeada para uma tabela no banco de dados.
@Table(name = "TB_PROFESSOR") // Definie o nome da tabela
@PrimaryKeyJoinColumn(name = "idUsuario")// Para mostrar que o id vem de usuário e ficou idUsuario, chave primária
public class Professor extends Usuario{

    @Column(nullable = false)
    private String titulacao;


    public Professor() {

    }

    public Professor(Long id, String nome, String rg, String email, String titulacao) {
        super(id, nome, rg, email);
        this.titulacao = titulacao;
    }


    public String getTitulacao() {
        return titulacao;
    }
}

/*


Este é um exemplo de código em Java que usa anotações do JPA (Java Persistence API) para definir como uma classe é mapeada para uma tabela no banco de dados.



A anotação @Entity é usada para indicar que a classe é uma entidade JPA, o que significa que ela será mapeada para uma tabela no banco de dados.
Cada instância da classe representará uma linha na tabela correspondente.



A anotação @Table é usada para definir o nome da tabela no banco de dados correspondente à classe. Nesse caso, a tabela terá o nome "TB_PROFESSOR".



A anotação @PrimaryKeyJoinColumn é usada para indicar que a tabela correspondente a esta entidade terá uma coluna que é uma chave primária
(como é uma entidade que herda de outra) e que a coluna que a define será idUsuario. Essa anotação é usada para especificar o nome da coluna na
tabela que será usada como chave estrangeira para mapear o relacionamento com outra tabela.



No geral, essas anotações são usadas para mapear uma classe Java para uma tabela no banco de dados, definir o nome da tabela e especificar a
chave primária ou as chaves estrangeiras usadas para relacionar essa tabela com outras tabelas.




 */
