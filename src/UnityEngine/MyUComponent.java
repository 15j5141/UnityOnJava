package UnityEngine;

import java.util.HashMap;
import java.util.Map;

public abstract class MyUComponent extends MyUObject{
	public static Map<String, Class<? extends MyUComponent>> map=new HashMap<String, Class<? extends MyUComponent>>();
	public GameObject gameObject;
	public String tag;// ゲームオブジェクトの。
	public Transform transform;// ゲームオブジェクトの。
	protected boolean isStarted=false;
	public MyUComponent() {
//		map=new HashMap<String, Class<? extends MyUComponent>>();
//		map.put(new Object(){}.getClass().getEnclosingClass().getName(), this.getClass());
	}
	public MyUComponent(GameObject gameObject) {
		this.gameObject= gameObject;
	}

	public MyUComponent createConponent() {
		// please override
		return null;
	}
	public MyUComponent newInstance() {
		return null;
	}
	public void setGameObject(GameObject gameObject) {
		this.gameObject= gameObject;
		this.transform= gameObject.transform;
	}

}
