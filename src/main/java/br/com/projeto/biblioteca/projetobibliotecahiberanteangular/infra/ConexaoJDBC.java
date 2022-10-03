package br.com.projeto.biblioteca.projetobibliotecahiberanteangular.infra;

import java.sql.Connection;
import java.sql.SQLException;

public interface ConexaoJDBC {

    public Connection getConnection();

    public void close() throws SQLException;

    public void commit() throws SQLException;

    public void rollback() throws SQLException;

}
