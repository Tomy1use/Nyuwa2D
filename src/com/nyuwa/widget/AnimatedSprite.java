package com.nyuwa.widget;

import java.util.HashMap;
import java.util.Map;

import com.nyuwa.common.IImage;

public class AnimatedSprite extends FrameSprite {
	private double lastElapsed;
	private long framesPerSecond = 3;
	private long msPerFrame = 1000 / framesPerSecond;
	
	private AnimationSequence currentSequence;
	private Map<String, AnimationSequence> Sequences = new HashMap<String, AnimationSequence>();
	
	private int columns;
	private int rows;
	
	private boolean playing;
	private boolean looping;
	
	public AnimatedSprite(IImage image, int frameWidth, int frameHeight)
	{
		this.image = image;
		this.setFrameWidth(frameWidth);
		this.setFrameHeight(frameHeight);
	}
	
	public void setFramePerSecond(long f)
	{
		this.framesPerSecond = f;
		msPerFrame = 1000 / framesPerSecond;
	}
	
	public void update(long timeDelta)
	{
		if (this.currentSequence.isSingleFrame()) {
	        return;
	    }
		
	    if (!this.playing) {
	        return;
	    }

	    this.lastElapsed -= timeDelta;
	    
	    if (this.lastElapsed > 0) {
	        return;
	    }
	    
	    this.lastElapsed = this.msPerFrame;
	    this.frameX += this.frameWidth;
	    
	    //increment the frame
	    if (this.frameX > (this.getImageWidth() - this.frameWidth)) {
	        this.frameX = 0;
	        this.frameY += this.frameHeight;
	        
	        if (this.frameY > (this.getImageHeight() - this.frameHeight)) {
	            this.frameY = 0;
	        }
	    }
	    
	    //check if it's at the end of the animation sequence
	    boolean seqEnd = false;
	    if ((this.frameX > (this.currentSequence.endColumn * this.frameWidth)) && (this.frameY == (this.currentSequence.endRow * this.frameHeight))) {
	        seqEnd = true;
	    } else if (this.frameX == 0 && (this.frameY > (this.currentSequence.endRow * this.frameHeight))) {
	        seqEnd = true;
	    }
	    
	    //go back to the beginning if looping, otherwise stop playing
	    if (seqEnd) {
	        if (this.looping) {
	            this.frameX = this.currentSequence.startColumn * this.frameWidth;
	            this.frameY = this.currentSequence.startRow * this.frameHeight;
	        } else {
	            this.playing = false;
	        }
	    }
	}
	
	public void playSequence(String seqName, boolean loop) {
	    this.playing = true;
	    this.looping = loop;
	    this.currentSequence = this.Sequences.get(seqName);
	    this.frameX = this.currentSequence.startColumn * this.frameWidth;
	    this.frameY = this.currentSequence.startRow * this.frameHeight;
	}

	public void stopLooping(){
	    this.looping = false;
	}

	public void stopPlaying() {
	    this.playing = false;
	}

	public void setFrameWidth(int width) {
	    this.frameWidth = width;
	    this.rows = this.getImageWidth() / this.frameWidth;
	}

	public void setFrameHeight(int height) {
	    this.frameHeight = height;
	    this.columns = this.getImageHeight() / this.frameHeight;
	}

	public void setColumnCount(int columnCount) {
	    this.frameWidth = this.getImageWidth() / columnCount;
	    this.columns = columnCount;
	}

	public void setRowCount(int rowCount) {
	    this.frameHeight = this.getImageHeight() / rowCount;
	    this.rows = rowCount;
	}

	public void addExistingSequence(String name, AnimationSequence sequence) {
	    this.Sequences.put(name, sequence);
	}

	public void addNewSequence(String name, int startRow, int startColumn, int endRow, int endColumn) {
		this.Sequences.put(name, new AnimationSequence(startRow, startColumn, endRow, endColumn));
	}

	public void deleteSequence(int name) {
		this.Sequences.remove(name);
	}

	public void clearSequences() {
		this.Sequences.clear();
	}
}
