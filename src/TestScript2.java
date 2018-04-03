import UnityEngine.BoxCollider;
import UnityEngine.Debug;
import UnityEngine.GameObject;
import UnityEngine.Input;
import UnityEngine.KeyCode;
import UnityEngine.MonoBehaviour;
import UnityEngine.SpriteRenderer;
import UnityEngine.Text;
import UnityEngine.Transform;
import UnityEngine.Vector2;

public class TestScript2 extends MonoBehaviour{
	public String a="Hello";

	@Override
	public void Start() {
		// TODO 自動生成されたメソッド・スタブ
		GameObject go = new GameObject();
		go.transform.position.x=0.5f;
		Debug.Log(go.<Transform>GetComponent().position.x);

		Text t = gameObject.<Text>AddComponent();
		t.setText("0");
		t.setFontSize(32);

		GameObject gg = GameObject.newSprite("./sprite/PuyoTitle.png");
		gg.transform.position.x=200f;
		gg.transform.position.y=200f;

		SpriteRenderer sr= gameObject.<SpriteRenderer>AddComponent();
		sr.setSprite("./sprite/PuyoTitle.png");
		BoxCollider bc = gameObject.<BoxCollider>AddComponent();
		bc.size = new Vector2((float)sr.size.getWidth(), (float)sr.size.getHeight());
		this.gameObject.name="dasfd";

	}

	@Override
	public void Update() {
		// TODO 自動生成されたメソッド・スタブ
		//Debug.Log(Input.MouseButton[0]);
		//Debug.Log(gameObject.transform.position.x);
		int d=5;
		if(Input.GetKey(KeyCode.RightArrow)) {
			gameObject.transform.position.x+=d;
		}
		if(Input.GetKey(KeyCode.LeftArrow)) {
			gameObject.transform.position.x+=-d;
		}
		if(Input.GetKey(KeyCode.UpArrow)) {
			gameObject.transform.position.y+=-d;
		}
		if(Input.GetKey(KeyCode.DownArrow)) {
			gameObject.transform.position.y+=d;
		}
		BoxCollider bc = gameObject.<BoxCollider>GetComponent();
		Text t = gameObject.<Text>GetComponent();
		if(bc!=null && t!=null) {
			if(bc.IsTouching()) {
				t.setText("Touch");
			}else {
				t.setText("NotTouch");
			}
		}

	}

}
