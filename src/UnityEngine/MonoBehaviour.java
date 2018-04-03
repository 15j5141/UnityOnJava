package UnityEngine;

import UnityEngine.GameObject;

public abstract class MonoBehaviour extends MyUComponent {
	void StartCoroutine() {
		// Thread
	}
	public MonoBehaviour(GameObject g) {
		super(g);
	}
	public MonoBehaviour() {
		super();
	}

	public void Awake() {}
	public abstract void Start();
	public abstract void Update();
	public void LateUpdate() {};
	public void FixedUpdate() {};
	public void print(String string) {
		Debug.Log(string);
	}

}
