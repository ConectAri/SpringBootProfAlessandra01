package br.com.curso.biblioteca.repository;

import br.com.curso.biblioteca.entity.Estudante;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;


@Repository
public interface EstudanteRepository extends JpaRepository<Estudante, Long> {

    // Procurando um nome por ordem alfabética
    @Query("SELECT e FROM Estudante e ORDER BY e.nome ASC")
    public List<Estudante> findAllOrderByNomeAsc();



    // Buscando o estudante a partir do número do RG
    public Estudante findByRg(String rg);



    // Buscando o estudante a partir da matrícula
    public Estudante findByMatricula(String matricula);


    // Buscando uma lista de estudante cujo e-mail contenha a string passada como parâmetro
    // ou cujo nome contenha a string passada como parâmetro.
    @Query ("FROM Estudante e WHERE e.email LIKE %:email% or e.nome LIKE %:nome%")
    public List<Estudante> findByEmailOuNome(String email, String nome);

}
