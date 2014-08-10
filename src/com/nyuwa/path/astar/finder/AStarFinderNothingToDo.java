package com.nyuwa.path.astar.finder;

import java.util.List;

import com.nyuwa.path.astar.PathNode;

public class AStarFinderNothingToDo implements IAStarFinder {

	@Override
	public List<PathNode> find(boolean canGotoN, boolean canGotoS,
			boolean canGotoE, boolean canGotoW, int N, int S, int E, int W,
			int[][] grid, int rows, int cols,
			List<PathNode> nextAvailablePositions) {


		return nextAvailablePositions;
	}



}
