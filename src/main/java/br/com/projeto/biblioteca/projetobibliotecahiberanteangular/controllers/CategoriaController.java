package br.com.projeto.biblioteca.projetobibliotecahiberanteangular.controllers;



import br.com.projeto.biblioteca.projetobibliotecahiberanteangular.bus.CategoriaDAO;
import br.com.projeto.biblioteca.projetobibliotecahiberanteangular.data.Categoria;

import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import java.sql.SQLException;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

@Path("categorias")
public class CategoriaController {

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    @Path("/listar")
    public List<Categoria> listarCategorias() {
        try{
            CategoriaDAO categoriaDAO = new CategoriaDAO();
            return categoriaDAO.listar();
        } catch (Exception ex){
            Logger.getLogger(CategoriaController.class.getName()).log(Level.SEVERE, null, ex);
            throw new WebApplicationException(Response.Status.INTERNAL_SERVER_ERROR);
        }
    }

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    @Path("{id}/")
    public Categoria getCategoria(@PathParam("id") long id){
        try{
            CategoriaDAO categoriaDAO = new CategoriaDAO();
            return categoriaDAO.selecionar(id);
        } catch (Exception ex){
            Logger.getLogger(CategoriaController.class.getName()).log(Level.SEVERE, null, ex);
            throw new WebApplicationException(Response.Status.INTERNAL_SERVER_ERROR);
        }
    }

    @PUT
    @Consumes(MediaType.APPLICATION_JSON)
    @Path("/")
    public Response alterar(Categoria categoria){
        try {
            CategoriaDAO categoriaDAO = new CategoriaDAO();
            categoriaDAO.alterar(categoria);
            return Response.status(Response.Status.OK).build();
        } catch (Exception ex){
            Logger.getLogger(CategoriaController.class.getName()).log(Level.SEVERE, null, ex);
            throw new WebApplicationException(Response.Status.INTERNAL_SERVER_ERROR);
        }
    }

    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    @Path("/novo")
    public Response criarCategoria(Categoria categoria) throws SQLException, ClassNotFoundException {
        try{
            CategoriaDAO categoriaDAO = new CategoriaDAO();
            categoriaDAO.inserir(categoria);
            return Response.status(Response.Status.OK).build();
        } catch (Exception ex){
            Logger.getLogger(CategoriaController.class.getName()).log(Level.SEVERE, null, ex);
            throw new WebApplicationException(Response.Status.INTERNAL_SERVER_ERROR);
        }

    }

    @DELETE
    @Path("{id}/")
    public Response deletarCategoria(@PathParam("id") long id){
        try{
            CategoriaDAO categoriaDAO = new CategoriaDAO();
            categoriaDAO.excluir(id);
            return Response.status(Response.Status.OK).build();
        } catch (Exception ex){
            Logger.getLogger(CategoriaController.class.getName()).log(Level.SEVERE, null, ex);
            throw new WebApplicationException(Response.Status.INTERNAL_SERVER_ERROR);
        }
    }

}