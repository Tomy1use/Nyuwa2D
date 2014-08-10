package com.nyuwa.path.astar.finder;

import com.nyuwa.path.astar.PathNode;

public class AStarDistanceDiagonal implements IAStarDistance {

	@Override
	public int calc(PathNode from, PathNode to) {
		return Math.max(Math.abs(from.pos.getX() - to.pos.getX()),
				Math.abs(from.pos.getY() - to.pos.getY()));
	}

}
