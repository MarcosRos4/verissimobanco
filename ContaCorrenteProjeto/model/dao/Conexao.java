package ContaCorrenteProjeto.model.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
public class Conexao {
    private Connection con = null;
    private Statement stm  = null;
    private ResultSet result = null;
    
    public Conexao() {
        String servidor = "jdbc:mysql://localhost:3306/contacorrentedb";
        String usuario = "root";
        String senha = "password";
        String driver = "com.mysql.cj.jdbc.Driver";
        try {
            Class.forName(driver);
            this.con = DriverManager.getConnection(servidor, usuario, senha);
            this.stm = this.con.createStatement();
        } catch (Exception e) {
            System.out.println("erro na conexão : " + e);
        }
    }
    public boolean estaConectado() {
        if (this.con != null) {
            return true;
        }
        else {
            return false;
        }
    }
    public Connection getCon() {
        return con;
    }
    public void setCon(Connection con) {
        this.con = con;
    }
    public Statement getStm() {
        return stm;
    }
    public void setStm(Statement stm) {
        this.stm = stm;
    }
    public ResultSet getResult() {
        return result;
    }
    public void setResult(ResultSet result) {
        this.result = result;
    }
    
}