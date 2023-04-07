package br.com.curso.biblioteca.entity;


import java.util.Date;

import jakarta.persistence.*;


//Obra é SUPERCLASSE

@Entity
@Table(name = "TB_EXEMPLAR_OBRA")
@Inheritance(strategy = InheritanceType.JOINED)
public abstract class Obra {

    //O modificador protected geralmente é utilizado dentro das SUPERCLASSE
    //O padrão é private
    // As classes livro, obra, etc.. conseguem acessar os atributos sem precisar
    //utilizar o get, pois o protected permite a utilização dos atributos da Obra

    @Id               //Atributo se chama strategy, ele é a estratégia de geração.
    @GeneratedValue(strategy = GenerationType.IDENTITY)// Cada banco de dados tem a sua estratégia
    protected Long id;

    @Column(nullable = false)
    protected String titulo;

    @Column(nullable = false)
    @Temporal(TemporalType.DATE)
    protected Date dataPublicacao;

    /*
    Neste caso não seria  necessário o mapeamento bidirecional, pois o lado do
    Emprestimo já foi feito, isso abaixo é OPCIONAL.
     */

    @OneToOne(mappedBy = "obra")
    protected Emprestimo emprestimo;

    //Construtor padrão
    public Obra() {
    }

    //Construtor
    public Obra(Long id, String titulo, Date dataPublicacao) {
        this.id = id;
        this.titulo = titulo;
        this.dataPublicacao = dataPublicacao;
    }

    //Gerando somente os gets
    //O set é mais utlizado quando a variável é alterada, no geral isso não
    //acontece,pois id, titulo, datapublicação já é algo mais definido.

    public Long getId() {
        return id;
    }

    public String getTitulo() {
        return titulo;
    }

    public Date getDataPublicacao() {
        return dataPublicacao;
    }


}

/*

A anotação @Temporal(TemporalType.DATE) é utilizada para especificar o tipo de dados de um atributo que
representa uma data no formato java.util.Date. A anotação informa ao JPA como deve ser feita a conversão entre
o tipo de dados da aplicação e o tipo de dados do banco de dados.


No exemplo apresentado, a anotação @Temporal(TemporalType.DATE) está sendo utilizada para informar que o
atributo em questão deve ser mapeado para uma coluna do tipo DATE no banco de dados. Isso significa que
apenas a informação de data será persistida na coluna correspondente, sem considerar o horário.


Caso a anotação @Temporal(TemporalType.DATE) não seja utilizada, o JPA assumirá que o atributo deve ser
mapeado para uma coluna do tipo TIMESTAMP no banco de dados, que armazena tanto a informação de data
quanto a informação de horário.


É importante destacar que existem outros valores possíveis para a anotação @Temporal, como TemporalType.TIME
e TemporalType.TIMESTAMP, que são utilizados para especificar o tipo de dados de atributos que representam
horários ou datas e horários completos, respectivamente. A escolha do valor adequado para a anotação depende
do tipo de dado que será armazenado na coluna correspondente no banco de dados.


Classe de herança é uma técnica de modelagem de classes em que uma classe pai (ou superclasse) é
estendida por uma ou mais subclasses, que herdam seus atributos e métodos.



@Inheritance(strategy = InheritanceType.JOINED):

Quando estamos usando um sistema de mapeamento objeto-relacional (ORM) para persistir essas classes
em um banco de dados relacional, é necessário definir como a hierarquia de classes será mapeada para as
tabelas do banco de dados. É aí que entra a anotação @Inheritance(strategy = InheritanceType.JOINED).

Essa anotação define que a estratégia de mapeamento de herança será "joined", o que significa que
cada subclasse será mapeada para sua própria tabela no banco de dados, além da tabela correspondente
à classe pai. Essa tabela das subclasses conterá apenas os campos adicionais que não estão na classe pai,
juntamente com uma coluna que funcionará como chave estrangeira, que faz referência à tabela da classe pai.


Por exemplo, se tivermos uma classe Animal como classe pai, e as classes Cachorro e Gato como sub-classes,
o mapeamento de herança JOINED irá gerar três tabelas no banco de dados: Animal (com os atributos da
classe pai), Cachorro (com os atributos adicionais da classe Cachorro e uma chave estrangeira referenciando
a tabela Animal) e Gato (com os atributos adicionais da classe Gato e uma chave estrangeira referenciando
a tabela Animal).

Essa estratégia é útil quando as sub-classes têm muitos atributos adicionais em relação à classe pai,
 e permite que o banco de dados seja organizado de forma mais eficiente.


...*/
