package br.com.projeto.biblioteca.projetobibliotecahiberanteangular.bus;

import br.com.projeto.biblioteca.projetobibliotecahiberanteangular.data.Editora;
import br.com.projeto.biblioteca.projetobibliotecahiberanteangular.infra.HibernateUtil;
import jakarta.persistence.criteria.CriteriaBuilder;
import jakarta.persistence.criteria.CriteriaQuery;
import jakarta.persistence.criteria.Root;
import org.hibernate.HibernateException;
import org.hibernate.Session;

import java.util.List;

public class EditoraDAO extends GenericDAO<Editora>{

    @Override
    public Editora selecionar(long id) {
        return (Editora) HibernateUtil.getSessionFactory()
                .openSession()
                .get(Editora.class, id);
    }

    @Override
    public List<Editora> listar() {
        List<Editora> listarEditoras = null;
        Session s = HibernateUtil.getSessionFactory().openSession();
        try{
            CriteriaBuilder builder = s.getCriteriaBuilder();
            CriteriaQuery<Editora> criteriaQuery = builder.createQuery(Editora.class);
            Root<Editora> editora = criteriaQuery.from(Editora.class);
            criteriaQuery.select(builder.construct(Editora.class, editora.get("id"), editora.get("nome"), editora.get("cnpj"), editora.get("cidade"), editora.get("estado")));
            listarEditoras = s.createQuery(criteriaQuery).getResultList();
        } catch(HibernateException e){
            e.printStackTrace();
        } finally {
            if (s != null){
                s.close();
            }
        }
        return listarEditoras;
    }
}
