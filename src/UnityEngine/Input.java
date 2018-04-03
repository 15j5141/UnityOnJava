package UnityEngine;

import java.awt.MouseInfo;
import java.awt.PointerInfo;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.InputEvent;

public class Input implements MouseListener, KeyListener{
	public GUI frame;
	public static boolean MouseButton[] = new boolean[MouseInfo.getNumberOfButtons()];
	public static boolean MouseButtonDown[] = new boolean[MouseInfo.getNumberOfButtons()];
	public static boolean MouseButtonUp[] = new boolean[MouseInfo.getNumberOfButtons()];
	public static boolean KeyButton[] = new boolean[256];
	public static boolean KeyButtonDown[] = new boolean[256];
	public static boolean KeyButtonUp[] = new boolean[256];


	public static void MousePointed(){
		PointerInfo p=MouseInfo.getPointerInfo();
		//System.out.println("X:"+p.getLocation().x +" Y:"+ p.getLocation().y);
	}

	@Override
	public void mouseClicked(MouseEvent e) {
		//GetMouseButtonDown =
	}
	@Override
	public void mousePressed(MouseEvent e) {
		if(e.getButton()<MouseButton.length){
			MouseButton[e.getButton()] = true;
			MouseButtonDown[e.getButton()] = true;
			//System.out.println(""+MouseButton[e.getButton()]+":"+e.getButton());
		}
	}

	@Override
	public void mouseReleased(MouseEvent e) {
		if(e.getButton()<MouseButton.length){
			MouseButton[e.getButton()] = false;
			MouseButtonUp[e.getButton()] = true;
		}
	}
	@Override
	public void mouseEntered(MouseEvent e) {
	}
	@Override
	public void mouseExited(MouseEvent e) {
	}
	public static boolean GetMouseButton(int num){
		if(num<MouseInfo.getNumberOfButtons()){
			return MouseButton[num];
		}
		return false;
	}
	public static boolean GetMouseButtonDown(int num){
		if(num<MouseButton.length){
			boolean buf=MouseButtonDown[num];
			MouseButtonDown[num]=false;
			return buf;
		}
		return false;
	}
	public static boolean GetMouseButtonUp(int num){
		if(num<MouseButton.length){
			boolean buf=MouseButtonUp[num];
			MouseButtonUp[num]=false;
			return buf;
		}
		return false;
	}

	@Override
	public void keyTyped(KeyEvent e) {
	}
	@Override
	public void keyPressed(KeyEvent e) {
		//System.out.println(e.getKeyCode());
		KeyButton[e.getKeyCode()]=true;
		KeyButtonUp[e.getKeyCode()]=true;
	}
	@Override
	public void keyReleased(KeyEvent e) {
		KeyButton[e.getKeyCode()]=false;
		KeyButtonDown[e.getKeyCode()]=true;
	}


	public static boolean GetKey(KeyCode kc) {
		return KeyButton[kc.getInt()];
	}
	public static boolean GetKeyDown(KeyCode kc) {
		return KeyButtonDown[kc.getInt()];
	}
	public static boolean GetKeyUp(KeyCode kc) {
		return KeyButtonUp[kc.getInt()];
	}


	protected static void Update(){
		for(int i=0; i<MouseButtonDown.length; i++){
			MouseButtonUp[i]=false;
			MouseButtonDown[i]=false;
		}
		for(int i=0; i<KeyButton.length; i++){
			KeyButtonUp[i]=false;
			KeyButtonDown[i]=false;
		}
	}
}
