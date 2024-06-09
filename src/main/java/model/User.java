package model;

public class User { //se definen los atributos que tendrá el usuario de la AlkeWallet
    private int id;
    private String name;
    private String lastname;
    private String email;
    private String password;
    private Double balance;

    //constructores y getters and setters
    public User() {
    }


    public User(int id, String name, String lastname, String email, String password) {
        this.id = id;
        this.name = name;
        this.lastname = lastname;
        this.email = email;
        this.password = password;

    }

    public User(String name, String lastname, String email, String password, Double balance) {
        this.name = name;
        this.lastname = lastname;
        this.email = email;
        this.password = password;
        this.balance= balance;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getLastname() {
        return lastname;
    }

    public void setLastname(String lastname) {
        this.lastname = lastname;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public Double getBalance() {
        return balance;
    }

    public void setBalance(Double balance) {
        this.balance = balance;
    }
}
