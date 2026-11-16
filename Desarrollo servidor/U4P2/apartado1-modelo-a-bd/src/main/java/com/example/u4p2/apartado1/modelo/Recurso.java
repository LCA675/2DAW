package com.example.u4p2.apartado1.modelo;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name = "Recurso")
@Getter @Setter @NoArgsConstructor
public class Recurso {
    @Id
    private Long id;
}
