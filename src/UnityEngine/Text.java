package UnityEngine;

import java.awt.Font;
import javax.swing.JLabel;

public class Text extends Renderer {
	private String text="New Text";
	public Font font;
	public int fontStyle;
	private int fontSize=16;
	public Text(){
		super();
		setjLabel(new JLabel(text));
		fontSize=getjLabel().getFont().getSize();
		fontStyle=getjLabel().getFont().getStyle();
	}
	public void setText(String text){
		getjLabel().setText(text);
	}
	public String getText(){
		return text;
	}
	public int getFontSize() {
		return fontSize;
	}
	public void setFontSize(int fontSize) {
		this.fontSize = fontSize;
		Font font=getjLabel().getFont();

		getjLabel().setFont(new Font(font.getFontName(), font.getStyle(), fontSize) );
	}

}
