package UnityEngine;

import java.util.ArrayList;
import java.util.List;

public class SceneManager {
	static List<Scene> sceneList=new ArrayList<Scene>();
	public static Scene activeScene;
	public static void Start(){
		UnityEngineMain sub = new UnityEngineMain();
	    sub.start();
	}
	public static Scene CreateScene(String name) {
		Scene s = new Scene(name);
		if(sceneList.isEmpty()) {
			SetActiveScene(s);
		}
		sceneList.add(s);
		return s;
	}
	public static Scene GetActiveScene() {
		return activeScene;
	}
	public static Scene GetSceneAt	() {
		return null;

	}
	public static Scene GetSceneByBuildIndex() {

		return null;
	}
	public static Scene GetSceneByName	(String name) {
		for(Scene scene : sceneList) {
			if(scene.name.equals(name)) {
				return scene;
			}
		}
		return null;
	}
	public static Scene GetSceneByPath() {

		return null;
	}
	public static void LoadScene() {

	}
	public static void LoadSceneAsync() {

	}
	public static void MoveGameObjectToScene() {

	}
	public static void SetActiveScene(Scene s) {
		activeScene=s;
	}
	public static Scene LoadSceneClass(SceneFile sceneFile) {
		// TODO 自動生成されたメソッド・スタブs
		return null;
	}

}
