package com.nyuwa.widget;

public class AnimationSequence {
	public final int startRow;
	public final int startColumn;
	public final int endRow;
	public final int endColumn;
    
    private boolean singleFrame;
    
    public AnimationSequence(int startRow, int startColumn, int endRow, int endColumn)
    {
    	this.startRow = startRow;
        this.startColumn = startColumn;
        this.endRow = endRow;
        this.endColumn = endColumn;
    
        this.singleFrame = false;
    }
    
    public boolean isSingleFrame()
    {
    	return this.singleFrame;    			
    }
}
