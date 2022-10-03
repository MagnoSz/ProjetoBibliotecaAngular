package br.com.projeto.biblioteca.projetobibliotecahiberanteangular.bus;

import br.com.projeto.biblioteca.projetobibliotecahiberanteangular.data.Livro;
import br.com.projeto.biblioteca.projetobibliotecahiberanteangular.infra.HibernateUtil;
import jakarta.persistence.criteria.CriteriaBuilder;
import jakarta.persistence.criteria.CriteriaQuery;
import jakarta.persistence.criteria.Root;
import org.hibernate.HibernateException;
import org.hibernate.Session;

import java.util.List;

public class LivroDAO extends GenericDAO<Livro>{


    @Override
    public Livro selecionar(long id) {
        return (Livro) HibernateUtil.getSessionFactory()
                .openSession()
                .get(Livro.class, id);
    }

    @Override
    public List<Livro> listar() {
        List<Livro> listarLivros = null;
        Session s = HibernateUtil.getSessionFactory().openSession();
        try{
            CriteriaBuilder builder = s.getCriteriaBuilder();
            CriteriaQuery<Livro> criteriaQuery = builder.createQuery(Livro.class);
            Root<Livro> livro = criteriaQuery.from(Livro.class);
            criteriaQuery.select(builder.construct(Livro.class, livro.get("id"), livro.get("nome")));
            listarLivros = s.createQuery(criteriaQuery).getResultList();
        } catch(HibernateException e){
            e.printStackTrace();
        } finally {
            if (s != null){
                s.close();
            }
        }
        return listarLivros;
    }
}
