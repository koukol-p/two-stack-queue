import java.util.ArrayList;
import java.util.Optional;

public class Queue<T> {
	private ArrayList<T> inStack = new ArrayList<T>();
	private ArrayList<T> outStack = new ArrayList<T>();
	
	public void add(T elem) {
		inStack.add(elem);
	}
	private void transferInStackElems() {
		if(outStack.isEmpty()) {
			while(!inStack.isEmpty()) {
				outStack.add(inStack.remove(inStack.size() - 1));
			}
		}
	}
	public Optional<T> peek() {
			this.transferInStackElems();
		if(outStack.size() - 1 >= 0) {
			return Optional.of(this.outStack.get(outStack.size() - 1));
		}
		return Optional.empty();
	}
	public Optional<T> remove() {
		this.transferInStackElems();
		if(outStack.size() - 1 >= 0) {
			return Optional.of(this.outStack.remove(outStack.size() - 1));
		}
		return Optional.empty();
		
	}
	
}
