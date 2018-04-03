package UnityEngine;

import java.lang.reflect.Constructor;

public class MyUObject {
	public Boolean hideFlags;
	public String name;
	public int	GetInstanceID () {
		// Not use.
		return 0;
	}
	public String ToString() {
		return name;
	}
	static void Destroy(MyUObject object) {
		object=null;
	}
	static MyUObject Instantiate(MyUObject o) {
		MyUObject c=null;
		try {
			c= (MyUObject) o.clone();
		} catch (CloneNotSupportedException e) {
			// TODO 自動生成された catch ブロック
			e.printStackTrace();
		}
		return c;
	}
	boolean MyUObject() {
		return true;

	}
	public static boolean isExtended(String classSuper, String classSub) {

		// Class.forName("Name").getClass()ではない！getClass()はいらない。
		boolean b=false;
		try {
			b=Class.forName(classSuper.replaceAll("\\[\\]", "")).isAssignableFrom(Class.forName(classSub.replaceAll("\\[\\]", "")));
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
		return b;
	}
	public static Object Instance(String name) {
		Object o = null;
		String s=deleteArrayString(name);
//		System.out.println("c:"+s);
		Class<?> cls = null;
		try {
			cls= Class.forName(s);
			Constructor<?> c = cls.getConstructor();
			o = c.newInstance();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return o;
	}
	public static String deleteArrayString(String s) {
		// []を消す。
		return s.replaceFirst("\\[\\]", "");
	}

}