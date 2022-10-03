package br.com.projeto.biblioteca.projetobibliotecahiberanteangular.bus;

import br.com.projeto.biblioteca.projetobibliotecahiberanteangular.infra.HibernateUtil;
import org.hibernate.Session;
import org.hibernate.Transaction;

import java.util.List;

public abstract class GenericDAO <Classe>{

    public void inserir(Classe classe) {
        Session s = HibernateUtil.getSessionFactory().openSession();
        Transaction t = s.beginTransaction();
        s.save(classe);
        t.commit();
    }

    public void alterar(Classe classe) {
        Session s = HibernateUtil.getSessionFactory().openSession();
        Transaction t = s.beginTransaction();
        s.merge(classe);
        t.commit();
    }

    public void excluir(long id) {
        Session s = HibernateUtil.getSessionFactory().openSession();
        Classe c = selecionar(id);

        Transaction t = s.beginTransaction();
        s.delete(c);
        t.commit();
    }

    public abstract Classe selecionar(long id);

    public abstract List<Classe> listar();

}
