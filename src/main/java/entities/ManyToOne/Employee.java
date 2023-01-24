package entities.ManyToOne;

import javax.persistence.*;

@Entity
public class Employee {
    @Id
    @TableGenerator(name = "Employee_Generator",
            table = "ID_GEN", pkColumnName = "GEN_NAME",
            valueColumnName = "GEN_VALUE")
    @GeneratedValue(generator = "Employee_Generator")
    private long id;
    private String name;
    private double salary;
    @ManyToOne //many employees to one department

    //in cazul cheii straine nu putem folosi adnotarea cu
    //@Column pentru numele coloanei si folosim @JoinColumn
    @JoinColumn(name = "department")
    private Department department;

    public Employee(String name, double salary, Department department) {
        this.name = name;
        this.salary = salary;
        this.department = department;
    }

    public Employee() {
    }
}
