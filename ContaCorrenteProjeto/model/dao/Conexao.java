package ContaCorrenteProjeto.model.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

public class Conexao {
    private Connection con = null;   // variavel da conexao
    private Statement stm  = null;   // variavel do statement
    private ResultSet result = null; // variavel do resultado do statement
    
    // conecta ao banco de dados
    public Conexao() {
        String servidor = "jdbc:mysql://localhost:3306/contacorrentedb"; // url do servidor
        String usuario = "root"; // usuario
        String senha = "P@$$w0rd"; // senha
        String driver = "com.mysql.cj.jdbc.Driver"; // driver usado pelo java
        try {
            Class.forName(driver);
            this.con = DriverManager.getConnection(servidor, usuario, senha);
            // cria o Statement que vai ser usado nas querys em ContasDao
            this.stm = this.con.createStatement();
        } catch (Exception e) {
            System.out.println("erro na conexão : " + e);
            System.exit(1);
        }
    }
    // verifica a conexão
    public boolean estaConectado() {
        if (this.con != null)
            return true;
        
        return false;
    }
    // retorna a variavel Statement
    public Statement getStm() {
        return stm;
    }
    // retorna a variavel Result
    public ResultSet getResult() {
        return result;
    }
    
}