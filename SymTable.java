import java.util.*;

public class SymTable {
	private List<HashMap<String, Sym>> list;
	private int currOffset;
	private boolean globalScope;
	
	public SymTable() {
		list = new LinkedList<HashMap<String, Sym>>();
		list.add(new HashMap<String, Sym>());
		currOffset = 0;
		globalScope = true;
	}

	public int getOffset() {
		return currOffset;
	}
		
	public void setOffset(int n) {
		currOffset = n;
	}
	
	public boolean isGlobalScope() {
		return globalScope;
	}

	public void setGlobalScope(boolean value) {
		globalScope = value;
	}

	public void addDecl(String name, Sym sym) 
	throws DuplicateSymNameException, EmptySymTableException {
		if (name == null || sym == null)
			throw new IllegalArgumentException();
		
		if (list.isEmpty())
			throw new EmptySymTableException();
		
		HashMap<String, Sym> symTab = list.get(0);
		if (symTab.containsKey(name))
			throw new DuplicateSymNameException();
		
		symTab.put(name, sym);
	}
	
	public void addScope() {
		list.add(0, new HashMap<String, Sym>());
	}
	
	public Sym lookupLocal(String name) 
	throws EmptySymTableException {
		if (list.isEmpty())
			throw new EmptySymTableException();
		
		HashMap<String, Sym> symTab = list.get(0); 
		return symTab.get(name);
	}

	public Sym lookupGlobal(String name) 
	throws EmptySymTableException {
		if (list.isEmpty())
			throw new EmptySymTableException();
		
		for (HashMap<String, Sym> symTab : list) {
			Sym sym = symTab.get(name);
			if (sym != null)
				return sym;
		}
		return null;
	}

	public void removeScope() 
	throws EmptySymTableException {
		if (list.isEmpty())
			throw new EmptySymTableException();
		list.remove(0);
	}

	public void print() {
		System.out.print("\n++++ SYMBOL TABLE\n");
		for (HashMap<String, Sym> symTab : list) {
			System.out.println(symTab.toString());
		}
		System.out.println("\n++++ END TABLE");
	}
}
