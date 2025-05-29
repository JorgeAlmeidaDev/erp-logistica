package com.erpsimples.erplogistica.Entity;

import jakarta.persistence.*;

@Entity
public class ItemPedido {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)

    private Long id;
    @ManyToOne Produto produto;

    private int quantidade;

    @ManyToOne Pedido pedido;

}
