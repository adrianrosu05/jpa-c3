package entities.OneToOne;

import javax.persistence.*;

@Entity
public class Person {
    @Id
    @TableGenerator(name = "Person_Generator",
            table = "ID_GEN",
            pkColumnName = "GEN_NAME",
            valueColumnName = "GEN_VALUE")
    @GeneratedValue(generator = "Person_Generator")
    private long id;
    private String name;
    @OneToOne
    @JoinColumn(name = "document")
    //ownerul relatiei este cel care contine cheie straina
    //care contine @JoinColumn sau sursa externa
    private Document document;

    public Person(String name, Document document) {
        this.name = name;
        this.document = document;
    }

    public Person() {
    }
}
