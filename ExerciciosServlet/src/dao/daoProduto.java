package dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

import model.Produto;;

public class daoProduto {
	
	
	private Connection con;
	private PreparedStatement query;
	private ResultSet result;
	private Produto produto;
	private ArrayList<Produto> listaProduto;
	private String msn;
	public daoProduto(){
		try {
			Class.forName("com.mysql.jdbc.Driver");
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	public String InsereProduto(Produto produto){
		System.out.print(produto.getNome());
		try {
			this.con = DriverManager.getConnection("jdbc:mysql://localhost:3307/produto","root","");
			this.query = this.con.prepareStatement("insert into produto(nome) values (?)");
			this.query.setString(1,produto.getNome());
			
			if(this.query.executeUpdate()>0){
				msn = "Inserido";
			}else{
				msn = "Não inserido";
			}
			this.query.close();
			this.con.close();
		} catch (Exception e) {
			msn = e.getMessage();
		}
		return msn;
	
	}
	

}
