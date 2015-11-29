package project.persistence.entities;

import javax.persistence.*;

/**
 * The class for the User itself.
 * The system generates a table schema based on this class for this entity.
 * Be sure to annotate any entities you have with the @Entity annotation.
 */
@Entity
@Table(name = "users") // If you want to specify a table name, you can do so here
public class User {

    // Declare that this attribute is the id
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;
    private String hash;

    // Database constructor
    public User() {
    }

    public User(String name, String hash) {
        this.name = name;
        this.hash = hash;
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

    public String getHash() {
        return hash;
    }

    public void setHash(String name) {
        this.hash = hash;
    }

    // This is for easier debug.
    @Override
    public String toString() {
        return String.format(
                "User[name=%s, hash=%s]",
                name, hash
        );
    }
}
