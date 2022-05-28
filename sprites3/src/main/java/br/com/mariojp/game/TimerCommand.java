package br.com.mariojp.game;

import javax.swing.Timer;

public class TimerCommand {

	private Timer timer;

    public TimerCommand(Timer timer) {
        this.timer = timer;
    }

    public void execute() {
        timer.start();
    }

    public void stop() {
        timer.stop();
    }
}
