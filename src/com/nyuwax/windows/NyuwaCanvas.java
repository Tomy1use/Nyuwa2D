package com.nyuwax.windows;


import java.awt.Graphics;

import com.nyuwa.common.ICanvas;
import com.nyuwa.common.IImage;

public class NyuwaCanvas implements ICanvas{
	
	private Graphics canvas;
	
	public NyuwaCanvas(Graphics canvas)
	{
		this.canvas = canvas;	
	}
	
	@Override
	public void drawImage(IImage image, int x, int y) {
		NyuwaImage nyuwaImage = (NyuwaImage)image;
		
		canvas.drawImage(nyuwaImage.getBitmap(), x, y, null);
	}

	@Override
	public void drawImage(IImage image, int srcX, int srcY, int srcWidth,
			int srcHeight, int dstX, int dstY, int dstWidth, int dstHeight) {
		NyuwaImage nyuwaImage = (NyuwaImage)image;
		

		canvas.drawImage(nyuwaImage.getBitmap(), 
				dstX, dstY, dstX + dstWidth, dstY + dstHeight,
				srcX, srcY, srcX + srcWidth, srcY + srcHeight, null);
				
	}

}
