package com.ots.voteservice.repository;

import com.ots.voteservice.entity.Voting;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import javax.transaction.Transactional;
import java.util.Optional;


public interface VotingRepository extends CrudRepository<Voting, Integer> {
    Optional<Voting> findByVotingId(int id);
}
