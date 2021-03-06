package com.marcin.voting.models;

import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.marcin.voting.json_components.serializers.VoterSerializer;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Objects;
import java.util.Set;
import java.util.UUID;

@Entity
@Table(name = "Voters")
@NoArgsConstructor
@Getter @Setter
@JsonSerialize(using = VoterSerializer.class)
public class Voter extends BaseEntity{


    @Column(name = "FIRST_NAME", length = 16)
    private String firstName;

    @Column(name = "LAST_NAME", length = 16)
    private String lastName;

    @Column(name = "VOTE_ID", length = 11, unique = true, updatable = false)
    private String voteId;

    @OneToMany(mappedBy = "voter")
    private Set<Vote> votes = new HashSet<>();

    public Voter(String firstName, String lastName, String voteId) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.voteId = voteId;
    }

    @Override
    public int hashCode() {
        return 17;
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
        Voter other = (Voter) obj;
        return (id != null && id.equals(other.getId()));
    }
}
