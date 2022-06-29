package com.spring.web.model;

// Model or Domain packages are used to store JPA entities ("Things"). These are POJO's with getter & setters

import javax.persistence.*;
import java.util.HashSet;
import java.util.Objects;
import java.util.Set;

@Entity
// @Entity gives control of our model to JPA/hibernate. All entities need a primary key field
public class Author {

    @Id
    // @Id is a required annotation with JPA @Entities. This field will be used as a primary key
    @GeneratedValue(strategy =  GenerationType.AUTO)
    // @GeneratedValue asks the underlying database to automatically generate our ids with the passed strategy
    private Long id;
    private String firstName;
    private String lastName;

    @ManyToMany(mappedBy = "authors")
    // @ManyToMany is used to define relationships among models.
    private Set<Book> books = new HashSet<>();

    public void setBooks(Set<Book> books) {
        this.books = books;
    }

    // JPA requires a no-arg constructor
    public Author() {
    }

    public Author(String firstName, String lastName) {
        this.firstName = firstName;
        this.lastName = lastName;
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

    public Set<Book> getBooks() {
        return books;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    // This was auto-generated with Intellij. It's called the equals and hashCode method
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Author author = (Author) o;
        return Objects.equals(id, author.id);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }

    @Override
    public String toString() {
        return "Author{" +
                "id=" + this.id +
                ", firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", books=" + books +
                '}';
    }
}
