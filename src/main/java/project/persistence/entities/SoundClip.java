package project.persistence.entities;

import javax.persistence.*;

@Entity
@Table(name = "Soundclips")
public class SoundClip {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    private String ext;
    private byte[] binaryStr;
	private String url;
	private boolean isPrivate;

    public SoundClip() {
    }

    public SoundClip(String name, String ext, byte[] binaryStr, String url, boolean isPrivate) {
        this.name = name;
        this.ext = ext;
        this.binaryStr = binaryStr;
		this.url = url;
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

    public byte[] getBinaryStr() {
        return this.binaryStr;
    }

    public void setBinaryStr(byte[] binaryStr) {
        this.binaryStr = binaryStr;
    }

	public String getUrl() {
        return this.url;
    }

    public void setUrl(String url) {
        this.url = url;
    }	
	public boolean getIsPrivate() {
		return this.isPrivate;
	}
	
	public void setIsPrivate(boolean isPrivate) {
		this.isPrivate = isPrivate;
	}
	
	public String getBase64Str(){
		return java.util.Base64.getEncoder().encodeToString(this.getBinaryStr());
	}

    // This is for easier debug.
    @Override
    public String toString() {
        return String.format(
                "Sound Clip[name=%s, binaryStr=%s]",
                name, new String(binaryStr)
        );
    }
}
