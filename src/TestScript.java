import UnityEngine.*;

public class TestScript extends MonoBehaviour{
	public String a="Hello";

	@Override
	public void Start() {
		// TODO 自動生成されたメソッド・スタブ
		Debug.Log(a);

		//SceneManager.GetActiveScene().GameObjectList.get(0).<TestScript>AddComponent();
		gameObject.<TestScript2>AddComponent().a=a+"ABC";
		this.a=a+"DEF";
	}

	@Override
	public void Update() {
		// TODO 自動生成されたメソッド・スタブ
		//Debug.Log(a);
	}

}
