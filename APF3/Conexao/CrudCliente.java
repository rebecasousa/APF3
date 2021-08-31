package Conexao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
//import Conexao.CrudCarro;
//import Conexao.CrudLocacao;


public class CrudCliente
{
    //cria o objeto do tipo conexão
    private Connection conexao1;
    public CrudCliente(Connection conexao1){
        this.conexao1 = conexao1;
    }
    
    public boolean create( int cpf1, String nome, String email, int telefone, String endereço){
        try{
            Statement statement = this.conexao1.createStatement();
            statement.executeUpdate("INSERT INTO Cliente VALUES("+cpf1+" , "+nome+" ,"+email+" ,"+telefone+" , "+endereço+")");
            
            return true;
        }catch(SQLException e){
            return false;
        }
    }
    
    public boolean read(String cpf1){
        try{
            Statement statement = this.conexao1.createStatement();
            ResultSet rs = statement.executeQuery("SELECT * FROM Cliente WHERE cpf1 = "+cpf1);

        
            
            while (rs.next()) {
                Integer cpf_ = rs.getInt("cpf1");
                String nome = rs.getString("nome");
                String email = rs.getString("email");
                Integer telefone = rs.getInt("telefone");
                String endereço = rs.getString("endereço");
                



                System.out.println( cpf1 +" - " + nome + " - " + email + " - "  + telefone + " - " + endereço);
            }
            
            return true;
        }catch(SQLException e){
            return false;
        }
    }
    
    public boolean update( int cpf1, String novonome){
        try{
            Statement statement = this.conexao1.createStatement();
            statement.executeUpdate("UPDATE Cliente SET nome = '"+novonome+"' WHERE cpf1 ="+cpf1);
            //statement.executeUpdate("UPDATE Cliente SET nascimento ="+novonascimento+" WHERE cpf ="+cpf);
            //statement.executeUpdate("UPDATE Cliente SET email ="+novoemail+" WHERE cpf ="+cpf);
            //statement.executeUpdate("UPDATE Cliente SET fone ="+novofone+" WHERE cpf ="+cpf);
            //statement.executeUpdate("UPDATE Cliente SET endereço ="+novoendereço+" WHERE cpf ="+cpf);
                
            
            
            return true;
        }catch(SQLException e){
            return false;
        }
    }
    
    public boolean delete(int cpf1){
        try{
            Statement statement = this.conexao1.createStatement();
            statement.executeUpdate("DELETE FROM Cliente WHERE cpf1 ="+cpf1+"");
            
            return true;
        }catch(SQLException e){
            return false;
        }
    }
}