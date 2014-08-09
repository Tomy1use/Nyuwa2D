package com.nyuwa.widget;

import com.nyuwa.common.Camera2D;
import com.nyuwa.common.ICanvas;

public class FrameSprite extends Sprite {
	protected int frameHeight;
	protected int frameWidth;
	protected int frameY;
	protected int frameX;
			
	public void draw(ICanvas canvas, Camera2D camera2d)
	{
		canvas.drawImage(this.image,
				this.frameX,
				this.frameY,
				this.frameWidth,
				this.frameHeight,
				this.pos.x-camera2d.x,
				this.pos.y-camera2d.y,
				this.frameWidth,
				this.frameHeight);
	}
}
