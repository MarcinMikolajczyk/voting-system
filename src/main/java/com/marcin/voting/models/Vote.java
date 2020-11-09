package com.marcin.voting.models;

import lombok.*;
import javax.persistence.*;
import java.util.Objects;
import java.util.UUID;

@Entity
@Table(name = "Votes")
@NoArgsConstructor
@Getter @Setter
public class Vote extends BaseEntity{

    @ManyToOne
    private Voter voter;
    @ManyToOne
    private Project project;
    @Column(name = "VOTE_FOR")
    private boolean voteFor;


    @Override
    public int hashCode() {
        return 12;
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
        Vote other = (Vote) obj;
        return (id != null && id.equals(other.getId()));
    }

}
