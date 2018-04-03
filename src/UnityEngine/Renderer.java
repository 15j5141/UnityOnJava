package UnityEngine;

import java.awt.Color;
import java.awt.Dimension;

import javax.swing.JLabel;

public class Renderer extends MyUComponent{
	private JLabel jLabel;
	public JLabel getjLabel() { return jLabel; }
	public void setjLabel(JLabel jLabel) { this.jLabel = jLabel;}
	public Color color=new Color(0, 0, 0);
	public Renderer() {
		super();
	}

	public Dimension size=new Dimension(0, 0);
}
