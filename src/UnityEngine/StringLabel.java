package UnityEngine;

import java.awt.Font;
import java.awt.FontFormatException;
import java.io.IOException;
import java.io.InputStream;

import javax.swing.JLabel;

public class StringLabel extends GameObject{
	private JLabel label;


	public StringLabel(String name, String s, Vector2 pos){
		super(name);

		int size=32;
		label = new JLabel();
		label.setText(s);

		//Font font = makeFont("./image/uzura.ttf");
		//label.setFont(new Font("うずらフォント", Font.PLAIN, size));
		label.setSize(label.getPreferredSize());
		setJLabel(label);
		transform.position=pos;
		/*
		 * transform.scaleが設定してなかった（サイズ0だった）
		 */
		transform.localScale = new Vector2(label.getSize().width, label.getSize().width);
	}
	public StringLabel(String name, String s){
		this(name, s, new Vector2(0, 0));
	}
	public StringLabel(String s){
		this("test", s, new Vector2(0, 0));
	}
	public GameObject getGO(){
		return this;
	}

	public Font makeFont(String filename){
		Font font = null;
		InputStream is = null;
		try {
			is = getClass().getResourceAsStream(filename);
			System.out.println(filename);
			font = Font.createFont(Font.TRUETYPE_FONT, is);
			is.close();
		}catch(IOException e){
			e.printStackTrace();
		}catch(FontFormatException e){
			e.printStackTrace();
		}
		return font;
	}
}
