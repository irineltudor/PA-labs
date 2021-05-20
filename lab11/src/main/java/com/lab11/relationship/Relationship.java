package com.lab11.relationship;

import javax.persistence.*;

@Entity
@Table
public class Relationship {
    @Id
    @SequenceGenerator(
            name="relationship_sequence" ,
            sequenceName = "relationship_sequence" ,
            allocationSize = 1
    )
    @GeneratedValue(
            strategy = GenerationType.SEQUENCE,
            generator = "relationship_sequence"
    )

    private Long id;

    private Long person1_id;

    private Long person2_id;

    public Relationship(Long person1_id, Long person2_id) {
        this.person1_id = person1_id;
        this.person2_id = person2_id;
    }

    public Relationship() {
    }

    public Relationship(Long id, Long person1_id, Long person2_id) {
        this.id = id;
        this.person1_id = person1_id;
        this.person2_id = person2_id;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getPerson1_id() {
        return person1_id;
    }

    public void setPerson1_id(Long person1_id) {
        this.person1_id = person1_id;
    }

    public Long getPerson2_id() {
        return person2_id;
    }

    public void setPerson2_id(Long person2_id) {
        this.person2_id = person2_id;
    }

    @Override
    public String toString() {
        return "Relationship{" +
                "id=" + id +
                ", person1_id=" + person1_id +
                ", person2_id=" + person2_id +
                '}';
    }
}
