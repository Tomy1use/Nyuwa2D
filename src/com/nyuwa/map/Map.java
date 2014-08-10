package com.nyuwa.map;

import com.nyuwa.path.Position2D;

public class Map {
	
	private int[][] grid;
	
	public boolean isColliding(Position2D pos)
	{
		return grid[pos.getX()][pos.getY()] == 1;
	}
}
