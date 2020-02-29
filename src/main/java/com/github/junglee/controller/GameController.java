package com.github.junglee.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PostMapping;

import com.github.junglee.domain.GameState;
import com.github.junglee.service.GameService;

@Controller("/game")
public class GameController {

	@Autowired
	private GameService gameService;

	@PostMapping("/join_user")
	public int joinGameTable(int templateId, int userId) {
		return gameService.join(templateId, userId);
	}

	@PatchMapping("/change")
	public int changeGameState(int gameId, GameState gameState) {
		return gameService.changeState(gameId, gameState);
	}


}
