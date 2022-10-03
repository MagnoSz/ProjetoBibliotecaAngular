package br.com.projeto.biblioteca.projetobibliotecahiberanteangular.controllers;


import br.com.projeto.biblioteca.projetobibliotecahiberanteangular.bus.EditoraDAO;
import br.com.projeto.biblioteca.projetobibliotecahiberanteangular.data.Editora;

import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import java.sql.SQLException;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

@Path("editora")
public class EditoraController {

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    @Path("/listar")
    public List<Editora> listarEditoras() {
        try{
            EditoraDAO editoraDAO = new EditoraDAO();
            return editoraDAO.listar();
        } catch (Exception ex){
            Logger.getLogger(EditoraController.class.getName()).log(Level.SEVERE, null, ex);
            throw new WebApplicationException(Response.Status.INTERNAL_SERVER_ERROR);
        }
    }

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    @Path("{id}/")
    public Editora getEditora(@PathParam("id") long id){
        try{
            EditoraDAO editoraDAO = new EditoraDAO();
            return editoraDAO.selecionar(id);
        } catch (Exception ex){
            Logger.getLogger(EditoraController.class.getName()).log(Level.SEVERE, null, ex);
            throw new WebApplicationException(Response.Status.INTERNAL_SERVER_ERROR);
        }
    }

    @PUT
    @Consumes(MediaType.APPLICATION_JSON)
    @Path("/")
    public Response alterar(Editora editora){
        try {
            EditoraDAO editoraDAO = new EditoraDAO();
            editoraDAO.alterar(editora);
            return Response.status(Response.Status.OK).build();
        } catch (Exception ex){
            Logger.getLogger(EditoraController.class.getName()).log(Level.SEVERE, null, ex);
            throw new WebApplicationException(Response.Status.INTERNAL_SERVER_ERROR);
        }
    }

    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    @Path("/novo")
    public Response criarEditora(Editora editora) throws SQLException, ClassNotFoundException {
        try{
            EditoraDAO editoraDAO = new EditoraDAO();
            editoraDAO.inserir(editora);
            return Response.status(Response.Status.OK).build();
        } catch (Exception ex){
            Logger.getLogger(EditoraController.class.getName()).log(Level.SEVERE, null, ex);
            throw new WebApplicationException(Response.Status.INTERNAL_SERVER_ERROR);
        }

    }

    @DELETE
    @Path("{id}/")
    public Response deletarEditora(@PathParam("id") long id){
        try{
            EditoraDAO editoraDAO = new EditoraDAO();
            editoraDAO.excluir(id);
            return Response.status(Response.Status.OK).build();
        } catch (Exception ex){
            Logger.getLogger(EditoraController.class.getName()).log(Level.SEVERE, null, ex);
            throw new WebApplicationException(Response.Status.INTERNAL_SERVER_ERROR);
        }
    }

}
