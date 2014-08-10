package com.nyuwa.path;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

import com.nyuwa.Entity.NyuwaEntity;
import com.nyuwa.path.astar.AStarAlgorithm;
import com.nyuwa.path.astar.AStarFinderType;

public class PathFinder {

	private int gridWidth;
	private int gridHeight;

	private int[][] grid;
	private int[][] blankGrid;

	private Set<NyuwaEntity> ignoredEntities = new HashSet<NyuwaEntity>();

	public PathFinder(int width, int height) {
		this.gridWidth = width;
		this.gridHeight = height;
	}

	public void initBlankGrid() {
		this.blankGrid = new int[gridHeight][gridWidth];

		for (int i = 0; i < this.gridHeight; i++) {
			for (int j = 0; j < this.gridWidth; j++) {
				this.blankGrid[i][j] = 0;
			}
		}
	}

	public List<Position2D> findPath(int[][] grid, NyuwaEntity entity,
			Position2D dstPos, boolean findIncomplete) {
		Position2D srcPos = entity.getPos();

		this.grid = grid;
		this.applyIgnoreList_(true);

		List<Position2D> path = AStarAlgorithm.AStar(this.grid, srcPos, dstPos, AStarFinderType.Default);

		if (path.isEmpty() && findIncomplete) {

			path = this.findIncompletePath_(srcPos, dstPos);
		}

		return path;
	}

	public List<Position2D> findIncompletePath_(Position2D srcPos, Position2D dstPos) {

		List<Position2D> perfect = AStarAlgorithm.AStar(this.blankGrid, srcPos, dstPos, AStarFinderType.Default);

		boolean isFollowingNodeBlocked = false;
		
		for (int i = perfect.size() - 1; i > 0; i -= 1) {
			int x = perfect.get(i).getX();
			int y = perfect.get(i).getY();

			if (this.grid[y][x] == 1)
			{
				isFollowingNodeBlocked = true;
			}
			
			// not pass
			if (isFollowingNodeBlocked && this.grid[y][x] == 0) {
				return AStarAlgorithm.AStar(this.grid, srcPos, perfect.get(i), AStarFinderType.Default);
			}
		}

		return null;
	}

	/**
	 * Removes colliding tiles corresponding to the given entity's position in
	 * the pathing grid.
	 */
	private void ignoreEntity(NyuwaEntity entity) {

		this.ignoredEntities.add(entity);
	}

	private void applyIgnoreList_(boolean ignored) {
		int x = 0;
		int y = 0;

		for (NyuwaEntity entity : this.ignoredEntities) {
			x = entity.isMoving() ? entity.getNextPos().getX() : entity
					.getPos().getX();
			y = entity.isMoving() ? entity.getNextPos().getY() : entity
					.getPos().getY();

			if (x >= 0 && y >= 0) {
				this.grid[y][x] = ignored ? 0 : 1;
			}
		}
	}

	public int getGridWidth() {
		return gridWidth;
	}

	public int getGridHeight() {
		return gridHeight;
	}


}
