
public class User {
    private String accountNo; //random generate
    private Long balance;
    private String name; //register
    private char gender; //pick?
    private String username; //register
    private String password; //register
    //private boolean newsLetter;


    public User(String accountNo, Long balance, String name, char gender, String username, String password) {
        this.accountNo = accountNo;
        this.balance = balance;
        this.name = name;
        this.gender = gender;
        this.username = username;
        this.password = password;
    }

    //do i need getters n setters?
}


