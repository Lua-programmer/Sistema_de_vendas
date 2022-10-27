package com.vendas.gestavendas.entity;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.*;
import org.hibernate.annotations.Type;
import org.hibernate.validator.constraints.Length;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
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
    @NotBlank(message = "Name")
    @Length(min = 3, max = 50, message = "Name")
    private String name;
}
