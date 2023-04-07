package br.com.curso.biblioteca.entity;

import jakarta.persistence.Column;
import jakarta.persistence.MappedSuperclass;

import java.util.Date;

// Essa classe não tem anotação de tabela para ela.
//extends é relacionamento de herança

@MappedSuperclass //Estratégia de mapear herança no banco de dados sem ter que criar a tabela física
// no banco de dados.
public abstract class ObraFisica extends Obra {

    @Column(nullable = false)
    protected String codLocalizacao;

    //Construtor que o Framework irá utilizar no futuro

    public ObraFisica() {
    }

    // Os atributos de ObraFisica são os atributos dela mesma e os de Obra que são:
    // id, titulo, dataPublicacao, codLocalizacao.
    public ObraFisica(Long id, String titulo, Date dataPublicacao, String codLocalizacao) {
        super(id, titulo, dataPublicacao);//Construtores da Obra
        this.codLocalizacao = codLocalizacao;//Construtor desta classe ObraFisica
    }


    //Gerando apenas o get
        public String getCodLocalizacao () {

        return codLocalizacao;
        }
    }


    /*

A anotação @MappedSuperclass é usada em uma classe abstrata para indicar que ela é uma superclasse mapeada.

Isso significa que as classes que estendem essa classe abstrata irão herdar seus campos mapeados e, portanto,
não precisam definir esses campos novamente.

No contexto de mapeamento objeto-relacional (ORM), essa anotação é útil quando há um conjunto comum de
campos que devem ser mapeados em várias tabelas relacionais, mas que não precisam ser persistidos na tabela
correspondente à classe abstrata.

Dessa forma, a classe abstrata com a anotação @MappedSuperclass pode ser usada para definir os campos comuns,
enquanto as classes filhas podem estender essa classe abstrata e adicionar mais campos específicos.

Além disso, a anotação @MappedSuperclass não pode ser usada para criar uma tabela no banco de dados,
mas apenas para fornecer informações de mapeamento para as classes que a estendem

@Column

A anotação @Column(nullable = false) é usada para definir a propriedade de um campo na classe que será
mapeado para uma coluna em uma tabela no banco de dados.



No exemplo dado, a anotação está sendo usada para definir a coluna correspondente ao campo codLocalizacao.
O parâmetro nullable é definido como false, o que significa que o campo codLocalizacao é obrigatório
(ou seja, não pode ser nulo) quando os dados são inseridos ou atualizados no banco de dados.



Dessa forma, ao usar a anotação @Column(nullable = false), o desenvolvedor está especificando que o campo
codLocalizacao é obrigatório para cada registro na tabela correspondente à classe que contém essa anotação.
Caso um valor nulo seja inserido nesse campo durante a inserção ou atualização de dados no banco de dados,
uma exceção será lançada pelo sistema de persistência, indicando que um valor obrigatório foi omitido.


.....*/



