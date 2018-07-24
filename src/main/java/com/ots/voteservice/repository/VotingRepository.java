package com.ots.voteservice.repository;

import com.ots.voteservice.entity.Voting;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.Repository;

import java.util.List;

public interface VotingRepository  extends CrudRepository<Voting, Integer> {
    Voting findByLink(String link);
}
