package UnityEngine;

import java.util.ArrayList;
import java.util.List;

class Collider extends MyUComponent{
	protected boolean isTouching;
	static List<Collider> list =new ArrayList<Collider>();
	public boolean IsTouching() {
		return isTouching;
	}
	public static void calc() {
		list.clear();
		for(GameObject go : SceneManager.GetActiveScene().GameObjectList) {
			for(Collider c: go.<Collider>GetSuperComponents()) {
				for(Collider cc:list) {
					BoxCollider.collision((BoxCollider) cc, (BoxCollider) c);
				}
				list.add(c);
			}
		}
	}
	public static boolean collision(BoxCollider bc1,BoxCollider bc2) {
		return false;
	}
}
