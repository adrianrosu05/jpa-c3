package entities.ManyToMany;

import javax.persistence.*;
import java.util.List;

@Entity
public class Product {

    @Id
    @TableGenerator(name = "Product_Gen",
    table = "ID_GEN",
    pkColumnName = "GEN_NAME",
    valueColumnName = "GEN_VALUE")
    @GeneratedValue(generator = "Product_Gen")
    private long id;
    private String name;
    private double price;

    @ManyToMany(mappedBy = "products")
    private List<Customer> customers;

    public Product() {
    }

    public Product(String name, double price, List<Customer> customers) {
        this.name = name;
        this.price = price;
        this.customers = customers;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public List<Customer> getCustomers() {
        return customers;
    }

    public void setCustomers(List<Customer> customers) {
        this.customers = customers;
    }
}
