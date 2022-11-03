package com.vendas.gestavendas.entity;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.Type;

import javax.persistence.*;
import java.io.Serializable;
import java.math.BigDecimal;
import java.util.UUID;

@AllArgsConstructor
@Data
@Entity
@NoArgsConstructor
@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
@Table(name = "produto")
public class Product implements Serializable {
    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(generator = "hibernate-uuid")
    @Type(type="org.hibernate.type.UUIDCharType")
    @Column(name = "codigo")
    private UUID code;

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

    public Product(String description, Integer quantity, BigDecimal priceCost, BigDecimal priceSale, String observation, Category category) {
        this.description = description;
        this.quantity = quantity;
        this.priceCost = priceCost;
        this.priceSale = priceSale;
        this.observation = observation;
        this.category = category;
    }
}
