package com.example.SpringBackEnd.model;


import javax.persistence.*;

//use JPA annotations to map model relational database table
@Entity
@Table(name = "employee")
public class Employee {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    @Column(name = "rating")
    private String rating;
    @Column(name = "first_name")
    private String firstName;
    @Column(name = "last_name")
    private String lastName;
    @Column(name = "email_id")
    private String emailId;
    @Column(name = "salary")
    private String salary;
    //when we create a parameter constructor we have to create a default too
    //because hibernate internally uses proxies to create proxy objects
    //create a default constructor;
    public Employee(){

    }

    public Employee(String salary, String rating, String firstName, String lastName, String emailId) {
        this.salary=salary;
        this.rating = rating;
        this.firstName = firstName;
        this.lastName = lastName;
        this.emailId = emailId;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getEmailId() {
        return emailId;
    }

    public String getRating() {
        return rating;
    }

    public void setRating(String rating) {
        this.rating = rating;
    }

    public String getSalary() {
        return salary;
    }

    public void setSalary(String salary) {
        this.salary = salary;
    }

    public void setEmailId(String emailId) {
        this.emailId = emailId;
    }
}
