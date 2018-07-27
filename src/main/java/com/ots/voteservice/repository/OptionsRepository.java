package com.ots.voteservice.repository;

import com.ots.voteservice.entity.Options;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import javax.transaction.Transactional;

public interface OptionsRepository extends CrudRepository<Options, Integer> {
}
