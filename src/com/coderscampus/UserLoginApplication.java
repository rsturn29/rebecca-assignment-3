package com.coderscampus;

import java.util.Scanner;

public class UserLoginApplication {
	public static User[] users = new User[4];
	public static UserService userService = new UserService();

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		Scanner scanner = null;
		
		try {
			scanner = new Scanner(System.in);
			boolean login = false;
			int attempts=5;
			
			while(!login && attempts>0) {
				System.out.println("Enter Username: ");
				String username= scanner.nextLine();
				System.out.println("Enter Password: ");
				String password= scanner.nextLine();
				
			User validUser = userService.validateUser(username, password);
			if (validUser != null) {
				System.out.println("Access Granted to :" + validUser.getName());
				login=true;
			}
			else {
				System.out.println("Invalid login, please try again");
				attempts--;
				if (attempts==0) {
					System.out.println("Too many failed attempts, you are locked out!");
				}
			}
			}
			
		}finally{if(scanner !=null) {
			scanner.close();
		}
			
		}

	}

}
