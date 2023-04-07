package br.com.curso.biblioteca.entity;


import java.util.Date;

import br.com.curso.biblioteca.enums.PlataformaDigital;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.PrimaryKeyJoinColumn;
import jakarta.persistence.Table;

// A anotação @Entity indica que a classe é uma entidade JPA (Java Persistence API), ou seja,
//ela representa uma tabela no banco de dados.
@Entity
@Table(name = "TB_POSTAGEM")
@PrimaryKeyJoinColumn(name = "idObra")
public class Postagem extends ObraDigital{
//extends é relacionamento de herança

    @Column(nullable = false) //Sobre @Colum no final da página
    @Enumerated(EnumType.STRING)
    public PlataformaDigital plataforma;


    @Column(nullable = false)
    private String conteudo;


    public Postagem() { //Ver com a professora porque o intelijjei só parou de reclamar assim
        super();
    }

    public Postagem(Long id, String titulo, Date dataPublicacao, PlataformaDigital plataforma, String conteudo) {
        super();
        this.plataforma = plataforma;
        this.conteudo = conteudo;
    }

    public PlataformaDigital getPlataforma() {
        return plataforma;
    }

    public String getConteudo() {
        return conteudo;
    }



}


/*

  ANOTAÇÕES:

  Este é um exemplo de código em Java que usa anotações do JPA (Java Persistence API) para mapear atributos de uma classe para o banco de dados.

A anotação @Column(nullable = false) é usada para indicar que o atributo é uma coluna na tabela do banco de dados e que ela não pode ser nula.
Essa anotação pode ser usada com vários atributos diferentes, como length, name, precision, scale, entre outros. No exemplo dado, ela é usada
em dois atributos diferentes: plataforma e conteudo.

A anotação @Enumerated(EnumType.STRING) é usada para mapear um tipo enumerado para uma coluna de texto (VARCHAR) no banco de dados. Isso significa
 que o valor do atributo plataforma será armazenado no banco de dados como uma string.

O atributo plataforma é um exemplo de um tipo enumerado (enum) que representa uma plataforma digital. A anotação @Enumerated é usada para informar
ao JPA como mapear o enum para o banco de dados. No exemplo, EnumType.STRING é usado para mapear o enum como uma string no banco de dados.

O atributo conteudo é um exemplo de um atributo simples que será armazenado como uma coluna de texto (VARCHAR) no banco de dados.

No geral, as anotações @Column e @Enumerated são usadas para definir como os atributos de uma classe serão mapeados para o banco de dados,
enquanto os atributos da classe representam as colunas correspondentes na tabela do banco de dados.


@Colum:

@Colum é uma anotação do Spring que pode ser usada para mapear um atributo de uma entidade para uma coluna em um banco
 de dados. Quando você usa a anotação @Column em um campo de uma classe de entidade, você pode especificar
  o nome da coluna do banco de dados à qual o campo deve ser mapeado.



 */
