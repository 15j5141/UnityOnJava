package UnityEngine;

public class BoxCollider extends Collider {
	public Vector2 size=new Vector2();

	public static boolean collision(BoxCollider bc1, BoxCollider bc2){
		// Fix me, Rotation.
		Vector2 size=bc1.size;
		Vector2 pos =bc1.transform.position;
		Vector2 pointA[]=new Vector2[4];
		pointA[0]=new Vector2(pos.x, pos.y);
		pointA[1]=new Vector2(pos.x+size.x, pos.y);
		pointA[2]=new Vector2(pos.x+size.x, pos.y+size.y);
		pointA[3]=new Vector2(pos.x, pos.y+size.y);
		size=bc2.size;
		pos =bc2.transform.position;
		Vector2 pointB[]=new Vector2[4];
		pointB[0]=new Vector2(pos.x, pos.y);
		pointB[1]=new Vector2(pos.x+size.x, pos.y);
		pointB[2]=new Vector2(pos.x+size.x, pos.y+size.y);
		pointB[3]=new Vector2(pos.x, pos.y+size.y);
		for(int i=0;i<4; i++) {
			int ii=(i+1)%4;
			for(int j=0;j<4; j++) {
				int jj=(j+1)%4;
				if(
						linecross(pointA[i], pointA[ii], pointB[j], pointB[jj]) &&
						linecross(pointB[j], pointB[jj], pointA[i], pointA[ii])
						)
				{
					//Debug.Log("Collision");
					bc1.isTouching=true;
					bc2.isTouching=true;
					return true;
				}else {
					//Debug.Log("NotCollision");
				}
			}
		}
		bc1.isTouching=false;
		bc2.isTouching=false;
		return false;
	}
	public static boolean linecross(Vector2 a, Vector2 b, Vector2 c, Vector2 d) {
		float aa=(a.x-b.x)*(c.y-a.y)+(a.y-b.y)*(a.x-c.x);
		float bb=(a.x-b.x)*(d.y-a.y)+(a.y-b.y)*(a.x-d.x);
		//System.out.println(":"+(aa*bb>0));
		if(aa*bb>0) {
			return false;
		}else if(aa*bb<0) {
			return true;
		}else if(aa==0){
			return false;
		}else if(bb==0){
			return false;
		}else{
			return false;
		}
	}
}
