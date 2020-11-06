package com.marcin.voting.models;


import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.marcin.voting.json_components.serializers.ProjectSerializer;
import lombok.*;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Objects;
import java.util.Set;
import java.util.UUID;

@Entity
@Table(name = "Projects")
@NoArgsConstructor
@Getter @Setter
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

    private String uuid = UUID.randomUUID().toString();

    public Project(String name, String description) {
        this.name = name;
        this.description = description;
        votable = true;
    }

    @Override
    public boolean equals(Object o) {
       return this == o || o instanceof Project
               && Objects.equals(uuid, ((Project) o).uuid);
    }

    @Override
    public int hashCode() {
        return Objects.hash(uuid);
    }
}
