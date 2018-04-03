/*

import java.awt.Container;

import javax.swing.JOptionPane;

import UnityEngine.GUI;
import UnityEngine.Input;
import UnityEngine.MainBird;
import UnityEngine.MainBoardUltimateCP;
import UnityEngine.MainChain;
import UnityEngine.MainForceFall;
import UnityEngine.MainNexts;
import UnityEngine.MainPlayer;
import UnityEngine.StartNow;

public class Main {
	//public static int STATE=0;
	public static void test(String[] args) {
		int count = 0;

		GUI frame = new GUI("ぷよふ○よVer1.0");
		Container c =frame.getContentPane();

		StartNow.HyperStart(frame);

		frame.setContentPane(c);


		MainBird mainBird =new MainBird(frame);
		mainBird.Start();
		//MainBoard mainBoard = new MainBoard(frame);
		//mainBoard.Start();
		MainNexts mn = new MainNexts(frame);
		mn.Start();
		mn.Update(mainBird.getNextPuyos());
		MainPlayer mp = new MainPlayer(frame);
		mp.Start();
		Input input = new Input();
		input.Start(frame);
		MainBoardUltimateCP mainBoardU = new MainBoardUltimateCP(frame);
		mainBoardU.Start();
		MainForceFall mff=new MainForceFall(frame);
		mff.Start();
		MainChain mc = new MainChain();
		mc.Start(frame);

		while(true){
			switch(MainBird.STATE) {
			case 0://Controll player
				if(count%10==0){
					mp.Update();
				}
				if(count%60==0){
					//mainBoardU.DigitalBoardPrint();

				}
				if(count%6==0){
					mainBird.Update();
				}
				mainBoardU.Update();
				break;
			case 1://to 2
				//				System.out.println(MainBird.STATE);
				mp.Update();
				MainBird.STATE++;
				break;
			case 2://ForceFall
				//				System.out.println(MainBird.STATE);
				mainBoardU.BoardUpdate3();
				mff.setBoard(mainBoardU.board);
				mff.Update();
				//				mainBoardU.board=mff.getBoard();
				//				mff.Update();
				MainBird.STATE++;
				break;
			case 3:
				MainBird.STATE++;
				break;
			case 4:
				MainBird.STATE++;
				mainBoardU.BoardUpdate3();
				mc.Update(mainBoardU.board);
				//rennsa
				break;
			case 5:
				//if to case 7

				if(MainChain.chain==0) {
					//System.out.println(MainChain.chain);
					MainBird.STATE=7;
				}else {
					MainBird.STATE++;
				}
				break;
			case 6:

				//Fall down
				mff.setBoard(mainBoardU.board);
				mff.Update();
				MainBird.STATE=4;
				break;
			case 7:
				MainBird.sendMessage("NextPuyo", "");
				mainBoardU.BoardUpdate3();
				mn.Update(mainBird.getNextPuyos());
				MainBird.STATE=0;
			}
			frame.repaint();

			try{
				Thread.sleep(100/6);
			}catch(InterruptedException e){}

			if(count%60==0){
				input.Update();
			}
			count++;
			if(MainBird.STATE==10) {
				break;
			}

		}
		JOptionPane.showConfirmDialog (frame.getContentPane(), "GameOver", "End", JOptionPane.DEFAULT_OPTION);
		System.exit(0);
	}

}

class Scene{
	String name;
	List<Object> scene;
	Scene (String name){
		this.name = name;
		scene = new ArrayList<Object>();
	}
	void addComponent(Object o) {
		scene.add(o);
	}
	void runStart() {
		for(int i=0; i<scene.size(); i++) {
			scene.get(i).Start();
		}
	}
	void runUpdata() {

	}
}

*/