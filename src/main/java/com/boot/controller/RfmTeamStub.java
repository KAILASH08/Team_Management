package com.boot.controller;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.boot.model.RfmTeam;

public class RfmTeamStub {
	private static Map<Long, RfmTeam> wrecks = new HashMap<Long, RfmTeam>();
	private static Long idIndex = 3L;

	public static List<RfmTeam> list() {
		return new ArrayList<RfmTeam>(wrecks.values());
	}

	public static RfmTeam create(RfmTeam wreck) {
		idIndex += idIndex;
		wreck.setId(idIndex);
		wrecks.put(idIndex, wreck);
		return wreck;
	}

	public static RfmTeam get(Long id) {
		return wrecks.get(id);
	}

	public static RfmTeam update(Long id, RfmTeam wreck) {
		wrecks.put(id, wreck);
		return wreck;
	}

	public static RfmTeam delete(Long id) {
		return wrecks.remove(id);
	}
}
