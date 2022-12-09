package com.coderscampus;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.Scanner;

public class UserLoginApplication {
	public static User[] users = new User[4];
	public static UserService userService = new UserService();

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		addUserArray();
		Scanner scanner = null;

		try {
			scanner = new Scanner(System.in);
			boolean login = false;
			int attempts = 5;

			while (!login && attempts > 0) {
				System.out.println("Enter Username: ");
				String username = scanner.nextLine();
				System.out.println("Enter Password: ");
				String password = scanner.nextLine();

				User validUser = userService.validateUser(username, password);
				if (validUser != null) {
					System.out.println("Access Granted to :" + validUser.getName());
					login = true;
				} else {
					System.out.println("Invalid login, please try again");
					attempts--;
					if (attempts == 0) {
						System.out.println("Too many failed attempts, you are locked out!");
					}
				}
			}

		} finally {
			if (scanner != null) {
				scanner.close();
			}

		}

	}

	private static void addUserArray() throws FileNotFoundException, IOException {

		BufferedReader bf = null;
		try {
			bf = new BufferedReader(new FileReader("data.txt"));

			String line = null;
			int i = 0;

			while ((line = bf.readLine()) != null) {

				users[i] = new User(line.split(","));

				System.out.println(users[i]);

				i++;
			}

		} finally {
			if (bf != null)
				;

			bf.close();
		}

	}
}
