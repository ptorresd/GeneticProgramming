package gp;

public abstract class AbstractNode implements Node {

	int size;
	Node root;
	
	@Override
	public void setRoot(Node root){
		this.root=root;
	}
	
	@Override
	public void updateSize(){
		size=1;
	}
	@Override
	public int getSize() {
		return size;
	}

}
