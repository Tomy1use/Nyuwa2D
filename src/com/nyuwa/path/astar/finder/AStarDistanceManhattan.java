package com.nyuwa.path.astar.finder;

import com.nyuwa.path.astar.PathNode;

public class AStarDistanceManhattan implements IAStarDistance {

	@Override
	public int calc(PathNode from, PathNode to) {
		return Math.abs(from.pos.getX() - to.pos.getX()) + Math.abs(to.pos.getY() - to.pos.getY());
	}

}
