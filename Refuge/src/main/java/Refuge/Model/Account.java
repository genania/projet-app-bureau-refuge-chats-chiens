package Refuge.Model;

import java.util.ArrayList;
import java.util.List;

public class Account {
  private int id;
  private String username;
  private String password;
  private static List<Account> accounts = new ArrayList<>();

  public Account(int id, String username, String password) {
    this.id = id;
    this.username = username;
    this.password = password;
  }

  public static void addAccount(Account account) {
    accounts.add(account);
  }

  public boolean authenticate(String username, String password) {
    return this.username.equals(username) && this.password.equals(password);
  }

  public int getId() {
    return id;
  }

  public void setId(int id) {
    this.id = id;
  }

  public String getUsername() {
    return username;
  }

  public void setUsername(String username) {
    this.username = username;
  }

  public String getPassword() {
    return password;
  }

  public void setPassword(String password) {
    this.password = password;
  }

  public static List<Account> getAccounts() {
    return accounts;
  }

  public static void setAccounts(List<Account> accounts) {
    Account.accounts = accounts;
  }

}
