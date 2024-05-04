package com.iheb.sport.entities;



import com.fasterxml.jackson.annotation.JsonIgnore;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

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
