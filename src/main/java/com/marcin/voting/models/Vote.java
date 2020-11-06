package com.marcin.voting.models;

import lombok.*;
import javax.persistence.*;
import java.util.Objects;
import java.util.UUID;

@Entity
@Table(name = "Votes")
@NoArgsConstructor
@Getter @Setter
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

    private String uuid = UUID.randomUUID().toString();

    @Override
    public boolean equals(Object o) {
        return this == o || o instanceof Vote
                && Objects.equals(uuid, ((Vote) o).uuid);
    }

    @Override
    public int hashCode() {
        return Objects.hash(uuid);
    }

}
