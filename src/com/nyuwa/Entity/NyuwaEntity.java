package com.nyuwa.Entity;

import com.nyuwa.path.Position2D;
import com.nyuwa.widget.Sprite;

public class NyuwaEntity {
	private long id;
	
	private EntityType entityType;
	
	private Sprite sprite;
	
	private Position2D pos;
	private Position2D nextPos;

	public Position2D getPos() {
		return pos;
	}

	public void setPos(Position2D pos) {
		this.pos = pos;
	}
	
	public boolean isMoving()
	{
		return false;
	}

	public Position2D getNextPos() {
		return nextPos;
	}

	public void setNextPos(Position2D nextPos) {
		this.nextPos = nextPos;
	}
	
}
