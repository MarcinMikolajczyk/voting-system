package com.marcin.voting.models;

import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.marcin.voting.json_components.serializers.VoterSerializer;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name = "Voters")
@NoArgsConstructor @Data
@JsonSerialize(using = VoterSerializer.class)
public class Voter {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ID")
    private Long id;

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
}
