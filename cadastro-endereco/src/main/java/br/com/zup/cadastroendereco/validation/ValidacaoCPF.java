package br.com.zup.cadastroendereco.validation;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;


public class ValidacaoCPF implements 
ConstraintValidator<ExisteCPF, String>{
	
	@Override
    public void initialize(ExisteCPF campoCPF) {
    }
	
	@Override
	public boolean isValid(String campoCPF, ConstraintValidatorContext context) {
		
		boolean ExisteCPF = false;
		
		try {
			Class.forName("org.h2.Driver");
	        String databaseURL = "jdbc:h2:mem:cadastro-usuarios";
	        Connection con = DriverManager.getConnection(databaseURL, "sa", "");
	        Statement stat = con.createStatement();    
	        String selectQuery = "SELECT * FROM USER_REGISTER WHERE cpf = '"+ campoCPF +"'";
	        System.out.println(selectQuery);
	        ResultSet rs=stat.executeQuery(selectQuery);
	        
	        if (rs.next()) {
	        	ExisteCPF = false;
	        } else {
	        	ExisteCPF = true;
	        }
	        
		} catch (Exception e) {
			e.printStackTrace();
		} 

		return ExisteCPF;
	}


}
