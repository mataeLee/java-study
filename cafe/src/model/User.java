package model;

public class User {
    private String name;
    private Cafe cafe;

    public User(String name, Cafe cafe) {
        this.name = name;
        this.cafe = cafe;
    }

    public User(String name) {
        this.name = name;
    }

    public void enterCafe() {
        cafe.enterUser(this);
    }

    public void getOutCafe(){
        cafe.getOutUser(this);
    }

    public String getName() {
        return name;
    }
}
