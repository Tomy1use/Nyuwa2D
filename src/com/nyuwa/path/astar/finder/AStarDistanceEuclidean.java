package com.nyuwa.path.astar.finder;

import com.nyuwa.path.astar.PathNode;

public class AStarDistanceEuclidean implements IAStarDistance {

	private boolean euclideanFree;
	
	public AStarDistanceEuclidean(boolean euclideanFree) 
	{
		this.euclideanFree = euclideanFree;
	}
	
	@Override
	public int calc(PathNode from, PathNode to) {
		int x = from.pos.getX() - to.pos.getX();
        int y = from.pos.getY() - to.pos.getY();

    return  euclideanFree ? (int)Math.sqrt(x * x + y * y) : (x * x + y * y);
    
	}

}
