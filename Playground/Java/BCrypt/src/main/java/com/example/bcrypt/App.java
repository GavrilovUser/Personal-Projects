package com.example.bcrypt;

import org.mindrot.jbcrypt.BCrypt;

public class App {
  public static String hash(String password) {
    return BCrypt.hashpw(password, BCrypt.gensalt(12));
  }
  
  public static void main(String[] args) {
    String myAwesomePassword = "Password";
    String hashPassword = hash(myAwesomePassword);
    System.out.println("Пароль: " + myAwesomePassword + "\nХеш: " + hashPassword);
  }
}