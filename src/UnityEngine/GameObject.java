package UnityEngine;

import java.lang.reflect.Constructor;
import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JLabel;

public class GameObject extends MyUObject{
	public Transform transform;
	public ImageLabel iLabel;
	//public String name; // GameObject's name.
	private JLabel label;// draw component
	public List<MyUComponent> os;
	public static List<GameObject> objectAll = new ArrayList<GameObject>();;

	private GameObject(String name, Transform t,boolean b , MyUComponent[] o){
		// MyUComponent...とTransformを区別してこれを主要コンストラクターとするためにbはダミー
		objectAll.add(this);
		this.name=name;
		os = new ArrayList<MyUComponent>();
		transform = t;
		this.AddComponent(t);
		this.AddComponent(o);

	}
	public GameObject(){
		this("New Object", new Transform(), true, null);
	}
	public GameObject(String name){
		this(name, new Transform(), true, null);
	}
	public GameObject(String name, MyUComponent... o){
		this(name, new Transform(), true, o);
	}
	public GameObject(String name, Vector2 pos, MyUComponent... o){
		this(name, new Transform(), true, o);
		this.transform.position = pos;
	}
	/*
	public GameObject(String name, String fileName){
		this(name);
		ImageIcon icon = new ImageIcon(fileName);
		Vector2 scale = new Vector2(icon.getIconWidth(), icon.getIconHeight());
		transform.scale = scale;
		label = new JLabel();
		label.setIcon(icon);
	}
	public GameObject(String name, String fileName, Vector2 pos){
		this(name, fileName);
		this.transform.position = pos;
	}
	 */
	public GameObject(String name, JLabel jl, Vector2 pos){
		// FixMe this(name, jl);
		this.transform.position = pos;
		label = jl;
	}
	public MyUComponent GetComponent(Type t){
		for(int i=0; i<os.size(); i++){
			//System.out.println("GC:"+os.get(i).getClass().getSimpleName());
			if(os.get(i).getClass().getSimpleName().equals(t.getClass().getSimpleName())){
				return os.get(i);
			}
		}
		return transform;

	}
	public MyUComponent GetComponent(String s){
		for(int i=0; i<os.size(); i++){
			//System.out.println("GC:"+os.get(i).getClass().getSimpleName());
			if(os.get(i).getClass().getSimpleName().equals(s)){
				return os.get(i);
			}
		}
		return null;
	}
	@SuppressWarnings("unchecked")
	public <E extends MyUComponent> List<E> GetComponents(E... ee) {
		List<E> out = new ArrayList<E>();
		for(int i=0; i<os.size(); i++){
			if(os.get(i).getClass().getTypeName().equals(ee.getClass().getTypeName())){
				out.add((E) os.get(i));
			}
		}
		return out;
	}
	@SuppressWarnings("unchecked")
	public <E extends MyUComponent> E GetComponent(E... ee) {
		// Eは深くなるとクラス名がどんどん浅くなるため。TestScript->Monobehavera->MyUComponent....
		for(int i=0; i<os.size(); i++){
			if(os.get(i).getClass().getTypeName().equals(deleteArrayString(ee.getClass().getTypeName()))){
				return (E) os.get(i);
			}
		}
		return null;
	}
	@SuppressWarnings("unchecked")
	public <E extends MyUComponent> List<E> GetSuperComponents(E... ee) {
		List<E> out = new ArrayList<E>();
		//System.out.println("a:"+ee.getClass().getTypeName());
		for(int i=0; i<os.size(); i++){
			if(isExtended(deleteArrayString(ee.getClass().getTypeName()),os.get(i).getClass().getTypeName())) {
				out.add((E) os.get(i));
				//System.out.println(os.get(i));
			}
		}
		return out;
	}
	public List<MyUComponent> GetAllComponents() {
		return os;
	}


	public Object AboutGetComponent(String s){
		for(int i=0; i<os.size(); i++){
			//System.out.println("GC:"+os.get(i).getClass().getSimpleName());
			if(os.get(i).getClass().getSimpleName().matches(".*"+s+".*")){
				return os.get(i);
			}
		}
		return null;
	}
	public static GameObject Find(String s){
		for(int i=0; i<objectAll.size(); i++){
			//System.out.println(objectAll.get(i).name);
			if(objectAll.get(i).name.equals(s)){
				return objectAll.get(i);
			}
		}
		return null;
	}
	/*
	public <T> T GetComponent(T Object) {
		for(int i=0; i<os.size(); i++){
			//System.out.println("i="+i+":"+os.get(i).getClass().getSimpleName()+":"+t.getClass().getSimpleName());
			if(os.get(i).getClass().getSimpleName().equals(t.getClass().getSimpleName())){
				return (T)os.get(i);
			}
		}
		return null;
	}
	 */
	@SuppressWarnings("unchecked")
	public <E extends MyUComponent> E AddComponent(E... nul){
		if(nul==null) {
			return null;
		}
		if(nul.length==0) {
			//Class<?>[] types = { UnityEngine.GameObject.class }; // 引数の型の配列
			//Object[] args1 = {this}; // 引数の配列
			E o = null;
			String s=deleteArrayString(nul.getClass().getTypeName());
			//System.out.println(s);
			Class<?> cls = null;
			try {
				cls= Class.forName(s);
				Constructor<?> c = cls.getConstructor();
				o = (E) c.newInstance();
			} catch (Exception e) {
				e.printStackTrace();
			}
			o.setGameObject(this);
			os.add(o);
			return o;
		}else {
			for (MyUComponent myUComponent : nul) {
				os.add(myUComponent);
			}
			return nul[0];
		}

		/*
		try {
			// 実行時の型が取れる。ここではHogeDaoなど
			Class<?> clazz = e.getClass();
			// ここではBaseDao<Hoge>がとれる
			Type type = clazz.getGenericSuperclass();
			ParameterizedType pt = (ParameterizedType)type;
			// BaseDaoの型変数に対するバインドされた型がとれる
			Type[] actualTypeArguments = pt.getActualTypeArguments();
			Class<?> entityClass = (Class<?>)actualTypeArguments[0];
			// リフレクションでインスタンスを生成
			ee= (E) entityClass.newInstance();
		} catch (ReflectiveOperationException er) {
			throw new RuntimeException(er);
		}
		 */
		/*
		try {
			System.out.println(kara.getClass().getConstructor(kara.getClass()).newInstance(kara.getClass().getName()) );
		} catch (NoSuchMethodException | SecurityException | InstantiationException | IllegalAccessException | IllegalArgumentException | InvocationTargetException e) {
			e.printStackTrace();
		}
		 */

		//		for(int i=0; i<s.length; i++){
		//			os.add((E)s[i]);
		//		}
		//		return s;
	}

	public void setJLabel(JLabel j){
		label=j;
	}
	public JLabel getJLabel(){
		return label;
	}
	public static GameObject newText(String s) {
		GameObject go = new GameObject();
		Text sr = go.<Text>AddComponent();
		sr.setText(s);
		SceneManager.GetActiveScene().GameObjectList.add(go);
		return go;
	}
	public static GameObject newSprite(String s) {
		GameObject go = new GameObject();
		SpriteRenderer sr = go.<SpriteRenderer>AddComponent();
		sr.setSprite(s);
		BoxCollider bc = go.<BoxCollider>AddComponent();
		bc.size = new Vector2((float)sr.size.getWidth(), (float)sr.size.getHeight());
		SceneManager.GetActiveScene().GameObjectList.add(go);
		return go;
	}

}
