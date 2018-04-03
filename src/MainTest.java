import UnityEngine.GameObject;
import UnityEngine.Scene;
import UnityEngine.SceneManager;

public class MainTest {

	public static void main(String[] args) {
		Scene scene = SceneManager.LoadSceneClass(new TestScene());
		SceneManager.CreateScene("aaa");
		SceneManager.GetActiveScene().GameObjectList.add(new GameObject());
		SceneManager.GetActiveScene().GameObjectList.get(0).<TestScript>AddComponent();
		SceneManager.Start();

		//TestScript ts= new TestScript();
		//System.out.println( MonoBehaviour.class.isAssignableFrom(ts.getClass()));
	}

}
