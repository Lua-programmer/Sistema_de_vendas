package com.vendas.gestavendas.entity;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.Type;

import javax.persistence.*;
import java.io.Serializable;
import java.util.UUID;

@AllArgsConstructor
@Data
@Entity
@NoArgsConstructor
@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
@Table(name = "categoria")
public class Category implements Serializable {
    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(generator = "hibernate-uuid")
    @Type(type="org.hibernate.type.UUIDCharType")
    @Column(name = "codigo")
    private UUID code;

    @Column(name = "nome")
    private String name;

    public Category(String name) {
        this.name = name;
    }

    public Category(UUID code) {
        this.code = code;
    }
}
