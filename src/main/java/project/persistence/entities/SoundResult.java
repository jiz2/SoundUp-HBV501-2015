package project.persistence.entities;

public class SoundResult {

    private Long id;
    private String name;
    private String ext;
    private String uploader;
    private boolean isPrivate;

    public SoundResult(SoundClip sc) {
        this.id = sc.getId();
        this.name = sc.getName();
        this.ext = sc.getExt();
        this.uploader = sc.getUploader();
        this.isPrivate = sc.getIsPrivate();
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
}