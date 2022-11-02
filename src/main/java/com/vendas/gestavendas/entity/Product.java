package com.vendas.gestavendas.entity;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.Type;
import org.hibernate.validator.constraints.Length;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
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
    @NotBlank(message = "Description")
    @Length(min = 3, max = 255, message = "Description")
    private String description;

    @Column(name = "quantidade")
    @NotNull(message = "Quantity")
    private Integer quantity;

    @Column(name = "preco_custo")
    @NotNull(message = "Price cost")
    private BigDecimal priceCost;

    @Column(name = "preco_venda")
    @NotNull(message = "Price sale")
    private BigDecimal priceSale;

    @Column(name = "observacao")
    @Length(max = 255, message = "Observation")
    private String observation;

    @ManyToOne
    @JoinColumn(name = "codigo_categoria", referencedColumnName = "codigo")
    @NotNull(message = "Code category")
    private Category category;

}
