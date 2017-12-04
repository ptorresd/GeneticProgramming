package gp;

public abstract class AbstractTerminal extends AbstractNode {

	
	@Override
	public void updateSize(){
		size=1;
	}
	
	@Override
	public void swapNodes(Node child, Node newNode){
		return;
	}
	
	@Override
	public Node find(int i) {
		return this;
	}


}
