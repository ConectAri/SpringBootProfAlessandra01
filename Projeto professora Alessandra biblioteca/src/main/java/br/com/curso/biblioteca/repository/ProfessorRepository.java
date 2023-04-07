package br.com.curso.biblioteca.repository;

import br.com.curso.biblioteca.entity.Professor;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface ProfessorRepository extends JpaRepository<Professor, Long> {

    public List<Professor> findByTitulacao(String titulacao);

    public Professor findByEmail(String email);


    // Faz busca de registros que contenham os
    //caracteres fornecidos no nome ou no RG.
    @Query("FROM Professor p WHERE p.nome LIKE %:nome% OR p.rg LIKE %:rg%")
    public List<Professor> findByNomeOuRG(String nome, String rg);



}


/*

Esse código é uma consulta JPQL (Java Persistence Query Language) que busca na entidade
"Professor" todos os registros que correspondem a um nome ou RG fornecido como parâmetro.

A consulta utiliza o operador "LIKE" para realizar a busca de registros que contenham os
caracteres fornecidos no nome ou no RG.

O símbolo "%" é usado como um caractere curinga para representar qualquer número de caracteres
desconhecidos antes ou depois do padrão de busca. Por exemplo, se o parâmetro "nome" for "João",
a consulta retornará todos os registros de professores que possuem a palavra "João" em algum lugar do nome.

A consulta é executada pela camada de persistência do aplicativo e retorna uma lista de objetos
Professor que correspondem aos critérios de busca especificados.







 */