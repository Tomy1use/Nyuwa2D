package com.nyuwa.path.astar.finder;

import java.util.List;

import com.nyuwa.path.astar.PathNode;

/**
 * 可以斜着走
 * @author Tomy
 *
 */
public class AStarFinderDiagonalSuccessors implements IAStarFinder {

	@Override
	public List<PathNode> find(boolean canGotoN, boolean canGotoS,
			boolean canGotoE, boolean canGotoW, int N, int S, int E, int W,
			int[][] grid, int rows, int cols,
			List<PathNode> nextAvailablePositions) {

		if(canGotoN) {
            if (canGotoE && grid[N][E] == 0)
            	{
            	nextAvailablePositions.add(new PathNode(E, N));
            	}
            if (canGotoW && grid[N][W] == 0)
            	{
            	nextAvailablePositions.add(new PathNode(W, N));
            	}
        }
		
        if(canGotoS){
            if (canGotoE && grid[S][E] == 0)
            	{
            	nextAvailablePositions.add(new PathNode(E, S));
            	}
            if (canGotoW && grid[S][W] == 0)
            	{
            	nextAvailablePositions.add(new PathNode(W, S));
            	}
        }
        
        return nextAvailablePositions;
	}

}
