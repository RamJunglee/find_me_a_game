package com.github.junglee.domain;

import java.util.Set;

import javax.annotation.Resource;

import org.springframework.data.redis.core.ZSetOperations;
import org.springframework.stereotype.Repository;

@Repository
public class GameTableScore {

	long templateId;
	long gameId;
	long score;
	
	@Resource(name="redisTemplate")
	private ZSetOperations<Long, Long> zSetOps;

	public Long getBestGame(Long templateId) {
		Set<Long> topGame = zSetOps.range(templateId, 0, 1);
		if (topGame.size() != 1) {
			return null;
		}

		return topGame.iterator().next();
	}

	public void saveNew(Long templateId, Long gameID, Double score) {
		zSetOps.add(templateId, gameID, score);
	}
}
