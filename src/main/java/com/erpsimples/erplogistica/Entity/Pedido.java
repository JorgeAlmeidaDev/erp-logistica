package com.erpsimples.erplogistica.Entity;

import jakarta.persistence.*;

import java.time.LocalDate;
import java.util.List;
@Entity
public class Pedido {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
  private  Long id;

  private  String cliente;
  private  LocalDate datacriacao;
  private  String status;

  @OneToMany(mappedBy = "pedido", cascade = CascadeType.ALL)
  private  List<ItemPedido> itens;
}
