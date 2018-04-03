package UnityEngine;
/* Swingサンプル */

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JLabel;
import javax.swing.ImageIcon;
import java.awt.Container;
import java.awt.BorderLayout;

class SampleImage extends JFrame{
	public static void main(String args[]){
		SampleImage frame = new SampleImage("タイトル");
		frame.setVisible(true);
	}

	SampleImage(String title){
		setTitle(title);
		setBounds(100, 100, 300, 250);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

		JPanel p = new JPanel();

		ImageIcon icon1 = new ImageIcon("./image.png");
		ImageIcon icon2 = new ImageIcon("./hasami.png");

		JLabel label1 = new JLabel(icon1);

		JLabel label2 = new JLabel();
		label2.setIcon(icon2);

		p.add(label1);
		p.add(label2);

		Container contentPane = getContentPane();
		contentPane.add(p, BorderLayout.CENTER);
	}
}
