package Conexao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
//import Conexao.CrudCliente;
//import Conexao.CrudLocacao;  



public class CrudCarro
{
    //cria o objeto do tipo conexão
    private Connection conexao;
    public CrudCarro(Connection conexao){
        this.conexao = conexao;
    }
    
    public boolean create( String placa1, String modelo, int ano, String cor,String valor,String status){
        try{
            Statement statement = this.conexao.createStatement();
            statement.executeUpdate("INSERT INTO Carro VALUES("+placa1+" , "+modelo+" ,"+ano+" ,"+cor+" ,"+valor+"  , "+status+")");
            
            return true;
        }catch(SQLException e){
            return false;
        }
    }
    
    public boolean read(String placa1){
        try{
            Statement statement = this.conexao.createStatement();
            ResultSet rs = statement.executeQuery("SELECT * FROM Carro WHERE placa1 = "+placa1);

        
            
            while (rs.next()) {
                String placa_ = rs.getString("placa1");
                String modelo = rs.getString("modelo");
                Integer ano = rs.getInt("ano");
                String cor = rs.getString("cor");
                String valor = rs.getString("valor");
                String status = rs.getString("status");



                System.out.println( placa1 +" - " + modelo + " - " + ano + " - " + cor +" - " + valor + " - " +status);
            }
            
            return true;
        }catch(SQLException e){
            return false;
        }
    }
    
    public boolean update(String placa1,String novostatus){
        try{
            Statement statement = this.conexao.createStatement();
            statement.executeUpdate("UPDATE Carro SET status ="+novostatus+" WHERE placa1 ="+placa1);
            
            
            return true;
        }catch(SQLException e){
            return false;
        }
    }
    
    public boolean delete(String placa1){
        try{
            Statement statement = this.conexao.createStatement();
            statement.executeUpdate("DELETE FROM Carro WHERE placa1 ="+placa1+"");
            
            return true;
        }catch(SQLException e){
            return false;
        }
    }
}