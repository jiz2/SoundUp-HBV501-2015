package project.persistence.entities;

import javax.persistence.*;

/**
 * The class for the Sound Clip itself.
 * The system generates a table schema based on this class for this entity.
 * Be sure to annotate any entities you have with the @Entity annotation.
 */
@Entity
@Table(name = "soundclip") // If you want to specify a table name, you can do so here
public class SoundClip {

    // Declare that this attribute is the id
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;
    private String path;
    private byte[] data;

    // Notice the empty constructor, because we need to be able to create an empty PostitNote to add
    // to our model so we can use it with our form
    public SoundClip() {
    }

    public SoundClip(String name, String path, ) {
        this.name = name;
        this.note = note;
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

    public String getData() {
        return data;
    }

    public void setData(byte[] data) {
        this.data = data;
    }

    // This is for easier debug.
    @Override
    public String toString() {
        return String.format(
                "Sound Clip[name=%s, path=%s]",
                name,path);
    }
}
