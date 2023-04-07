package br.com.curso.biblioteca.repository;

import br.com.curso.biblioteca.entity.Revista;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.sql.Date;
import java.util.List;


@Repository
public interface RevistaRepository extends JpaRepository<Revista, Long>{


    //O método "findById" já é fornecido pela interface "JpaRepository",
    // portanto não é necessário declará-lo novamente aqui.


    // Explicação no final dessa classe:
    @Query("SELECT r FROM Revista r WHERE r.codLocalizacao LIKE 'BR%'")
    public List<Revista> findByCodLocalizacaoBrasil();

    public List<Revista> findByCodLocalizacao(String codLocalizacao);


   // public List<Revista> findById(Long id);

    public List<Revista> findByNumero(Integer numero);

    public List<Revista> findByTitulo(String titulo);

    public List<Revista> findByDataPublicacao(Date dataPublicacao);



}

/*

@Query("SELECT r FROM Revista r WHERE r.codLocalizacao LIKE 'BR%'")
    public List<Revista> findByCodLocalizacaoBrasil();


Esta consulta SQL personalizada seleciona todos os objetos "Revista" onde o código de
localização começa com "BR" (que é o código ISO do Brasil) usando a cláusula "LIKE"
e retorna uma lista de objetos "Revista". Note que o nome do método findByCodLocalizacaoBrasil
não precisa incluir o parâmetro codLocalizacao porque a consulta já está definida com o filtro
 específico para o Brasil.



Ao chamar este método em uma instância da classe "RevistaRepository", ele irá retornar uma
lista de todas as revistas que têm um código de localização começando com "BR", ou seja,
 as revistas com localização no Brasil.



 */
