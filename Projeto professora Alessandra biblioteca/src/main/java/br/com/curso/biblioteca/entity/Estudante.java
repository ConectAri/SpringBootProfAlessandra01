package br.com.curso.biblioteca.entity;


//extends é relacionamento de herança


import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.PrimaryKeyJoinColumn;
import jakarta.persistence.Table;

@Entity
@Table(name = "TB_ESTUDANTE")
@PrimaryKeyJoinColumn(name = "idUsuario")// Para mostrar que o id vem de usuário e ficou idUsuario
public class Estudante extends Usuario {

    @Column(nullable = false)
    private String matricula;

    public Estudante() {

    }

    public Estudante(Long id, String nome, String rg, String email, String matricula) {
        super(id, nome, rg, email);
        this.matricula = matricula;
    }

    public String getMatricula(){
        return matricula;
    }
}
