package com.ots.voteservice.repository;

import com.ots.voteservice.entity.Voting;
import org.springframework.data.repository.CrudRepository;

import java.util.Optional;

public interface VotingRepository extends CrudRepository<Voting, Integer> {
    Optional<Voting> findByVotingId(int id);
}
