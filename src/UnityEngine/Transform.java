package UnityEngine;

public class Transform extends MyUComponent{

	public Vector2 position= new Vector2(0, 0);
	public Vector2 localScale= new Vector2(0, 0);
	public Vector2 velocity= new Vector2(0, 0);
	private Transform parent;
	public Transform(){
		super();
		position = new Vector2(0, 0);
		localScale = new Vector2(1, 1);
		velocity = new Vector2(0, 0);
	}
	public void Translate(Vector2 pos){
		position = pos;
	}
	@Override
	public Transform createConponent(){
		return new Transform();
	}
	@Override
	public Transform newInstance() {
		return new Transform();
	}
	public void SetParent(Transform t) {
		parent=t;

	}
}
