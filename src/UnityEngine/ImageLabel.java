package UnityEngine;
/* Swingサンプル */

import javax.swing.ImageIcon;
import javax.swing.JLabel;

public class ImageLabel extends GameObject {
	private JLabel label;
	private int sizeX;
	private int sizeY;

	public ImageLabel(String name, String fileName, Vector2 pos){
		super(name);
		ImageIcon icon = new ImageIcon(fileName);
		sizeX = icon.getIconWidth();
		sizeY = icon.getIconHeight();

		label = new JLabel();
		label.setIcon(icon);
		setJLabel(label);
		transform.position=pos;
		transform.localScale = new Vector2(sizeX, sizeY);
	}
	public ImageLabel(String name, String fileName){
		this(name, fileName, new Vector2(0, 0));
	}
	public ImageLabel(String fileName){
		this("test", fileName, new Vector2(0, 0));
	}
	public GameObject getGO(){
		return this;
	}

	//ikou iranai
	public float getSizeX(){
		return transform.localScale.x;
	}
	public float getSizeY(){
		return transform.localScale.y;
	}

	/*
	public void paintComponent(Graphics g){
		super.paintComponent(g);

	}
	 */
}
