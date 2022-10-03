package br.com.projeto.biblioteca.projetobibliotecahiberanteangular.data;

import jakarta.persistence.*;

import java.io.Serializable;
import java.util.Date;

@Entity
@Table
public class Autor implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_autor")
    private long id;

    @Column(name = "nome_autor")
    private String nome;

    @Temporal(TemporalType.TIMESTAMP)
    @Column(name = "data_nascimento")
    private Date dataNascimento;

    @ManyToOne
    @JoinColumn(name = "id_livro")
    private Livro livro;

    public Autor(){}

    public Autor(long id, String nome) {
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

    public Date getDataNascimento() {
        return dataNascimento;
    }

    public void setDataNascimento(Date dataNascimento) {
        this.dataNascimento = dataNascimento;
    }

    public Livro getLivro() {
        return livro;
    }

    public void setLivro(Livro livro) {
        this.livro = livro;
    }
}
