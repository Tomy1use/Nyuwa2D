package com.nyuwa.path.astar.finder;

import java.util.List;

import com.nyuwa.path.astar.PathNode;

public class AStarFinderDiagonalSuccessorsFree implements IAStarFinder {

	@Override
	public List<PathNode> find(boolean canGotoN, boolean canGotoS,
			boolean canGotoE, boolean canGotoW, int N, int S, int E, int W,
			int[][] grid, int rows, int cols,
			List<PathNode> nextAvailablePositions) {

		if (E < cols) {
			if (N > -1 && grid[N][E] == 0) {
				nextAvailablePositions.add(new PathNode(E, N));
			}
			if (S < rows && grid[S][E] == 0) {
				nextAvailablePositions.add(new PathNode(E, S));
			}
		}
		if (W > -1) {
			if (N > -1 && grid[N][W] == 0) {
				nextAvailablePositions.add(new PathNode(W, N));
			}

			if (S < rows && grid[S][W] == 0) {
				nextAvailablePositions.add(new PathNode(W, S));
			}
		}

		return nextAvailablePositions;
	}

}
