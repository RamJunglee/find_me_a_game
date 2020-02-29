package com.github.junglee.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.github.junglee.domain.GameState;
import com.github.junglee.domain.GameTable;
import com.github.junglee.domain.GameTableScore;
import com.github.junglee.jpa.GameTableRepository;

@Service
public class GameService {
	@Autowired
	GameTableScore redisScoreRepository;

	@Autowired
	GameTableRepository gameTableRepository;

	@Autowired
	GameTableScoreCalculator gameScoreCalculator;

	public long join(long templateId, long userId) {

		// find game id for given templateid from redis sorted set
		Long bestGame = redisScoreRepository.getBestGame(templateId);

		if (bestGame != null) {
			redisScoreRepository.updateScore(templateId, bestGame, gameScoreCalculator.PlayerJoined());
			// asynchronously change game state
			return bestGame;
		}

		// if not found create new game table
		
		// save game object in pg
		GameTable newGameTable = gameTableRepository.save(new GameTable());
		
		// save gameid in redis
		redisScoreRepository.saveNew(newGameTable.getTemplateId(), newGameTable.getId(),
				gameScoreCalculator.calculate(newGameTable));
		
		// return gameid
		return newGameTable.getId();
	}

	public int changeState(long gameId, GameState gameState) {
		// get data from pg
		// get game id from redis sorted set using game.templateId
		// update game score
		return 0;
	}

}
