package com.github.junglee.service;

import org.springframework.stereotype.Service;

import com.github.junglee.domain.GameState;

@Service
public class GameService {

	public int join(int templateId, int userId) {
// find game id for given templateid from redis sorted set
		// if not found create new game table
		// save gameid in redis
		// save game object in pg
		// return gameid
		return 0;
	}

	public int changeState(int gameId, GameState gameState) {
		// get data from pg
		// get game id from redis sorted set using game.templateId
		// update game score
		return 0;
	}

}
