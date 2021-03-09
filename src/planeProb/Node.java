package planeProb;

public class Node {
	int x,y,price,pathNum;

	public Node(int x, int y) {
		this.x=x;//price x
		this.y=y;//price y
		this.price=0; //price up 2 this node
		this.pathNum=0;
	}
	@Override
	public String toString() {

		String toString="| ";
		if (this.y!=0) {toString=toString+this.y+"v ";//print y

		}
		else {
			toString="   "+toString+"   ";
		}
		if (this.x!=0) {toString=toString+this.x+"-> ";//print x

		} else {
			toString="   "+toString+"   ";
		}

		//return ("Price X= "+this.x+" Price Y= "+this.y);
		if(this.price!=0&&this.pathNum!=0) 
		{
			toString=toString+", pr= "+this.price+" path= "+this.pathNum+" | ";

		}
		
		return toString;
	}
}
