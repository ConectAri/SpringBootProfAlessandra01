package br.com.curso.biblioteca.entity;


import jakarta.persistence.*;

import java.util.Date;

//extends é relacionamento de herança

@Entity
@Table(name = "TB_EXEMPLAR_REVISTA")
@PrimaryKeyJoinColumn(name = "idObra")
public class Revista extends ObraFisica{


    @Column(nullable = false)
    private Integer numero;

    public Revista(){
    }

    public Revista(Long id, String titulo, Date dataPublicacao, String codLocalizacao, Integer numero){
        super(id,titulo,dataPublicacao, codLocalizacao);
        this.numero = numero;
    }

    public int getNumero() {
        return numero;
    }

}

/*

Esta é uma classe Java que usa as anotações do JPA (Java Persistence API) para definir como uma entidade é mapeada
para uma tabela no banco de dados.

A anotação @Entity indica que a classe é uma entidade JPA, o que significa que ela será mapeada para uma tabela
no banco de dados.

A anotação @Table é usada para definir o nome da tabela no banco de dados correspondente à entidade. Neste caso,
o nome da tabela é "TB_EXEMPLAR_REVISTA".

A anotação @PrimaryKeyJoinColumn é usada para indicar que a tabela correspondente a esta entidade terá uma coluna
que é uma chave primária e que a coluna que a define será idObra. Essa anotação é usada para especificar o nome da
coluna na tabela que será usada como chave estrangeira para mapear o relacionamento com outra tabela.

Além disso, a classe Revista estende a classe ObraFisica e adiciona um campo adicional chamado numero,
que representa o número da revista.

O campo numero é mapeado para uma coluna na tabela usando a anotação @Column. A opção nullable = false é usada
para indicar que a coluna não pode ter valores nulos.

No geral, essa classe é usada para mapear uma entidade Revista para uma tabela no banco de dados, definir
o nome da tabela, especificar a chave primária ou as chaves estrangeiras usadas para relacionar essa tabela
com outras tabelas e definir os campos que serão armazenados na tabela.


 */
