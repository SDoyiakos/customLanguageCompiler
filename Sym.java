import java.util.*;

/***
 * The Sym class defines a symbol-table entry. 
 * Each Sym contains a type (a Type).
 ***/
public class Sym { 
	private Type type;
    private int offset;
	
	public Sym(Type type) {
		this.type = type;
	}
	
	public Type getType() {
		return type;
	}

    public int getOffset() {
        return offset;
    }

    public void setOffset(int offset) {
        this.offset = offset;
    }

    public boolean isGlobal() {
        return offset == 1;
    }
	
	public String toString() {
		return type.toString();
	}
}

/***
 * The FctnSym class is a subclass of the Sym class just for functions.
 * The returnType field holds the return type and there are fields to hold
 * information about the parameters.
 ***/
class FctnSym extends Sym {
    // new fields
    private Type returnType;
    private int numParams;
    private List<Type> paramTypes;
    private int myParamsSize;
    private int myLocalsSize;
    
    public FctnSym(Type type, int numparams) {
        super(new FctnType());
        returnType = type;
        numParams = numparams;
        myParamsSize = 0;
        myLocalsSize = 0;
    }

    public void addFormals(List<Type> L) {
        paramTypes = L;
    }
    
    public Type getReturnType() {
        return returnType;
    }

    public int getNumParams() {
        return numParams;
    }

    public List<Type> getParamTypes() {
        return paramTypes;
    }

    public int getParamsSize() {
        return myParamsSize;
    }
    
    public int getLocalsSize() {
        return myLocalsSize;
    }

    public void setParamsSize(int n) {
        myParamsSize = n;
    }
    
    public void setLocalsSize(int n) {
        myLocalsSize = n;
    }
    
    public String toString() {
        // make list of formals
        String str = "";
        boolean notfirst = false;
        for (Type type : paramTypes) {
            if (notfirst)
                str += ",";
            else
                notfirst = true;
            str += type.toString();
        }

        str += "->" + returnType.toString();
        return str;
    }
}

/***
 * The TupleSym class is a subclass of the Sym class just for variables 
 * declared to be a tuple type. 
 * Each TupleSym contains a symbol table to hold information about its 
 * fields.
 ***/
class TupleSym extends Sym {
    // new fields
    private IdNode tupleType;  // name of the tuple type
    
    public TupleSym(IdNode id) {
        super(new TupleType(id));
        tupleType = id;
    }

    public IdNode getTupleType() {
        return tupleType;
    }    
}

/***
 * The TupleDefSym class is a subclass of the Sym class just for the 
 * definition of a tuple type. 
 * Each TupleDefSym contains a symbol table to hold information about its 
 * fields.
 ***/
class TupleDefSym extends Sym {
    // new fields
    private SymTable symTab;
    
    public TupleDefSym(SymTable table) {
        super(new TupleDefType());
        symTab = table;
    }

    public SymTable getSymTable() {
        return symTab;
    }
}
