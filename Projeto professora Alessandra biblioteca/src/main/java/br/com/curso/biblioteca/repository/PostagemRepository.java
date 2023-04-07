package br.com.curso.biblioteca.repository;


import br.com.curso.biblioteca.entity.Livro;
import br.com.curso.biblioteca.entity.Postagem;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.sql.Date;
import java.util.List;


@Repository
public interface PostagemRepository extends JpaRepository<Postagem, Long> {


    public List<Postagem> findByPlataforma(Enum plataforma);

    public List<Postagem> findByConteudo(String conteudo);

    public Postagem findByUrl(String url);

    public List<Postagem> findByTitulo(String titulo);

    public List<Postagem> findByDataPublicacao(Date dataPublicacao);


}
