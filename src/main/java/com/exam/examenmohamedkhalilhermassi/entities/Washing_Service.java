package com.exam.examenmohamedkhalilhermassi.entities;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.io.Serializable;
import java.util.List;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class Washing_Service implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idService;
    private Float price;
    @Enumerated(EnumType.STRING)
    private Type type;
    @ManyToMany
    @JsonIgnore
    private List<Reservation> reservations;
}
