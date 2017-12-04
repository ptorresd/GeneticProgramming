package gp;

public abstract class AbstractNode implements Node {

	int size;
	Node root;
	
	@Override
	public void setRoot(Node root){
		this.root=root;
	}
	
	public abstract Node clone();
	
	@Override
	public Node getRoot(){
		return root;
	}
	
	@Override
	public int getSize() {
		return size;
	}

}
