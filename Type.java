/***
 * Type class and its subclasses: 
 * ErrorType, IntegerType, LogicalType, VoidType, StringType, FctnType,
 * TupleType, TupleDefType
 ***/
abstract public class Type {

    /***
     * default constructor
     ***/
    public Type() {
    }

    /***
     * every subclass must provide a toString method and an equals method
     ***/
    abstract public String toString();
    abstract public boolean equals(Type t);

    /***
     * default methods for "isXXXType"
     ***/
    public boolean isErrorType() {
        return false;
    }

    public boolean isIntegerType() {
        return false;
    }

    public boolean isLogicalType() {
        return false;
    }

    public boolean isVoidType() {
        return false;
    }
    
    public boolean isStringType() {
        return false;
    }

    public boolean isFctnType() {
        return false;
    }

    public boolean isTupleType() {
        return false;
    }
    
    public boolean isTupleDefType() {
        return false;
    }
}

// **********************************************************************
//   ErrorType
// **********************************************************************
class ErrorType extends Type {

    public boolean isErrorType() {
        return true;
    }

    public boolean equals(Type t) {
        return t.isErrorType();
    }

    public String toString() {
        return "error";
    }
}

// **********************************************************************
//   IntegerType
// **********************************************************************
class IntegerType extends Type {

    public boolean isIntegerType() {
        return true;
    }

    public boolean equals(Type t) {
        return t.isIntegerType();
    }

    public String toString() {
        return "integer";
    }
}

// **********************************************************************
//   LogicalType
// **********************************************************************
class LogicalType extends Type {

    public boolean isLogicalType() {
        return true;
    }

    public boolean equals(Type t) {
        return t.isLogicalType();
    }

    public String toString() {
        return "logical";
    }
}

// **********************************************************************
//   VoidType
// **********************************************************************
class VoidType extends Type {

    public boolean isVoidType() {
        return true;
    }

    public boolean equals(Type t) {
        return t.isVoidType();
    }

    public String toString() {
        return "void";
    }
}

// **********************************************************************
//   StringType
// **********************************************************************
class StringType extends Type {

    public boolean isStringType() {
        return true;
    }

    public boolean equals(Type t) {
        return t.isStringType();
    }

    public String toString() {
        return "String";
    }
}

// **********************************************************************
//   FctnType
// **********************************************************************
class FctnType extends Type {

    public boolean isFctnType() {
        return true;
    }

    public boolean equals(Type t) {
        return t.isFctnType();
    }

    public String toString() {
        return "function";
    }
}

// **********************************************************************
//   TupleType
// **********************************************************************
class TupleType extends Type {
    private IdNode myId;
    
    public TupleType(IdNode id) {
        myId = id;
    }
    
    public boolean isTupleType() {
        return true;
    }

    public boolean equals(Type t) {
        return t.isTupleType();
    }

    public String toString() {
        return myId.name();
    }
}

// **********************************************************************
//   TupleDefType
// **********************************************************************
class TupleDefType extends Type {

    public boolean isTupleDefType() {
        return true;
    }

    public boolean equals(Type t) {
        return t.isTupleDefType();
    }

    public String toString() {
        return "tuple";
    }
}
