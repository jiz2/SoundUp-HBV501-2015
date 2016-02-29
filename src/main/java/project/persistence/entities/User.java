package project.persistence.entities;

import javax.persistence.*;

@Entity
@Table(name = "Users")
public class User {
	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    private String pw;

    public User() {
    }

    public User(String name, String hash) {
        this.name = name;
        this.pw = hash;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPw() {
        return pw;
    }

    public void setPw(String pw) {
        this.pw = pw;
    }

    // This is for easier debug.
    @Override
    public String toString() {
        return String.format(
                "User[name=%s, pw=%s]",
                name, pw
        );
    }
}
