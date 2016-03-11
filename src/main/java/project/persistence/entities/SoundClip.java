package project.persistence.entities;

import java.io.Serializable;
import javax.persistence.*;

@Entity
@Table(name = "soundclip")
public class SoundClip implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    private String ext;
    private String data;
    private String uploader;

    @Column(name = "private")
	private boolean isPrivate;

    public SoundClip() {
    }

    public SoundClip(String name, String ext, String data, String uploader, boolean isPrivate) {
        this.name = name;
        this.ext = ext;
        this.data = data;
        this.uploader = uploader;
		this.isPrivate = isPrivate;
    }

    public Long getId() {
        return this.id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return this.name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getExt() {
        return this.ext;
    }

    public void setExt(String ext) {
        this.ext = ext;
    }

    public String getData() {
        return this.data;
    }

    public void setData(String data) {
        this.data = data;
    }

    public String getUploader() {
        return this.uploader;
    }

    public void setUploader(String uploader) {
        this.uploader = uploader;
    }	
	
	public boolean getIsPrivate() {
		return this.isPrivate;
	}
	
	public void setIsPrivate(boolean isPrivate) {
		this.isPrivate = isPrivate;
	}
	
	public String getBase64Str(){
		return this.getData();
	}
}
