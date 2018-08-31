package com.thoughtworks.practicediary.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import java.util.Date;

@Entity
@Data
@Table(name = "diary")
public class PracticeDiary {

    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    private Integer id;

    private Date date;

    private String text;

    @JsonIgnore
    private boolean isExcellent;

    public PracticeDiary() {
    }

    public PracticeDiary(Date date, String text) {
        this.date = date;
        this.text = text;
    }
}
