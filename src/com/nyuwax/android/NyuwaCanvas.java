package com.nyuwax.android;

import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Rect;

import com.nyuwa.common.ICanvas;
import com.nyuwa.common.IImage;

public class NyuwaCanvas implements ICanvas{
	
	private Canvas canvas;
	private Paint paint = new Paint();
	
	public NyuwaCanvas(Canvas canvas)
	{
		this.canvas = canvas;
		
		paint.setTextSize(10);
		paint.setFlags(Paint.ANTI_ALIAS_FLAG);
		paint.setColor(Color.WHITE);
	}
	
	@Override
	public void drawImage(IImage image, int x, int y) {
		NyuwaImage nyuwaImage = (NyuwaImage)image;
		
		canvas.drawBitmap(nyuwaImage.getBitmap(), x, y, paint);
	}

	@Override
	public void drawImage(IImage image, int srcX, int srcY, int srcWidth,
			int srcHeight, int dstX, int dstY, int dstWidth, int dstHeight) {
		NyuwaImage nyuwaImage = (NyuwaImage)image;
		
		Rect src = new Rect(srcX, srcY, srcX + srcWidth, srcY + srcHeight);
		Rect dst = new Rect(dstX, dstY, dstX + dstWidth, dstY + dstHeight);
		canvas.drawBitmap(nyuwaImage.getBitmap(), src, dst, paint);
				
	}

}
