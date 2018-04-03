package UnityEngine;

import java.awt.MediaTracker;
import java.io.File;

import javax.swing.ImageIcon;
import javax.swing.JLabel;

public class SpriteRenderer extends Renderer {
	private ImageIcon sprite;
	public SpriteRenderer() {
		super();
		sprite = new ImageIcon();
		setjLabel(new JLabel(sprite));
		setSprite("./src/UnityEngine/Test.png");
	}
	public void setSprite(String s) {
		File f=new File(s);
		sprite = new ImageIcon(s);
		if(!f.exists()) {
			System.err.println("Log: Can't load image. >"+sprite);
		}else {
		}
		size.setSize(sprite.getIconWidth(), sprite.getIconHeight());
		//setjLabel(new JLabel(sprite));
		getjLabel().setIcon(sprite);
	}
	public boolean isLoaded(ImageIcon ii) {
		return false;
	}

}
