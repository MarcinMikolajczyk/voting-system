package com.marcin.voting.models;


import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.marcin.voting.json_components.serializers.ProjectSerializer;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name = "Projects")
@NoArgsConstructor @Data
@JsonSerialize(using = ProjectSerializer.class)
public class Project {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ID")
    private Long id;
    @Column(name = "VOTES")
    @OneToMany(mappedBy = "project")
    private Set<Vote> votes = new HashSet<>();
    @Column(name = "NAME", nullable = false, length = 16)
    private String name;
    @Column(name = "DESCRIPTION", nullable = false)
    private String description;
    @Column(name = "VOTABLE")
    private boolean votable;

    public Project(String name, String description) {
        this.name = name;
        this.description = description;
        votable = true;
    }
}
