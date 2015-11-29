package project.persistence.entities;

import javax.persistence.*;

/**
 * The class for the Sound Clip itself.
 * The system generates a table schema based on this class for this entity.
 * Be sure to annotate any entities you have with the @Entity annotation.
 */
@Entity
@Table(name = "usersoundclip") // If you want to specify a table name, you can do so here
public class UserSoundClip {

    // Declare that this attribute is the id
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String usr;
    private String name;
    private String ext;
    private byte[] data;
    private boolean isPrivate;

    // Database constructor
    public UserSoundClip() {
    }

    public UserSoundClip(String user, String name, String ext, byte[] data, boolean isPrivate) {
        this.usr = user;
        this.name = name;
        this.ext = ext;
        this.data = data;
        this.isPrivate = isPrivate;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getUser() {
        return usr;
    }

    public void setUser(String user) {
        this.usr = user;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getExt() {
        return ext;
    }

    public void setExt(String name) {
        this.ext = ext;
    }

    public byte[] getData() {
        return data;
    }

    public void setData(byte[] data) {
        this.data = data;
    }

    public boolean isPrivate() {
        return isPrivate;
    }

    public void setPrivate(boolean isPrivate) {
        this.isPrivate = isPrivate;
    }

    // This is for easier debug.
    @Override
    public String toString() {
        return String.format(
                "UserSoundClip[name=%s, data=%s]",
                name, new String(data)
        );
    }
}
