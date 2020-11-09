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
public class Project extends BaseEntity{

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

    @Override
    public int hashCode() {
        return 11;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        Project other = (Project) obj;
        return (id != null && id.equals(other.getId()));
    }
}
