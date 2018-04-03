package UnityEngine;
import java.awt.BorderLayout;
import java.awt.Container;
import java.awt.Font;
import java.util.ArrayList;
import java.util.List;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class GUI  extends JFrame{
	public static int OriginWidth = 800;
	public static int OriginHeight = 600;
	public static int Width = 800;
	public static int Height = 600;
	public static float magnificationX = 1f; // 倍率
	public static float magnificationY = 1f; // 倍率
	private Container contentPane;
	private JPanel jPanel;
	private List<GameObject> objects;
	int x=0, y=0;
	public GUI(String title){
		setTitle(title);
		setBounds(50, 0, OriginWidth, OriginHeight);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setLocationRelativeTo(null);
		contentPane = getContentPane();
		jPanel = new JPanel();
		jPanel.setLayout(null);
		contentPane.add(jPanel, BorderLayout.CENTER);
		//add(contentPane);
		//image = getToolkit().getImage("./image.png");
		setVisible(true);
		objects = new ArrayList<GameObject>();
		setFocusable(true);
		Input input=new Input();
		//input.Start(this);
		this.addMouseListener(input);
		this.addKeyListener(input);

	}

	public void changeWindowSize(int x, int y){
		Width = x;
		Height = y;
		magnificationX = 0f + Width / OriginWidth;
		magnificationY = 0f + Height / OriginHeight;
		setBounds(getX(), getY(), Width, Height);
	}

	/*
	 * Set, Add
	 */
	public void addGUI(GameObject g){
		objects.add(g);
		//System.out.println(g.GetComponent("JLabel"));
		JLabel label = g.getJLabel();
		Vector2 pos = g.transform.position;
		Vector2 size = g.transform.localScale;
		size = g.transform.localScale;
		label.setBounds((int)pos.x, (int)pos.y, (int)size.x * (GUI.Width / GUI.OriginWidth), (int)size.y * (GUI.Height / GUI.OriginHeight));
		jPanel.add(label);
		contentPane.revalidate();
	}
	@Override
	public void repaint(){
		contentPane.removeAll();
		jPanel = new JPanel();
		jPanel.setLayout(null);
		for(GameObject go : SceneManager.GetActiveScene().GameObjectList){
			for (Renderer renderer : go.<Renderer>GetSuperComponents()) {
				Vector2 pos=go.transform.position;
				Vector2 scale=go.transform.localScale;
				JLabel label = renderer.getjLabel();
				//label.setFont(new Font("", 0, size));
				label.setSize((int)(label.getPreferredSize().width*scale.x), (int)(label.getPreferredSize().height*scale.y));
				label.setLocation((int)pos.x, (int)pos.y);
				//System.out.println(label.getPreferredSize());
				jPanel.add(label);
			}
		}
		jPanel.add(new JLabel("dfsa"));
		contentPane.add(jPanel, BorderLayout.CENTER);
		super.revalidate();
		super.repaint();
	}
	public GameObject getGUIInPoint(Vector2 v){
//		int WIDTH = 32;
//		for(int i=0;i<objects.size(); i++){
//			if(objects.get(i).name.matches("puyo:.+")){
//				//System.out.println(objects.get(i).name);
//				int x=objects.get(i).transform.position.x;
//				int y=objects.get(i).transform.position.y - MainBoardUltimateCP.offset.y;
//				int vx = v.x*WIDTH + MainBoardUltimateCP.offset.x;
//				int vy = v.y*WIDTH;// + MainBoardUltimateCP.offset.y;
//				Vector2 xy= MainBoardUltimateCP.ADCon(x, y);
//				Vector2 vxy= MainBoardUltimateCP.ADCon(vx, vy);
//				//Vector2 vxy= new Vector2(v.x, v.y-1);
//				//System.out.println("x="+x+":y="+y+":xy.x="+xy.x +":xy.y="+ xy.y +":vxy.x="+ vxy.x +":vxy.y="+ vxy.y);
//				if(xy.x == vxy.x && xy.y == vxy.y){
//					return objects.get(i);
//				}
//			}
//		}
//
		return null;
	}
	/*
	public void paint(Graphics g){
		int sizeX = getSize().width;
		int sizeY = getSize().height;
		Image buffer = createImage(sizeX, sizeY);
		Graphics gBuffer = buffer.getGraphics();
		x+=10;
		y+=10;
		gBuffer.drawImage(image, x, y, this);
		super.paint(g);
		//g.drawImage(buffer, sizeX, sizeY, this);
	}
	 */
}
