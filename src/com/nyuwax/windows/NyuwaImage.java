package com.nyuwax.windows;

import java.awt.Image;

import com.nyuwa.common.IImage;

public class NyuwaImage implements IImage {

	Image bitmap;
	
	public NyuwaImage(Image bitmap)
	{
		this.bitmap = bitmap;
	}
	
	public Image getBitmap()
	{
		return bitmap;
	}
	
	@Override
	public int getWidth() {

		return bitmap.getWidth(null);
	}

	@Override
	public int getHeight() {

		return bitmap.getHeight(null);
	}
}
