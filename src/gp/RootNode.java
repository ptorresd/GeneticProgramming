package gp;

public class RootNode extends AbstractNode {
	
	Node child;
	
	public RootNode(Node child) {
		this.child=child;
		child.setRoot(this);
	}

	public Node clone(){
        Node clonedChild=child.clone();
        return new RootNode(clonedChild);
	}
	
	@Override
	public void swapNodes(Node child,Node newNode){
		this.child=newNode.clone();
		this.child.setRoot(this);
	}
	@Override
	public int getSize(){
		return child.getSize();
	}
	@Override
	public double getVal(double[] paramValues) {
		return child.getVal(paramValues);
	}

	@Override
	public Node find(int i) {
		return child.find(i);
	}

	@Override
	public void updateSize() {size=child.getSize();
		
	}

	@Override
	public String toString(String[] varSymbols) {
		return child.toString(varSymbols);
	}

}
