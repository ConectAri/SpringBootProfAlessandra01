package br.com.curso.biblioteca.entity;



import jakarta.persistence.*;

import java.util.Date;


//@Entity  É uma anotação do JPA, para demonstrar que é uma entidade(tabela) que será
//persistida no banco de dados e será mapeada pela classe empréstimo.
//@Table, por sua vez, permite definir o nome
// da tabela que será mapeada pela classe.



    @Entity
    @Table(name = "TB_EMPRESTIMO")

   @NamedStoredProcedureQueries(
            name = "atrasos",
            procedureName = "proc_qtde_emprestimos_em_atraso",
            parameters = {
                    @StoredProcedureParameter(
                            mode = ParameterMode.OUT,
                            name = "quantidade",
                            type = Integer.class)
            })


    public class Emprestimo {

        @Id  //Obrigatório
        @GeneratedValue(strategy = GenerationType.IDENTITY) //Não é obrigatório mas 99% é utilizado
        private Long id;

        @Column(nullable = false) //Facultativo
        @Temporal(TemporalType.TIMESTAMP)
        private Date date;


        //NÃO SE PODE TER A MESMA UNIDADE(OBRA) PARA PESSOAS DIFERENTES E O
        // EMPRÉSTIMO É DE UMA OBRA(UNIDADE) POR ISSO OneToOne
        //Neste relacionamento é fundamental o empréstimo saber qual a obra
        @OneToOne
        @JoinColumn(name = "idObra", referencedColumnName = "id")//Relacionamento entre as colunas..tabela interligada
        private Obra obra;

        @ManyToOne //Podem haver muitos empréstimos para UM mesmo usuário
        @JoinColumn(name = "idUsuario", referencedColumnName = "id")
        private Usuario usuario;

        public Emprestimo() {

        }

        public Emprestimo(Long id, Date date, Usuario usuario, Obra obra) {
            super();
            this.id = id;
            this.date = date;
            this.usuario = usuario;
            this.obra = obra;
        }

        public Long getId() {
            return id;
        }

        public Date getData() {
            return date;
        }

        public Usuario getUsuario() {
            return usuario;
        }

        public Obra getObra() {
            return obra;
        }

    }





/*

No exemplo apresentado, a anotação @Table foi utilizada em conjunto com a anotação @Entity para especificar o nome
da tabela no banco de dados que será mapeada pela classe Emprestimo.

A anotação @Entity indica que a classe é uma entidade JPA (Java Persistence API), ou seja,
ela representa uma tabela no banco de dados. A anotação @Table, por sua vez, permite definir o nome da tabela que será
mapeada pela classe.

Caso não seja utilizada a anotação @Table, o JPA assumirá que o nome da tabela será igual ao nome da classe, em letras minúsculas.

Além disso, a anotação @Table também pode ser usada para definir outras propriedades da tabela, como o schema (banco de dados)
onde ela está localizada, o índice da tabela, o nome do catálogo e outras propriedades específicas do banco de dados.


 a anotação @Id indica que o atributo id é a chave primária da entidade Emprestimo. Essa anotação é utilizada para indicar
 ao JPA que o atributo deve ser mapeado para a coluna que representa a chave primária da tabela correspondente à entidade.

A anotação @GeneratedValue, por sua vez, é utilizada em conjunto com a anotação @Id para indicar ao JPA como gerar valores únicos
para a chave primária da entidade. Nesse caso, a estratégia de geração de valores únicos utilizada é a GenerationType.IDENTITY,
que significa que a chave primária será gerada automaticamente pelo banco de dados, no momento em que uma nova instância da entidade
Emprestimo for persistida.

Essa estratégia é muito comum em bancos de dados que suportam a geração automática de valores para colunas do tipo IDENTITY
(como o MySQL, PostgreSQL, etc.), já que elimina a necessidade de gerar valores únicos para a chave primária na aplicação.
Dessa forma, o banco de dados assume a responsabilidade de gerenciar a geração de valores únicos para a chave primária,
tornando o processo de persistência de entidades mais simples e eficiente.


Explicando:

 @OneToOne
 @JoinColumn(name = "idObra", referencedColumnName = "id")
 private Obra obra;

O código @OneToOne @JoinColumn(name = "idObra", referencedColumnName = "id")
private Obra obra; é usado para criar um relacionamento de um-para-um (1:1) entre
a classe atual e a classe Obra. Isso significa que cada objeto da classe atual será associado
a um único objeto da classe Obra e vice-versa.

A anotação @OneToOne é usada para indicar que a relação é de um-para-um (1:1).


A anotação @JoinColumn(name = "idObra", referencedColumnName = "id") é usada para indicar
que a coluna de junção (join column) entre as tabelas da classe atual e da classe Obra será
a coluna idObra na tabela da classe atual e a coluna id na tabela da classe Obra. Essa coluna
de junção é usada para estabelecer a relação entre as tabelas das classes relacionadas.


Por fim, a propriedade private Obra obra; é usada para definir um atributo na classe atual
que representa a classe Obra no relacionamento um-para-um (1:1). Esse atributo será mapeado
para a coluna idObra na tabela da classe atual, que faz referência à coluna id na tabela da
classe Obra. Dessa forma, quando um objeto da classe atual é persistido no banco de dados,
ele estará associado a um único objeto da classe Obra, que pode ser acessado por meio do
atributo obra.


@Colum:

@Colum é uma anotação do Spring que pode ser usada para mapear um atributo de uma entidade para uma coluna em um banco
 de dados. Quando você usa a anotação @Column em um campo de uma classe de entidade, você pode especificar
  o nome da coluna do banco de dados à qual o campo deve ser mapeado.


.....*/


