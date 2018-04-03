package UnityEngine;

public class Vector2{
	public float x;
	public float y;
	public Vector2(float x, float y){
		this.x = x;
		this.y = y;
	}
	public Vector2() {
		this.x=1f;
		this.y=1f;
	}
	public float magnitude() {
		return (float) Math.sqrt(x*x+y*y);
	}
	public static Vector2 down() {
		return new Vector2(0, -1);
	}
	public static Vector2 left() {
		return new Vector2(-1, 0);
	}
	public static Vector2 one() {
		return new Vector2(1, 1);
	}
	public static Vector2 right() {
		return new Vector2(1, 0);
	}
	public static Vector2 up() {
		return new Vector2(0, 1);
	}
	public static Vector2 zero() {
		return new Vector2(0, 0);
	}
	public Vector2 normalized() {
		return new Vector2(this.x*1f/magnitude(), this.y*1f/magnitude());
	}
	public void Normalized() {
		this.x=this.x*1f/magnitude();
		this.y=this.y*1f/magnitude();
	}
}
