package com.nyuwa.Entity;

import java.util.ArrayList;
import java.util.List;

import com.nyuwa.path.Position2D;

public class Character extends NyuwaEntity {
	// Position and orientation
	private int nextGridX = -1;
	private int nextGridY = -1;
	private CharacterOrientations orientation = CharacterOrientations.DOWN;

	// Speeds
	private int atkSpeed = 50;
	private int moveSpeed = 120;
	private int walkSpeed = 100;
	private int idleSpeed = 450;
	private int attackRate = 800;

    // Pathing
	//private int movement = new Transition();
	private List<Position2D> path;
	private int newDestination;
	private int adjacentTiles;
	private int step;

	// Combat
	private Character target;
	private Character unconfirmedTarget;
	private List<Character> attackers;

    // Health
	private int hitPoints = 0;
	private int maxHitPoints = 0;

    // Modes
	private boolean isDead;
	private boolean attackingMode;
	private boolean followingMode;	
	
	public void moveTo(Position2D dstPos) {

        if(this.isMoving()) {
            this.continueMoveTo(dstPos);
        }
        else {
            List<Position2D> path = this.requestPathfindingTo(dstPos);
        
            this.followPath(path);
        }
    }
	
	private void continueMoveTo(Position2D dstPos) {
	}
	
	private List<Position2D> requestPathfindingTo(Position2D dstPos)
	{
		 List<NyuwaEntity> ignored = new ArrayList<NyuwaEntity>();
		 
		 // Always ignore self
		 ignored.add(this);
         
         if (this.target != null) {
             ignored.add(this.target);
         }
         
         return this.findPath(this, dstPos.getX(), dstPos.getY(), ignored);
	}
	
	private List<Position2D> findPath(Character character, int x, int y, List<NyuwaEntity> ignoreList) {
		List<Position2D> path = new ArrayList<Position2D>();
          /*  grid = this.pathingGrid;

            isPlayer = (character === this.player);
    
        if(this.map.isColliding(x, y)) {
            return path;
        }
    
        if(this.pathfinder && character) {
            if(ignoreList) {
                _.each(ignoreList, function(entity) {
                    self.pathfinder.ignoreEntity(entity);
                });
            }
        
            path = this.pathfinder.findPath(grid, character, x, y, false);
        
            if(ignoreList) {
                this.pathfinder.clearIgnoreList();
            }
        } else {
            log.error("Error while finding the path to "+x+", "+y+" for "+character.id);
        }*/
        return path;
    }
	
	private void followPath(List<Position2D> path) {
		if (path.size() > 1) { // Length of 1 means the player has clicked on himself
			this.path = path;
			this.step = 0;
		
            if (this.followingMode) { // following a character
                path.remove(path.size() - 1);
            }
		
            /*if(this.start_pathing_callback) {
                this.start_pathing_callback(path);
            }*/
            this.nextStep();
		}
	}
	
	private void nextStep() {
        boolean stop = false,
            x, y, path;
    
		/*if (this.isMoving()) {
		    if(this.before_step_callback) {
                this.before_step_callback();
            }
        
		    this.updatePositionOnGrid();
            this.checkAggro();
        
            if(this.interrupted) { // if Character.stop() has been called
                stop = true;
                this.interrupted = false;
            }
            else {
                if(this.hasNextStep()) {
                    this.nextGridX = this.path[this.step+1][0];
                    this.nextGridY = this.path[this.step+1][1];
                }
        
                if(this.step_callback) {
                    this.step_callback();
                }
		    
    			if(this.hasChangedItsPath()) {
    				x = this.newDestination.x;
    				y = this.newDestination.y;
    				path = this.requestPathfindingTo(x, y);
            
                    this.newDestination = null;
    				if(path.length < 2) {
                        stop = true;
                    }
                    else {
                        this.followPath(path);
                    }
    			}
    			else if(this.hasNextStep()) {
    				this.step += 1;
    				this.updateMovement();
    			}
                else {
                    stop = true;
                }
            }
        
		    if(stop) { // Path is complete or has been interrupted
		        this.path = null;
    			this.idle();
            
                if(this.stop_pathing_callback) {
                    this.stop_pathing_callback(this.gridX, this.gridY);
                }
    		}
    	}*/
	}
}
