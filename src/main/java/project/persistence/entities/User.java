package project.persistence.entities;

import java.io.Serializable;
import javax.persistence.*;

@Entity
@Table(name = "Users")
public class User implements Serializable {
	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    private String name;
    private String pw;

    public User() {
    }

    public User(String name, String hash) {
        this.name = name;
        this.pw = hash;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
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
}
