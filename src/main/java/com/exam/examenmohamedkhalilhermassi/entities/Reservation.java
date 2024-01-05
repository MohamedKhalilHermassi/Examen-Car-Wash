package com.exam.examenmohamedkhalilhermassi.entities;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.*;

import java.io.Serializable;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.util.List;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@ToString
public class Reservation implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idReservation;
    private LocalDateTime timereservation;
    @Enumerated(EnumType.STRING)
    private Status status;
    @ManyToOne
    @JsonIgnore
    private Worker worker;
    @ManyToMany(mappedBy = "reservations", fetch = FetchType.EAGER)
    private List<Washing_Service> washingServices;

}
