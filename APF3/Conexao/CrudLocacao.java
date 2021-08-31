package Conexao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
//import Conexao.CrudCarro;
//import Conexao.CrudCliente;




public class CrudLocacao {

    
    
    //cria o objeto do tipo conexão
    private Connection conexao2;
    public CrudLocacao(Connection conexao2){
        this.conexao2 = conexao2;
    }
    
    public boolean create(int id_Locacao,int cpf,String placa,String data_retirada, String data_devolução, int pagamento){
        try{
            //O código SQL pode ser qualquer um, nesse caso é devido ser a construção do CRUD
            Statement statement = this.conexao2.createStatement();
            statement.executeUpdate("INSERT INTO Locacao VALUES("+id_Locacao+","+cpf+", "+placa+","+data_retirada+","+data_devolução+","+pagamento+")");
            
            return true;
        }catch(SQLException e){
            return false;
        }
    }
    

    
    
    public boolean read(int id_Locacao){
        try{
            Statement statement = this.conexao2.createStatement();
            ResultSet rs = statement.executeQuery("SELECT * FROM Locacao WHERE id_Locacao = "+id_Locacao);

            //ResultSet rs = statement.executeQuery("SELECT * FROM Aluno");
            
            while (rs.next()) {
                int id = rs.getInt("id_Locacao");
                int cpf = rs.getInt("cpf");
                String placa = rs.getString("placa");
                String data_retirada = rs.getString("data_retirada");
                String data_devolução = rs.getString("data_devolução");
                Integer pagamento = rs.getInt("pagamento");

                System.out.println( id_Locacao +" - "+cpf+ " - " +placa+ " - "  +data_retirada+" - " +data_devolução+ "-" +pagamento);
            }
            
            return true;
        }catch(SQLException e){
            return false;
        }
    }
    
    public boolean update(int id_Locacao, int novoidLocacao){
        try{
            Statement statement = this.conexao2.createStatement();
            statement.executeUpdate("UPDATE Locacao SET id_Locacao ='"+novoidLocacao+"' WHERE id_Locacao ="+id_Locacao);
            
            return true;
        }catch(SQLException e){
            return false;
        }
    }
    
    public boolean delete(int id_Locacao){
        try{
            Statement statement = this.conexao2.createStatement();
            statement.executeUpdate("DELETE FROM Locacao WHERE id_Locacao ="+id_Locacao+"");
            
            return true;
        }catch(SQLException e){
            return false;
        }
    }
}