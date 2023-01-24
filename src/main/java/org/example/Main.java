package org.example;

import entities.ManyToMany.Customer;
import entities.ManyToMany.Product;
import entities.ManyToOne.Department;
import entities.ManyToOne.Employee;
import entities.OneToOne.Document;
import entities.OneToOne.Person;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import java.util.ArrayList;

public class Main {
    public static void main(String[] args) {
        System.out.println("Hello world!");

        EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("my-persistence-unit");
        EntityManager entityManager = entityManagerFactory.createEntityManager();
        //createEmployeeAndDepartment(entityManager);
        //createPersonAndDocument(entityManager);
        createCustomerAndProduct(entityManager);

    }

    public static void createEmployeeAndDepartment(EntityManager entityManager){
        Department department1 = new Department("HR");
        Department department2 = new Department("IT");

        Employee employee1 = new Employee("John", 200.5, department1);
        Employee employee2 = new Employee("Mary", 149.3, department1);
        Employee employee3 = new Employee("Adriana", 100.2, department2);

        entityManager.getTransaction().begin();

        entityManager.persist(department1);
        entityManager.persist(department2);
        entityManager.persist(employee1);
        entityManager.persist(employee2);
        entityManager.persist(employee3);

        entityManager.getTransaction().commit();
    }

    public static void createPersonAndDocument(EntityManager entityManager){
        Document d1 = new Document("12232434343");
        Document d2 = new Document("122324121334342323");

        Person p1 = new Person("John", d1);
        Person p2 = new Person("Ana", d1);
        Person p3 = new Person("Becky", d2);
        Person p4 = new Person("Janne", d2);

        entityManager.getTransaction().begin();

        entityManager.persist(d1);
        entityManager.persist(d2);
        entityManager.persist(p1);
        entityManager.persist(p2);
        entityManager.persist(p3);
        entityManager.persist(p4);

        entityManager.getTransaction().commit();
    }

    public static void createCustomerAndProduct(EntityManager entityManager){
        Customer c1 = new Customer("John", new ArrayList<Product>());
        Customer c2 = new Customer("Mary", new ArrayList<Product>());

        Product p1 = new Product("phone", 1500, new ArrayList<Customer>());
        Product p2 = new Product("laptop", 7500, new ArrayList<Customer>());

        c1.getProducts().add(p1);
        p1.getCustomers().add(c1);

        c1.getProducts().add(p2);
        p2.getCustomers().add(c1);

        c2.getProducts().add(p2);
        p2.getCustomers().add(c2);

        entityManager.getTransaction().begin();

        entityManager.persist(c1);
        entityManager.persist(c2);
        entityManager.persist(p1);
        entityManager.persist(p2);

        entityManager.getTransaction().commit();
    }
}