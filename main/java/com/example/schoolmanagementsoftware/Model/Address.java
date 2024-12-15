package com.example.schoolmanagementsoftware.Model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@Entity
public class Address {
    @Id
    private Integer id;
    @Column(columnDefinition = "varchar(10)")
    private String area;
    @Column(columnDefinition = "varchar(10)")
    private String street;
    @Column(columnDefinition = "varchar(10)")
    private String buildingNumber;

    @OneToOne
    @MapsId
    @JsonIgnore
    private Teacher teacher;

    public Address(Integer id, String area, String street, String buildingNumber, Teacher teacher) {
        this.id = id;
        this.area = area;
        this.street = street;
        this.buildingNumber = buildingNumber;
        this.teacher = teacher;
    }
}
