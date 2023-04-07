package br.com.curso.biblioteca.repository;

import br.com.curso.biblioteca.entity.Emprestimo;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.query.Procedure;
import org.springframework.stereotype.Repository;

import java.sql.Date;
import java.util.ArrayList;
import java.util.List;




@Repository
public interface EmprestimoRepository  extends JpaRepository<Emprestimo, Long> {

    @Procedure(name = "atrasos")
    public Integer quantidadeEmAtraso();



    // Lógica para registrar que um usuário emprestou uma obra

    public static void emprestarObra(Long idUsuario, Long idObra, Date dataEmprestimo) {

    }

    // Lógica para registrar que um usuário devolveu uma obra
    public static void devolverObra(Long idUsuario, Long idObra, Date dataDevolucao) {

    }


    // Lógica para listar as obras que um usuário pegou emprestado

        // Adicione os IDs das obras emprestadas na lista obrasEmprestadas

    public default List<Long> listarObrasEmprestadas(Long idUsuario) {

        List<Long> obrasEmprestadas = new ArrayList<Long>();
        return obrasEmprestadas;
    }


    }

/*
Este código define uma interface de repositório chamada EmprestimoRepository que estende a interface JpaRepository do
Spring Data JPA para a entidade Emprestimo e define três métodos:

O método emprestarObra é um método estático que recebe os IDs de um usuário e uma obra, bem como uma data de empréstimo,
mas não tem corpo. Isso significa que ele não faz nada por si só. Provavelmente, ele foi adicionado por engano ou como um
esboço para uma futura implementação.

O método devolverObra é semelhante ao método emprestarObra, mas registra a data de devolução de uma obra em vez da data de
empréstimo. Novamente, este método não tem corpo e não faz nada por si só.

O método listarObrasEmprestadas é um método padrão que retorna uma lista vazia de Longs. Este método provavelmente deve
ser implementado para retornar uma lista dos IDs das obras que um determinado usuário pegou emprestado. Atualmente,
ele não faz nada e sempre retorna uma lista vazia.

Além disso, a anotação @Repository

é usada para indicar que essa interface é um componente do Spring que gerencia a
persistência de dados e se comunica com o banco de dados. A interface é configurada para trabalhar com a entidade Emprestimo
e usa o Spring Data JPA para fornecer operações CRUD padrão e outras funcionalidades de acesso a dados.

 */

