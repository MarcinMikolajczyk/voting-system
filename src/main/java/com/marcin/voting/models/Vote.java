package com.marcin.voting.models;

import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Entity
@Table(name = "Votes")
@NoArgsConstructor @Data
public class Vote {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ID")
    private Long id;

    @ManyToOne
    private Voter voter;

    @ManyToOne
    private Project project;

    @Column(name = "VOTE_FOR")
    private boolean voteFor;

}
