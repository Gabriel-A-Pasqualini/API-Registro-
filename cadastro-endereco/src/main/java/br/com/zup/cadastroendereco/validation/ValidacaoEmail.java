package br.com.zup.cadastroendereco.validation;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

public class ValidacaoEmail implements 
ConstraintValidator<ExisteEmail, String>{
	
	@Override
    public void initialize(ExisteEmail campoEmail) {
    }
	
	@Override
	public boolean isValid(String campoEmail, ConstraintValidatorContext context) {
		
		boolean ExisteEmail = false;
		
		try {
			Class.forName("org.h2.Driver");
	        String databaseURL = "jdbc:h2:mem:cadastro-usuarios";
	        Connection con = DriverManager.getConnection(databaseURL, "sa", "");
	        Statement stat = con.createStatement();    
	        String selectQuery = "SELECT * FROM USER_REGISTER WHERE email = '"+ campoEmail +"'";
	        System.out.println(selectQuery);
	        ResultSet rs=stat.executeQuery(selectQuery);
	        
	        if (rs.next()) {
	        	ExisteEmail = false;
	        } else {
	        	ExisteEmail = true;
	        }
	        
		} catch (Exception e) {
			e.printStackTrace();
		} 

		return ExisteEmail;
	}

}
