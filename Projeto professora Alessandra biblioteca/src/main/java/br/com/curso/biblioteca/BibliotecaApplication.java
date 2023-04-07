package br.com.curso.biblioteca;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.Optional;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import br.com.curso.biblioteca.entity.Livro;
import br.com.curso.biblioteca.exception.LivroNaoEncontradoException;
import br.com.curso.biblioteca.repository.LivroRepository;


@SpringBootApplication
public class BibliotecaApplication {

	public static final Logger log = LoggerFactory.getLogger(BibliotecaApplication.class);
	//Classe de logger registra no console as saídas de teste

	public static void main(String[] args) {
		SpringApplication.run(BibliotecaApplication.class, args);
	}

	@Bean
	public CommandLineRunner executar(LivroRepository livroRepository) {
		return(args) -> {

			//1 - Apaga todos os livros do repositório
			// (Toda vez que inicia a execução, apaga no banco de dados o que estava anteriomente e por isso
			// o delete está no início, criado aqui para não dar conflito
			livroRepository.deleteAll();

			// 2 - Cria dois objetos "Livro" com informações de título, autor, localização, ISBN e data de publicação.

			String titulo = "Dom Casmurro";
			String autor = "Machado de Assis";
			String codLocalizacao = "ABC123";
			String isbn = "123456789";
			Date dataPublicacao = (new SimpleDateFormat("dd/MM/yyyy")).parse("12/03/1879");
			// SimpleDateFormat Classe que serve para formatar data, ANOTAÇÕES MAIORES NO FINAL DESSA CLASSE
			// A ideia é colocar o padrão que eu desejo que saia a formatação

			String titulo1 = "O diário de Anne Frank";
			String autor1 = "Anne Frank";
			String codLocalizacao1 = "XYZ456";
			String isbn1 = "987654321";
			Date dataPublicacao1 = (new SimpleDateFormat("dd/MM/yyyy")).parse("03/12/1877");


			// 3 - Salva os livros no repositório.
			// Aqui está null porque o sistema irá gerar um ID
			Livro livro = new Livro(null, titulo, dataPublicacao, codLocalizacao, autor, isbn);
			Livro livro1 = new Livro(null, titulo1, dataPublicacao1, codLocalizacao1, autor1, isbn1);
			livro = livroRepository.save(livro);
			livro1 = livroRepository.save(livro1);



			// 4 - Imprime informações sobre os livros cadastrados.

			log.info("Livros cadastrados");
			log.info(livro.toString());
			log.info(livro1.toString());

			//  5 - Pesquisa um livro pelo ISBN e imprime informações sobre o livro.
			log.info("Pesquisando um livro pelo ISBN...");
			livro = livroRepository.findByIsbn(isbn);
			log.info(livro.toString());


			// 6 - Pesquisa a quantidade de anos que um livro foi publicado a partir do seu ID e imprime a informação.

			log.info("Pesquisar a quantos anos um livro foi publicado...");
			Integer anosPublicacao = livroRepository.quantosAnosPublicacaoLivro(livro.getId());
			log.info("O livro '" + livro.getTitulo() + "' foi publicado a " + anosPublicacao + " anos.");

			// 7 - Pesquisa todos os livros ordenados por título e imprime as informações.

			log.info("Pesquisar livros ordenados por titulo...");
			List<Livro> livros = livroRepository.buscaTodosOrdenadosTitulo();
			log.info(livros.toString());

			// 8 - Pesquisa todos os livros ordenados por autor e imprime as informações.

			log.info("Pesquisar livros ordenados por autor...");
			livros = livroRepository.buscaTodosOrdenadosAutor();
			log.info(livros.toString());

			// 9 - Pesquisa o título do livro mais antigo e imprime a informação.

			log.info("Pesquisar o título do livro mais antigo...");
			String tituloMaisAntigo = livroRepository.buscaMaisAntigo();
			log.info("O livro '" + tituloMaisAntigo + "' é o mais antigo.");


			// 10 - Atualiza o ISBN de um livro e imprime as informações atualizadas.

			log.info("Atualizando o ISBN de um livro...");
			livroRepository.atualizaIsbnLivro(livro.getId(), "XXX");
			Optional<Livro> optLivro = livroRepository.findById(livro.getId());
			if (optLivro.isPresent()) {
				log.info(optLivro.get().toString());
			} else {
				throw new LivroNaoEncontradoException();
			}

			// 11 - Apaga um livro do repositório e imprime uma mensagem de confirmação.

			log.info("Apagando um livro...");
			livroRepository.apagaLivro(livro1.getId());
			optLivro = livroRepository.findById(livro1.getId());
			if (optLivro.isEmpty()) {
				log.info("Livro removido com sucesso.");
			}

		};
	}

}

