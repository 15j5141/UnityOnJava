package UnityEngine;

public class Debug {
	protected static boolean mode=true;
	protected static void Log(String string, boolean b) {
		if(b) {
			if(mode) {
				System.out.println("Debug: "+string);
			}
		}else {
			System.out.println(string);
		}
	}
	public static void Log(Object s) { Log(s.toString(), false); }
}
