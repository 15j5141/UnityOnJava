package UnityEngine;

import java.util.List;

public class UnityEngineMain extends Thread {
	public void run() {
		GUI gui=new GUI("testtest");
		gui.getContentPane();
		int frame=0;
		int fps=30;
		Debug.mode=false;// デバッグのデバッグを非表示
		while(SceneManager.activeScene==null) {
			Wait(1000);
		}
		while(true) {
			GameObject[] gameObjects=SceneManager.activeScene.GameObjectList.toArray(new GameObject[] {});
			for(GameObject gameObject:gameObjects) {
				// List<MyUComponent> l = gameObject.GetAllComponents();
				List<MonoBehaviour> ll=gameObject.<MonoBehaviour>GetSuperComponents();
				for(int i=0;i<ll.size();i++) {
					if(!ll.get(i).isStarted) {
						Debug.Log("------"+ll.get(i).getClass().getTypeName()+" Start. frame="+frame+"------", true);
						ll.get(i).isStarted=true;
						ll.get(i).Start();
					}else {
						Debug.Log("------"+ll.get(i).getClass().getTypeName()+" Update. frame="+frame+"------", true);
						ll.get(i).Update();
					}
				}
			}
			gui.repaint();
			Input.Update();
			Collider.calc();
			Wait(1000/fps);
			frame++;
		}
	}
	private void Wait(long time) {
		try {
			Thread.sleep(time);
		} catch (InterruptedException e) {
			// TODO 自動生成された catch ブロック
			e.printStackTrace();
		}

	}
}
