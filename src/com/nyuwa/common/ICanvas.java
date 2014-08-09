package com.nyuwa.common;

public interface ICanvas {
	
	public void drawImage(IImage image,
			int x,
			int y);
			
	public void drawImage(IImage image,
			int srcX,
			int srcY,
			int srcWidth,
			int srcHeight,
			int dstX,
			int dstY,
			int dstWidth,
			int dstHeight);

}
