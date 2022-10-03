package br.com.projeto.biblioteca.projetobibliotecahiberanteangular.data;

import jakarta.persistence.*;

import java.io.Serializable;

@Entity
@Table
public class Categoria implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_categoria")
    private long id;

    @Column(name = "nome_categoria")
    private String nome;

    public Categoria(){}

    public Categoria(long id, String nome) {
        this.id = id;
        this.nome = nome;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

}

