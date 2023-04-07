package br.com.curso.biblioteca.enums;

public enum PlataformaDigital {

    //Três constantes com e cada uma com dois atributos:
    SCIENCE("Science", "https://www.science.org/"),
    REVISTAS_USP("Revistas USP", "https://www.revistas.usp.br/wp/"),
    RBCMS("Revista Brasileira de Ciências Médicas e da Saúde", "http://www.rbcms.com.br/");

    private String descricao;

    private String url;

    private PlataformaDigital(String descricao, String url) {
        this.descricao = descricao;
        this.url = url;
    }

    public String getDescricao() {
        return descricao;
    }

    public String getUrl() {
        return url;
    }


}

/*
Esse é um exemplo de declaração de uma enumeração em Java. PlataformaDigital é o nome da enumeração,
e ela contém três constantes: SCIENCE, REVISTAS_USP e RBCMS. Cada constante é definida com um nome e dois atributos: descricao e url.

O construtor da enumeração é privado e é chamado apenas uma vez para cada constante no momento da inicialização da enumeração.
Cada constante tem um valor para descricao e url.

A enumeração também possui dois métodos: getDescricao() e getUrl(), que retornam o valor dos atributos descricao e url para cada constante.


------------------

Finalidade do enum:

Em Java, uma enumeração, ou simplesmente enum, é um tipo de dado especial que permite a criação de um conjunto fixo de
constantes nomeadas. A finalidade de uma enumeração é definir um conjunto de valores que são tratados como constantes
e que podem ser usados em um programa para representar conceitos específicos, sem a necessidade de usar variáveis ou constantes globais.

Uma enumeração permite que um conjunto de valores seja declarado de forma mais estruturada, organizada e com mais semântica.
Além disso, ela ajuda a prevenir erros de digitação e de tipo, uma vez que cada constante é declarada apenas uma vez e é tipada.

As enums podem ser usadas em diversas situações, como em estruturas de controle de fluxo, na definição de valores padrão para
parâmetros de métodos e em outras situações onde é necessário garantir que um conjunto de valores seja tratado de forma consistente
em todo programa.

 */
