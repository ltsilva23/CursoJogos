package br.com.mariojp.game;

import java.applet.Applet;
import java.applet.AudioClip;

public class Som {
	
	private AudioClip clip;
	
	public static final Som audio = new Som("/audio/tiro.wav");// buscar som 
	
	private Som(String name) {
		try {
			clip = Applet.newAudioClip(Som.class.getResource(name));
		}
		catch(Throwable e) {}
	}
		public void play() {
			try {
				
				new Thread() {
					public void run() {
						clip.play();
					}
				}.start();
			}
			catch(Throwable e) {
				
			}
		}
		
	}

