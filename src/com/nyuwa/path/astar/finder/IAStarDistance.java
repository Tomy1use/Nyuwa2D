package com.nyuwa.path.astar.finder;

import com.nyuwa.path.astar.PathNode;

public interface IAStarDistance {
	public int calc(PathNode from, PathNode to);
}
