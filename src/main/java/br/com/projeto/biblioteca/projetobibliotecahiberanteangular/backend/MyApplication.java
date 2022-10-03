package br.com.projeto.biblioteca.projetobibliotecahiberanteangular.backend;

import org.glassfish.jersey.server.ResourceConfig;

import javax.ws.rs.ApplicationPath;

@ApplicationPath("rest")
public class MyApplication extends ResourceConfig {
    public MyApplication(){
        packages("br.com.projeto.biblioteca.data");
    }
}