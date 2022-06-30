package entities;

import javax.persistence.*;
import java.io.Serializable;

@Entity
public class MaterialCurso implements Serializable {
    private static final long serialVersionUID = 8728451610311617249L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column
    private String url;
    @OneToOne(cascade = CascadeType.ALL, mappedBy = "materialCurso")
    private Curso curso;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public Curso getCurso() {
        return curso;
    }

    public void setCurso(Curso curso) {
        this.curso = curso;
    }
}
