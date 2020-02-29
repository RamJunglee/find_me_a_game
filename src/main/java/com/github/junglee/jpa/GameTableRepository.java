package com.github.junglee.jpa;

import org.springframework.data.repository.CrudRepository;

import com.github.junglee.domain.GameTable;


public interface GameTableRepository extends CrudRepository<GameTable, Long> {

}
