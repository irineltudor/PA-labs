package com.lab9.entities;

import javax.persistence.*;
import java.util.Objects;


@Entity
@Table(name = "genres", schema = "lab8java", catalog = "")
@NamedQueries({
        @NamedQuery(name=GenresEntity.QUERY_FIND_BY_NAME,query="SELECT c FROM GenresEntity c WHERE c.name = :name")
})
public class GenresEntity {
    public static final String QUERY_FIND_BY_NAME = "findByName";
    private int id;
    private String name;

    @Id
    @Column(name = "id", nullable = false)
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    @Basic
    @Column(name = "name", nullable = true, length = 255)
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        GenresEntity that = (GenresEntity) o;
        return id == that.id && Objects.equals(name, that.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, name);
    }

    @Override
    public String toString() {
        return "GenresEntity{" +
                "id=" + id +
                ", name='" + name + '\'' +
                '}';
    }
}