/*
O que significa:

	public static final Logger log = LoggerFactory.getLogger(BibliotecaApplication.class);

Esse código define um objeto logger para a aplicação "BibliotecaApplication" usando a
biblioteca de log "SLF4J".

O logger é uma classe de registro que é usada para registrar informações relevantes
durante a execução do programa. É uma ferramenta importante para depurar e encontrar
erros em um programa.

O objeto logger é criado com a classe LoggerFactory, que é responsável por instanciar
objetos logger. O método getLogger recebe como parâmetro o nome da classe que está
sendo registrada.

A declaração "public static final" indica que o objeto logger é uma variável pública,
estática e constante. A constante é definida como "log" e seu tipo é a classe Logger.

Com esse objeto logger definido, é possível usar os métodos disponíveis na classe
Logger para registrar informações, tais como mensagens de log de depuração, informações,
avisos e erros. Essas mensagens podem ser usadas para acompanhar o fluxo da execução do
programa e para identificar problemas e erros durante a execução.

---------------------
RESUMO DE TODA CLASSE:

O código é a classe principal de uma aplicação Spring Boot chamada "BibliotecaApplication".
Ele contém um método "main" que inicia a aplicação Spring Boot e um método "executar" que é um "CommandLineRunner" responsável
por executar uma série de operações de teste com o repositório de livros da biblioteca.

O método "executar" utiliza o repositório de livros ("LivroRepository") injetado como parâmetro através do método "executar"
para realizar as seguintes operações:

1 - Apaga todos os livros do repositório
2 - Cria dois objetos "Livro" com informações de título, autor, localização, ISBN e data de publicação.
3 - Salva os livros no repositório.
4 - Imprime informações sobre os livros cadastrados.
5 - Pesquisa um livro pelo ISBN e imprime informações sobre o livro.
6 - Pesquisa a quantidade de anos que um livro foi publicado a partir do seu ID e imprime a informação.
7 - Pesquisa todos os livros ordenados por título e imprime as informações.
8 - Pesquisa todos os livros ordenados por autor e imprime as informações.
9 - Pesquisa o título do livro mais antigo e imprime a informação.
10 - Atualiza o ISBN de um livro e imprime as informações atualizadas.
11 - Apaga um livro do repositório e imprime uma mensagem de confirmação.

O logger é utilizado para registrar as informações de cada operação executada e é definido como uma variável estática na classe
com o nome "log". Ele é criado utilizando a biblioteca "slf4j" e é configurado para registrar as informações no console.
---------------------------

@BEan:

O @Bean é uma anotação utilizada em uma classe para indicar que um método específico dessa classe deve ser registrado
como um bean gerenciado pelo container do Spring.

Quando o Spring Framework inicia, ele verifica todas as classes anotadas com @Configuration e executa todos os métodos anotados
com @Bean dessas classes. Esses métodos são usados para criar e configurar instâncias de objetos que podem ser injetados em
outras partes do aplicativo que precisam deles.

Assim, a finalidade do @Bean é permitir que o Spring Framework gerencie a criação e configuração de objetos que são necessários
para o funcionamento de um aplicativo Spring. Ele ajuda a tornar o código mais modular e fácil de manter, permitindo que objetos
complexos sejam configurados em um só lugar e injetados em outras partes do código quando necessário.

---------------------

SimpleDateFormat

SimpleDateFormat é uma classe em Java que permite a formatação e análise de datas. Ela permite criar
um objeto de formatação de data personalizado com base em um padrão de string. Esse objeto pode então
ser usado para formatar datas em strings ou analisar strings em datas.

Por exemplo, o seguinte código cria um objeto SimpleDateFormat que
formata uma data no formato "dd/MM/yyyy":

SimpleDateFormat formatter = new SimpleDateFormat("dd/MM/yyyy");
Date date = formatter.parse("01/01/2022");
String formattedDate = formatter.format(date); // "01/01/2022"

O método parse analisa a string "01/01/2022" e retorna um objeto Date, enquanto o
método format formata a data de volta em uma string. O objeto formatter pode ser reutilizado para
formatar ou analisar outras datas com o mesmo padrão.


 */
