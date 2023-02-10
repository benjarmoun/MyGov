package com.mygov.justice.entyties;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class Employe {
    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    private Integer id;
    private String nom;
    @ManyToOne
    @JoinColumn(name = "customer_id", insertable = false, updatable = false)
    private Departement departement_id;
    private String ministere;
}
