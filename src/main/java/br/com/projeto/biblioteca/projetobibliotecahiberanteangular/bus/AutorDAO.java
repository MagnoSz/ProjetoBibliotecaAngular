package br.com.projeto.biblioteca.projetobibliotecahiberanteangular.bus;

import br.com.projeto.biblioteca.projetobibliotecahiberanteangular.data.Autor;
import br.com.projeto.biblioteca.projetobibliotecahiberanteangular.infra.HibernateUtil;
import jakarta.persistence.criteria.CriteriaBuilder;
import jakarta.persistence.criteria.CriteriaQuery;
import jakarta.persistence.criteria.Root;
import org.hibernate.HibernateException;
import org.hibernate.Session;

import java.util.List;

public class AutorDAO extends GenericDAO<Autor> {

    @Override
    public Autor selecionar(long id) {
        return (Autor) HibernateUtil.getSessionFactory()
                .openSession()
                .get(Autor.class, id);
    }

    @Override
    public List<Autor> listar() {
        List<Autor> listarLivros = null;
        Session s = HibernateUtil.getSessionFactory().openSession();
        try{
            CriteriaBuilder builder = s.getCriteriaBuilder();
            CriteriaQuery<Autor> criteriaQuery = builder.createQuery(Autor.class);
            Root<Autor> autor = criteriaQuery.from(Autor.class);
        criteriaQuery.select(builder.construct(Autor.class, autor.get("id"), autor.get("nome")));
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
