package br.com.curso.biblioteca.entity;

import jakarta.persistence.Column;
import jakarta.persistence.MappedSuperclass;
import java.util.Date;

//extends é relacionamento de herança

@MappedSuperclass //Estratégia de mapear herança no banco de dados sem ter que criar
// a tabela física  no banco de dados.
public class ObraDigital extends Obra {

    @Column(nullable = false)
    protected String url;

    public ObraDigital(){

    }

    // Construtor padrão que recebe três  parâmetros (id, título e data de publicação)
    public ObraDigital(long id, String titulo, Date dataPublicacao, String url){
        super(id, titulo, dataPublicacao);
        this.url = url;
    }

    public String getUrl(){
        return url;
    }

}

/*

Este é um exemplo de uma classe Java que é uma superclasse mapeada (@MappedSuperclass) que estende outra classe abstrata chamada Obra.

A classe ObraDigital representa um tipo específico de obra, no caso, uma obra digital. Ela tem um atributo url que representa a localização da obra digital.

A anotação @MappedSuperclass indica que essa classe é uma superclasse mapeada e que seus atributos serão mapeados para a tabela correspondente na classe que a estende.

No caso, a tabela correspondente será definida na classe que estende a ObraDigital.

A anotação @Column(nullable = false) é usada para definir que o atributo url é obrigatório e não pode ser nulo no banco de dados.

A classe ObraDigital possui um construtor padrão e um construtor que recebe três parâmetros (id, título e data de publicação) e passa esses valores para o construtor
da classe Obra, que é a classe abstrata da qual ObraDigital estende.

A classe ObraDigital também possui um método getUrl() que retorna o valor do atributo url.

Essa classe é um exemplo de como é possível usar a herança em Java para definir classes mais específicas e comuns, evitando a repetição de código.
Além disso, é possível usar as anotações para mapear as classes para o banco de dados e definir como os atributos devem
 ser persistidos.

 @Colum:

@Colum é uma anotação do Spring que pode ser usada para mapear um atributo de uma entidade para uma coluna em um banco
 de dados. Quando você usa a anotação @Column em um campo de uma classe de entidade, você pode especificar
  o nome da coluna do banco de dados à qual o campo deve ser mapeado.


 */
