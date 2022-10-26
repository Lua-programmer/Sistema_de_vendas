package com.vendas.gestavendas.entity;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.math.BigDecimal;

@AllArgsConstructor
@Data
@Entity
@NoArgsConstructor
@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
@Table(name = "produto")
public class Product {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "codigo")
    private Long code;

    @Column(name = "descricao")
    private String description;

    @Column(name = "quantidade")
    private Integer quantity;

    @Column(name = "preco_custo")
    private BigDecimal priceCost;

    @Column(name = "preco_venda")
    private BigDecimal priceSale;

    @Column(name = "observacao")
    private String observation;

    @ManyToOne
    @JoinColumn(name = "codigo_categoria", referencedColumnName = "codigo")
    private Category category;

}
