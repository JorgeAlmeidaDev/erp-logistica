package com.erpsimples.erplogistica.Entity;

import jakarta.persistence.*;

import java.time.LocalDate;

@Entity
public class Transporte {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Long id;
    @ManyToOne
    Pedido pedido;
    @ManyToOne
     Motorista motorista;
    @ManyToOne
    Veiculo veiculo;
    LocalDate dataSaida;
    String status;
}
