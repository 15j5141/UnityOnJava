package UnityEngine;

import java.util.ArrayList;
import java.util.List;

public class Scene {
	// 構造体？
	public int buildIndex;
	public boolean isDirty;
	public boolean isLoaded;
	public String name;
	public String path;
	public int rootCount;
	public List<GameObject> GameObjectList;
	public Scene(String name) {
		GameObjectList=new ArrayList<GameObject>();
		this.name = name;
	}
	public GameObject[] GetRootGameObjects() {
		return (GameObject[]) GameObjectList.toArray();
	}
}
