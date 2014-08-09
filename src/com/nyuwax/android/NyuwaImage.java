package com.nyuwax.android;

import android.graphics.Bitmap;

import com.nyuwa.common.IImage;

public class NyuwaImage implements IImage {

	Bitmap bitmap;
	
	public NyuwaImage(Bitmap bitmap)
	{
		this.bitmap = bitmap;
	}
	
	public Bitmap getBitmap()
	{
		return bitmap;
	}
	
	@Override
	public int getWidth() {

		return bitmap.getWidth();
	}

	@Override
	public int getHeight() {

		return bitmap.getHeight();
	}
}
