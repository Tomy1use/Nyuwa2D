package com.nyuwa.widget;

import com.nyuwa.common.Camera2D;
import com.nyuwa.common.ICanvas;
import com.nyuwa.common.IImage;
import com.nyuwa.common.WidgetPos;

public class Sprite {
	protected WidgetPos pos = new WidgetPos(0, 0);
	protected IImage image;

	public void draw(ICanvas canvas, Camera2D camera2d) 
	{
		canvas.drawImage(this.image, 
				this.pos.x - camera2d.x, 
				this.pos.y - camera2d.y);
	}
	
	public int getImageWidth()
	{
		return image.getWidth();
	}
	
	public int getImageHeight()
	{
		return image.getHeight();
	}
}
