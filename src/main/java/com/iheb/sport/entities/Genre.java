package com.iheb.sport.entities;


import javax.persistence.*;
import com.fasterxml.jackson.annotation.JsonIgnore;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
public class Genre {
        @Id
        @GeneratedValue(strategy = GenerationType.IDENTITY)
        private Long idGen;
        private String nomGen;

        @JsonIgnore
        @OneToMany(mappedBy = "genre")
        private List<sport> sports;




}
