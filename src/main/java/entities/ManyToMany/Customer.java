package entities.ManyToMany;

import javax.persistence.*;
import java.util.List;

@Entity
public class Customer {
    @Id
    @TableGenerator(name = "Customer_Gen",
            table = "ID_GEN",
            pkColumnName = "GEN_NAME",
            valueColumnName = "GEN_VALUE")
    @GeneratedValue(generator = "Customer_Gen")
    private long id;
    private String name;

    @ManyToMany
    @JoinTable(name = "customer_product",
    joinColumns = @JoinColumn(name = "id_customer"), //asta inseamna ca customer e ownerul relatiei
    inverseJoinColumns = @JoinColumn(name = "id_product"))
    private List<Product> products;

    public Customer() {
    }

    public Customer(String name, List<Product> products) {
        this.name = name;
        this.products = products;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<Product> getProducts() {
        return products;
    }

    public void setProducts(List<Product> products) {
        this.products = products;
    }
}
