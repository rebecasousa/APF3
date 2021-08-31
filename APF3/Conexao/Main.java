package Conexao;


import Conexao.TestConexaoSqlite3;
import Conexao.CrudCarro;
import Conexao.CrudCliente;
import Conexao.CrudLocacao;
import java.sql.Statement;
import java.sql.SQLException;

public class Main{
    public static void main(String args[])throws Exception{
        TestConexaoSqlite3 conexao = new TestConexaoSqlite3();
        conexao.abrirConexao();
        CrudCarro crud = new CrudCarro(conexao.getConnection());
        
        //TestConexaoSqlite3 conexao1 = new TestConexaoSqlite3();
        //conexao1.abrirConexao();
        //CrudCliente crud1 = new CrudCliente(conexao1.getConnection());
        
        
        //TestConexaoSqlite3 conexao2 = new TestConexaoSqlite3();
        //conexao2.abrirConexao();
        //CrudLocacao crud2 = new CrudLocacao(conexao2.getConnection());
        
        
        //Inserindo cadastros no banco
        
        //String placa, String modelo, int ano, String cor,String valor,String status //CARRO
        //int cpf, String nome, String email, int telefone, String endereço  //CLIENTE
        //int id_Locacao,int cpf,String placa,String data_retirada, String data_devolução, int pagamento  LOCACAO
        
        System.out.println(crud.create("453SDE","Gol",1980,"vermelho","TREZENTOS REAIS","DISPONIVEL")); //CARRO
        

     
        
        //crud1.create(874563267,"Maria José","não possui",67293793,"Fortaleza"); //CLIENTE 
        
   
        
        //crud2.create(1,45367289,"SP567","07/05/2020","14/05/2020",300); //LOCACAO
      
     
        //Consultando uma linha no banco 
        //crud.read(x); //linha onde a placa do carro é x
        //crud1.read(x); //linha onde o cpf do cliente é x
        //crud2.read(x); //linha onde o id_Locacao da locação é x 
        
        
        //tualizando um registro no banco
        //crud.update(xxx,xx); //atualizando status do Carro com placa xxx para status(disponível,indisponível) xx
        //crud1.update(xxx,xx); //atualizando nome do Cliente com cpf xxx para nome xx
        //crud.update(xx,xx); //atualizando id_Locacao da Locacao com id_Locacao xx para id_Locacao xx
        
        
        
        //Deletando um registro no banco
        //crud.delete(x); //deletando o registro da tabela Carro onde a placa é x
        //crud1.delete(x);  //deletando o registro da tabela Cliente onde o cpf é x
        //crud2.delete(x); //deletando o registro da tabela Locacao onde o id_Locacao é x

        
        
        conexao.fecharConexao();
        //conexao1.fecharConexao();
        //conexao2.fecharConexao();
        
        
    }
}