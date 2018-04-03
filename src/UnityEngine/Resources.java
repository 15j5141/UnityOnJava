package UnityEngine;

import java.lang.reflect.InvocationTargetException;

public class Resources extends MyUObject{
	@SuppressWarnings("unchecked")
	public static <E> E Load(String s, E... nul) {
		E out=null;
		Class<?> clazz=null;
		try {
			clazz=Class.forName(deleteArrayString(nul.getClass().getTypeName()));
		} catch (ClassNotFoundException e1) {
			// TODO 自動生成された catch ブロック
			e1.printStackTrace();
		}
		try {
			out = (E) clazz.getClass().getDeclaredConstructor().newInstance();
		} catch (InstantiationException | IllegalAccessException | IllegalArgumentException | InvocationTargetException
				| NoSuchMethodException | SecurityException e) {
			e.printStackTrace();
		}
		return out;
	}
}
