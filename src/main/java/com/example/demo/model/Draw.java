package com.example.demo.model;

import javax.persistence.*;

@Entity
public class Draw
{
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    Long id;

    String drawedName;
    String drawedSurname;
    String selectedName;
    String selectedSurname;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getDrawedName() {
        return drawedName;
    }

    public void setDrawedName(String drawedName) {
        this.drawedName = drawedName;
    }

    public String getDrawedSurname() {
        return drawedSurname;
    }

    public void setDrawedSurname(String drawedSurname) {
        this.drawedSurname = drawedSurname;
    }

    public String getSelectedName() {
        return selectedName;
    }

    public void setSelectedName(String selectedName) {
        this.selectedName = selectedName;
    }

    public String getSelectedSurname() {
        return selectedSurname;
    }

    public void setSelectedSurname(String selectedSurname) {
        this.selectedSurname = selectedSurname;
    }
}
