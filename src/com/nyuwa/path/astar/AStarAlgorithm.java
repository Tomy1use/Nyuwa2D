package com.nyuwa.path.astar;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import com.nyuwa.path.Position2D;
import com.nyuwa.path.astar.finder.AStarDistanceDiagonal;
import com.nyuwa.path.astar.finder.AStarDistanceEuclidean;
import com.nyuwa.path.astar.finder.AStarDistanceManhattan;
import com.nyuwa.path.astar.finder.AStarFinderDiagonalSuccessors;
import com.nyuwa.path.astar.finder.AStarFinderDiagonalSuccessorsFree;
import com.nyuwa.path.astar.finder.AStarFinderNothingToDo;
import com.nyuwa.path.astar.finder.IAStarDistance;
import com.nyuwa.path.astar.finder.IAStarFinder;

public class AStarAlgorithm {

	/**
	 * 
	 * @param grid grid[x][y] == 0 表示可以通过
	 * @param start
	 * @param end
	 * @param f
	 * @return
	 */
	public static List<Position2D> AStar(int[][] grid, Position2D start,
			Position2D end, AStarFinderType f) {
		int cols = grid[0].length;
		int rows = grid.length;

		List<Position2D> result = new ArrayList<Position2D>();

		List<PathNode> openNodes = new ArrayList<PathNode>();
		PathNode startNode = new PathNode(start.getX(), start.getY(), 0, 0,
				start.getX() + start.getY() * cols);
		openNodes.add(startNode);

		PathNode endNode = new PathNode(end.getX(), end.getY(), 0, 0,
				end.getX() + end.getY() * cols);

		IAStarDistance distance = null;
		IAStarFinder findAlgorithm = null;
		switch (f) {
		case Diagonal:
			findAlgorithm = new AStarFinderDiagonalSuccessors();
			distance = new AStarDistanceDiagonal();
			break;

		case DiagonalFree:
			distance = new AStarDistanceDiagonal();
			break;

		case Euclidean:
			findAlgorithm = new AStarFinderDiagonalSuccessors();
			distance = new AStarDistanceEuclidean(false);
			break;

		case EuclideanFree:
			distance = new AStarDistanceEuclidean(true);
			break;

		default:
			distance = new AStarDistanceManhattan();
			findAlgorithm = new AStarFinderNothingToDo();
			break;
		}
		if (findAlgorithm == null) {
			findAlgorithm = new AStarFinderDiagonalSuccessorsFree();
		}

		Set<Integer> pickedUpNodeIds = new HashSet<Integer>();
		pickedUpNodeIds.add(startNode.nodeId);
		
		do {
			int max = Integer.MAX_VALUE;
			int minPos = 0;
			for (int i = 0; i < openNodes.size(); ++i) {
				int iterDist = openNodes.get(i).distF;
				if (iterDist < max) {
					max = iterDist;
					minPos = i;
				}
			}

			PathNode optimalNode = openNodes.get(minPos);
			openNodes.remove(minPos);
			
			if (optimalNode.nodeId != endNode.nodeId) {
				
				List<PathNode> neighbors = findNeighborNodes(findAlgorithm, optimalNode, grid, rows, cols);
				for (int i = 0, size = neighbors.size(); i < size; ++i) {

					PathNode adj = neighbors.get(i);
					adj.nextNode = optimalNode;
					adj.distF = adj.distG = 0;
					adj.nodeId = adj.pos.getX() + adj.pos.getY() * cols;

					if (!isSetContains(pickedUpNodeIds, adj.nodeId)) {
						adj.distG = optimalNode.distG + distance.calc(adj, optimalNode);
						adj.distF = adj.distG + distance.calc(adj, endNode);

						openNodes.add(adj);
						pickedUpNodeIds.add(adj.nodeId);
					}
				}
			} else {
				PathNode pathNode = endNode;
				do {
					result.add(0, pathNode.pos);

					pathNode = pathNode.nextNode;
				} while (pathNode != null);

				return result;
			}
		} while (!openNodes.isEmpty());

		return result;
	}

	private static List<PathNode> findNeighborNodes(IAStarFinder findAlgorithm, PathNode pathNode,
			int[][] grid, int rows, int cols) {
		int x = pathNode.pos.getX();
		int y = pathNode.pos.getY();

		int N = y - 1;
		int S = y + 1;
		int E = x + 1;
		int W = x - 1;

		boolean canGotoN = false;
		if (N > -1) {
			canGotoN = grid[N][x] == 0;
		}

		boolean canGotoS = false;
		if (S < rows) {
			canGotoS = grid[S][x] == 0;
		}

		boolean canGotoE = false;
		if (E < cols) {
			canGotoE = grid[y][E] == 0;
		}

		boolean canGotoW = false;
		if (W > -1) {
			canGotoW = grid[y][W] == 0;
		}

		List<PathNode> nextAvailablePositions = new ArrayList<PathNode>();
		if (canGotoN) {
			nextAvailablePositions.add(new PathNode(x, N));
		}

		if (canGotoE) {
			nextAvailablePositions.add(new PathNode(E, y));
		}
		if (canGotoS) {
			nextAvailablePositions.add(new PathNode(x, S));
		}

		if (canGotoW) {
			nextAvailablePositions.add(new PathNode(W, y));
		}

		return findAlgorithm.find(canGotoN, canGotoS, canGotoE, canGotoW, N, S, E, W,
				grid, rows, cols, nextAvailablePositions);
	}
	
	private static boolean isSetContains(Set<Integer> flagSets, int nodeId)
	{
		for (Integer item : flagSets)
		{
			if (item.intValue() == nodeId)
			{
				return true;
			}
		}
		return false;
	}

}
