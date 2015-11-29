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
    private String ext;
    private byte[] data;

    // Database constructor
    public SoundClip() {
    }

    public SoundClip(String name, String ext, byte[] data) {
        this.name = name;
        this.ext = ext;
        this.data = data;
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
	
	public String getLink() {
		return this.toString();
	}
	
	public String getTitle() {
		return this.toString();
	}

    // This is for easier debug.
    @Override
    public String toString() {
        return String.format(
                "Sound Clip[name=%s, data=%s]",
                name, new String(data)
        );
    }
}
