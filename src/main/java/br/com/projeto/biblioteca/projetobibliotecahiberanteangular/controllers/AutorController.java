package br.com.projeto.biblioteca.projetobibliotecahiberanteangular.controllers;

import br.com.projeto.biblioteca.projetobibliotecahiberanteangular.bus.AutorDAO;
import br.com.projeto.biblioteca.projetobibliotecahiberanteangular.data.Autor;

import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import java.sql.SQLException;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

@Path("autor")
public class AutorController {

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    @Path("/listar")
    public List<Autor> listarAutores() {
        try{
            AutorDAO autorDAO = new AutorDAO();
            return autorDAO.listar();
        } catch (Exception ex){
            Logger.getLogger(AutorController.class.getName()).log(Level.SEVERE, null, ex);
            throw new WebApplicationException(Response.Status.INTERNAL_SERVER_ERROR);
        }
    }

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    @Path("{id}/")
    public Autor getAutor(@PathParam("id") long id){
        try{
            AutorDAO autorDAO = new AutorDAO();
            return autorDAO.selecionar(id);
        } catch (Exception ex){
            Logger.getLogger(AutorController.class.getName()).log(Level.SEVERE, null, ex);
            throw new WebApplicationException(Response.Status.INTERNAL_SERVER_ERROR);
        }
    }

    @PUT
    @Consumes(MediaType.APPLICATION_JSON)
    @Path("/")
    public Response alterar(Autor autor){
        try {
            AutorDAO autorDAO = new AutorDAO();
            autorDAO.alterar(autor);
            return Response.status(Response.Status.OK).build();
        } catch (Exception ex){
            Logger.getLogger(AutorController.class.getName()).log(Level.SEVERE, null, ex);
            throw new WebApplicationException(Response.Status.INTERNAL_SERVER_ERROR);
        }
    }

    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    @Path("/novo")
    public Response criarAutor(Autor autor) throws SQLException, ClassNotFoundException {
        try{
            AutorDAO autorDAO = new AutorDAO();
            autorDAO.inserir(autor);
            return Response.status(Response.Status.OK).build();
        } catch (Exception ex){
            Logger.getLogger(AutorController.class.getName()).log(Level.SEVERE, null, ex);
            throw new WebApplicationException(Response.Status.INTERNAL_SERVER_ERROR);
        }

    }

    @DELETE
    @Path("{id}/")
    public Response deletarAutor(@PathParam("id") long id){
        try{
            AutorDAO autorDAO = new AutorDAO();
            autorDAO.excluir(id);
            return Response.status(Response.Status.OK).build();
        } catch (Exception ex){
            Logger.getLogger(AutorController.class.getName()).log(Level.SEVERE, null, ex);
            throw new WebApplicationException(Response.Status.INTERNAL_SERVER_ERROR);
        }
    }

}
