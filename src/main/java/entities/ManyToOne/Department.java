package entities.ManyToOne;

import javax.persistence.*;

@Entity
public class Department {
    @Id
    @TableGenerator(name = "Department_Generator",
            table = "ID_GEN", pkColumnName = "GEN_NAME",
            valueColumnName = "GEN_VALUE")
    @GeneratedValue(generator = "Department_Generator")
    private long id;
    private String name;

    public Department( String name) {
        this.name = name;
    }

    public Department() {
    }
}
