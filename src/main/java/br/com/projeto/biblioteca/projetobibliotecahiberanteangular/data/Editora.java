package br.com.projeto.biblioteca.projetobibliotecahiberanteangular.data;

import jakarta.persistence.*;

import java.io.Serializable;
import java.util.List;

@Entity
@Table
public class Editora implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_editora")
    private long id;

    @Column(name = "nome_editora")
    private String nome;

    @Column(name = "cidade_editora")
    private String cidade;

    @Column(name = "estado_editora")
    private String estado;

    @Column(name = "cnpj_editora")
    private String cnpj;

    @OneToMany
    @JoinColumn(name = "id_livro")
    private List<Livro> livros;

    public Editora(){}

    public Editora(long id, String nome, String cidade, String estado, String cnpj) {
        this.id = id;
        this.nome = nome;
        this.cidade = cidade;
        this.estado = estado;
        this.cnpj = cnpj;
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

    public String getCidade() {
        return cidade;
    }

    public void setCidade(String cidade) {
        this.cidade = cidade;
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }

    public List<Livro> getLivros() {
        return livros;
    }

    public void setLivros(List<Livro> livros) {
        this.livros = livros;
    }

    public String getCnpj() {
        return cnpj;
    }

    public void setCnpj(String cnpj) {
        this.cnpj = cnpj;
    }
}
