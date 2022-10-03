package br.com.projeto.biblioteca.projetobibliotecahiberanteangular.controllers;


import br.com.projeto.biblioteca.projetobibliotecahiberanteangular.bus.LivroDAO;
import br.com.projeto.biblioteca.projetobibliotecahiberanteangular.data.Livro;

import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import java.sql.SQLException;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

@Path("livro")
public class LivroController {

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    @Path("/listar")
    public List<Livro> listarLivros() {
        try{
            LivroDAO livroDAO = new LivroDAO();
            return livroDAO.listar();
        } catch (Exception ex){
            Logger.getLogger(EditoraController.class.getName()).log(Level.SEVERE, null, ex);
            throw new WebApplicationException(Response.Status.INTERNAL_SERVER_ERROR);
        }
    }

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    @Path("{id}/")
    public Livro getLivro(@PathParam("id") long id){
        try{
            LivroDAO livroDAO = new LivroDAO();
            return livroDAO.selecionar(id);
        } catch (Exception ex){
            Logger.getLogger(EditoraController.class.getName()).log(Level.SEVERE, null, ex);
            throw new WebApplicationException(Response.Status.INTERNAL_SERVER_ERROR);
        }
    }

    @PUT
    @Consumes(MediaType.APPLICATION_JSON)
    @Path("/")
    public Response alterar(Livro livro){
        try {
            LivroDAO livroDAO = new LivroDAO();
            livroDAO.alterar(livro);
            return Response.status(Response.Status.OK).build();
        } catch (Exception ex){
            Logger.getLogger(EditoraController.class.getName()).log(Level.SEVERE, null, ex);
            throw new WebApplicationException(Response.Status.INTERNAL_SERVER_ERROR);
        }
    }

    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    @Path("/novo")
    public Response criarLivro(Livro livro) throws SQLException, ClassNotFoundException {
        try{
            LivroDAO livroDAO = new LivroDAO();
            livroDAO.inserir(livro);
            return Response.status(Response.Status.OK).build();
        } catch (Exception ex){
            Logger.getLogger(EditoraController.class.getName()).log(Level.SEVERE, null, ex);
            throw new WebApplicationException(Response.Status.INTERNAL_SERVER_ERROR);
        }

    }

    @DELETE
    @Path("{id}/")
    public Response deletarLivro(@PathParam("id") long id){
        try{
            LivroDAO livroDAO = new LivroDAO();
            livroDAO.excluir(id);
            return Response.status(Response.Status.OK).build();
        } catch (Exception ex){
            Logger.getLogger(EditoraController.class.getName()).log(Level.SEVERE, null, ex);
            throw new WebApplicationException(Response.Status.INTERNAL_SERVER_ERROR);
        }
    }

}
