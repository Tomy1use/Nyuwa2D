package com.nyuwa.common;

import java.util.Timer;
import java.util.TimerTask;

public class GameTimer extends TimerTask {

	private Timer gameTimer = new Timer("GameTimer");
	
	private final long framePerSeconds = 30;
	private final long msPerFrame = 1000 / framePerSeconds;
	private long lastTime = 0;

	private ITimerTick timerTick;
	
	public GameTimer(ITimerTick timerTick)
	{
		this.timerTick = timerTick;
	}

	public void Start() {
		this.gameTimer.schedule(this, this.msPerFrame, this.msPerFrame);

		this.lastTime = System.currentTimeMillis();
	}

	private void tick() {
		
			long newTime = System.currentTimeMillis();
			long delta = (newTime - this.lastTime);
			this.lastTime = newTime;

			this.timerTick.updateTick(delta);
	}

	public void stop() {
		this.gameTimer.cancel();
	}

	@Override
	public void run() {
			
		this.tick();
	}
}

