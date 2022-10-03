package br.com.projeto.biblioteca.projetobibliotecahiberanteangular.bus;

import br.com.projeto.biblioteca.projetobibliotecahiberanteangular.data.Categoria;
import br.com.projeto.biblioteca.projetobibliotecahiberanteangular.infra.HibernateUtil;
import jakarta.persistence.criteria.CriteriaBuilder;
import jakarta.persistence.criteria.CriteriaQuery;
import jakarta.persistence.criteria.Root;
import org.hibernate.HibernateException;
import org.hibernate.Session;

import java.util.List;

public class CategoriaDAO extends GenericDAO<Categoria>{

    @Override
    public Categoria selecionar(long id) {
        return (Categoria) HibernateUtil.getSessionFactory()
                .openSession()
                .get(Categoria.class, id);
    }

    @Override
    public List<Categoria> listar() {
        List<Categoria> listarCategoria = null;
        Session s = HibernateUtil.getSessionFactory().openSession();
        try{
            CriteriaBuilder builder = s.getCriteriaBuilder();
            CriteriaQuery<Categoria> criteriaQuery = builder.createQuery(Categoria.class);
            Root<Categoria> categoria = criteriaQuery.from(Categoria.class);
            criteriaQuery.select(builder.construct(Categoria.class, categoria.get("id"), categoria.get("nome")));
            listarCategoria = s.createQuery(criteriaQuery).getResultList();
        } catch(HibernateException e){
            e.printStackTrace();
        } finally {
            if (s != null){
                s.close();
            }
        }
        return listarCategoria;
    }
}
