package com.accenture;

import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;



@Controller
public class Test {

	private Connection connection = null;
	private PreparedStatement statement = null;
	private ResultSet resultSet = null;
	

@RequestMapping("/validate.do")
public ModelAndView bak(ModelMap m){
	User user=new User();
	m.addAttribute("user", user);
	ModelAndView mv=new ModelAndView();
	mv.setViewName("login.jsp");
	return mv;
}
	
	@RequestMapping("/validate1.do")
	public ModelAndView login(@ModelAttribute("user")User user) throws SQLException,IOException,ClassNotFoundException{
		ModelAndView mv=new ModelAndView();	
		int userid=user.getUserid();
		String pass=user.getPassword();
		System.out.println("hola21");
		
		
		connection=Connector.createConnection();
		statement=connection.prepareStatement("Select * from users");
		resultSet=statement.executeQuery();
		while(resultSet.next()){
			if(resultSet.getInt("userid")==(userid) && resultSet.getString("password").equals(pass)){
				{mv.setViewName("success.html");
				break;}
				
			}else
				mv.setViewName("failure.html");
		}
				
		return mv;
	}
}
