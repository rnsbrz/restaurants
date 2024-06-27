package com.spring.library.model;

import jakarta.persistence.*;
import java.util.List;

@Entity
@Table(name = "genre")
public class Genre {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private int id;

    @Column(name = "name")
    private String name;

    @Column(name="food1")
    private String food1;
    @Column(name="food2")
    private String food2;
    @Column(name="food3")
    private String food3;
    @OneToMany(mappedBy = "genre")
    private List<Book> books;

    public Genre() {
    }
    public Genre(String name, String food1, String food2, String food3) {
        this.name = name;
        this.food1=food1;
        this.food2=food2;
        this.food3=food3;
    }

    public Genre(int id, String name, String food1, String food2, String food3) {
        this.id = id;
        this.name = name;
        this.food1=food1;
        this.food2=food2;
        this.food3=food3;
    }

    public int getId() {
        return id;
    }
    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getFood1() {
        return food1;
    }

    public void setFood1(String food1) {
        this.food1 = food1;
    }

    public String getFood2() {
        return food2;
    }

    public void setFood2(String food2) {
        this.food2 = food2;
    }

    public String getFood3() {
        return food3;
    }

    public void setFood3(String food3) {
        this.food3 = food3;
    }

    public List<Book> getBooks() {
        return books;
    }

    public void setBooks(List<Book> books) {
        this.books = books;
    }

    @Override
    public String toString() {
        return "Genre{" +
                "id=" + id +
                ", name='" + name + '\'' +
                '}';
    }
}
