package entities.OneToOne;

import javax.persistence.*;

@Entity
public class Document {
    @Id
    @TableGenerator(name = "Document_Generator",
    table = "ID_GEN",
    pkColumnName = "GEN_NAME",
    valueColumnName = "GEN_VALUE")
    @GeneratedValue(generator = "Document_Generator")
    private long id;
    private String series;

    @OneToOne(mappedBy = "document") //cheia straina
    //nu putem sa punem @JoinColumn
    //si in felul asta avem o relatie bidirectionala
    private Person person;

    public Document(String series) {
        this.series = series;
    }

    public Document() {
    }
}
