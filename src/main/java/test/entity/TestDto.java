package test.entity;


import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class TestDto {
    public TestDto(){}
    public TestDto(String title, String content, String etc){
        this.id = id;
        this.title = title;
        this.content = content;
        this.etc = etc;
    }


    @Id @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;

    private String title;

    private String content;

    private String etc;

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public String getEtc() {
        return etc;
    }

    public void setEtc(String etc) {
        this.etc = etc;
    }

    @Override
    public String toString() {
        return "TestDto{" +
                "id=" + id +
                ", title='" + title + '\'' +
                ", content='" + content + '\'' +
                ", etc='" + etc + '\'' +
                '}';
    }
}
