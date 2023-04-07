package br.com.curso.biblioteca.entity;


import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Inheritance;
import jakarta.persistence.InheritanceType;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;

import java.util.List;

@Entity
@Table(name = "TB_USUARIO")
@Inheritance(strategy = InheritanceType.JOINED) // A anotação @Inheritance é usada para definir a estratégia de herança a ser usada pela classe. Neste caso, a estratégia escolhida é
// InheritanceType.JOINED, o que significa que o JPA criará uma tabela para a classe base (no caso, a classe Usuario) e tabelas separadas para cada uma de suas subclasses
public abstract class Usuario {

    // A classe é abstrata, o que significa que não pode ser instanciada diretamente, apenas suas subclasses podem.



    @Id               //Atributo se chama strategy, ele é a estratégia de geração.
    @GeneratedValue(strategy = GenerationType.IDENTITY)// Cada banco de dados tem a sua estratégia
    protected Long id;

    @Column(nullable = false)
    protected String nome;

    @Column(nullable = false)
    protected String rg;

    @Column(nullable = false)
    protected String email;


    @OneToMany(mappedBy = "usuario")//Um usuário para MUITOS empréstimos
    protected List<Emprestimo> emprestimos;
    /*
    A anotação para mapear este relacionamento é a @OneToMany. Como o relacionamento e a ligação
    entre as tabelas já foi indicado através do @ManyToOne e @JoinColumn na classe Emprestimo,
    na classe Usuario podemos apenas indicar que o mapeamento foi realizado na classe Emprestimo,
    através do atributo mappedBy da @OneToMany.
     */

    public Usuario(){

    }
    public Usuario(Long id, String nome, String rg, String email) {
        this.id = id;
        this.nome = nome;
        this.rg = rg;
        this.email = email;
    }

    public Long getId() {
        return id;
    }

    public String getNome() {
        return nome;
    }

    public String getRg() {
        return rg;
    }

    public String getEmail() {
        return email;
    }


}


/*

Esta é uma classe Java que usa as anotações do JPA (Java Persistence API) para definir como uma entidade é mapeada para uma tabela no banco de dados.
A classe é abstrata, o que significa que não pode ser instanciada diretamente, apenas suas subclasses podem.

A anotação @Entity indica que a classe é uma entidade JPA, o que significa que ela será mapeada para uma tabela no banco de dados.

A anotação @Table é usada para definir o nome da tabela no banco de dados correspondente à entidade. Neste caso, o nome da tabela é "TB_USUARIO".

A anotação @Inheritance é usada para definir a estratégia de herança a ser usada pela classe. Neste caso, a estratégia escolhida é InheritanceType.JOINED,
o que significa que o JPA criará uma tabela para a classe base (no caso, a classe Usuario) e tabelas separadas para cada uma de suas subclasses.

O campo id é definido como a chave primária da tabela, usando as anotações @Id, @GeneratedValue e @Column. A anotação @Id indica que o campo é uma chave primária,
@GeneratedValue é usada para indicar que o valor da chave primária será gerado automaticamente pelo banco de dados e @Column é usada para definir o nome da coluna correspondente na tabela.

Os campos nome, rg e email são mapeados para colunas na tabela usando a anotação @Column. A opção nullable = false é usada para indicar que as colunas não podem ter valores nulos.

O campo emprestimos é mapeado para uma coleção de objetos Emprestimo usando a anotação @OneToMany. A opção mappedBy é usada para especificar o nome do atributo na classe Emprestimo
que mapeia o relacionamento com a classe Usuario.

Em resumo, essa classe é usada como uma classe base para outras classes que representam diferentes tipos de usuários. Ela define os campos básicos que todos os usuários
têm em comum (id, nome, rg e email), além de um relacionamento de um-para-muitos com a classe Emprestimo. O uso da estratégia de herança JOINED permite que outras classes possam estender a classe Usuario e adicionar campos adicionais, sem ter que duplicar os campos básicos em cada tabela.







 */
