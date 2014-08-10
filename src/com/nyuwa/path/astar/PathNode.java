package com.nyuwa.path.astar;

import com.nyuwa.path.Position2D;

public class PathNode {
	
	public Position2D pos;
	int distF;
	int distG;
	int nodeId;
	PathNode nextNode;
	
	public PathNode(int x, int y)
	{
		this.pos = new Position2D(x, y);
	}
	
	public PathNode(int x, int y, int f, int g, int id)
	{
		this.pos = new Position2D(x, y);
		
		this.distF = f;
		this.distG = g;
		this.nodeId = id;
	}
}
