###
#
# make clean removes all generated files
#
###

JC = javac
FLAGS = -g  
CP = ./deps:.

P6.class: P6.java parser.class Yylex.class ASTnode.class
	$(JC) $(FLAGS) -cp $(CP) P6.java

parser.class: parser.java ASTnode.class Yylex.class ErrMsg.class
	$(JC) $(FLAGS) -cp $(CP) parser.java

parser.java: base.cup
	java -cp $(CP) java_cup.Main < base.cup

Yylex.class: base.jlex.java sym.class ErrMsg.class
	$(JC) $(FLAGS) -cp $(CP) base.jlex.java

ASTnode.class: ast.java Type.java SymTable.class
	$(JC) $(FLAGS) -cp $(CP) ast.java

base.jlex.java: base.jlex sym.class
	java -cp $(CP) JLex.Main base.jlex

sym.class: sym.java
	$(JC) $(FLAGS) -cp $(CP) sym.java

sym.java: base.cup
	java -cp $(CP) java_cup.Main < base.cup

ErrMsg.class: ErrMsg.java
	$(JC) $(FLAGS) -cp $(CP) ErrMsg.java

Sym.class: Sym.java Type.class ast.java
	$(JC) $(FLAGS) -cp $(CP) Sym.java

SymTable.class: SymTable.java Sym.class DuplicateSymNameException.class EmptySymTableException.class
	$(JC) $(FLAGS) -cp $(CP) SymTable.java

Type.class: Type.java
	$(JC) $(FLAGS) -cp $(CP) Type.java ast.java

Codegen.class: Codegen.java
	$(JC) -g -cp $(CP) Codegen.java
	
DuplicateSymNameException.class: DuplicateSymNameException.java
	$(JC) $(FLAGS) -cp $(CP) DuplicateSymNameException.java

EmptySymTableException.class: EmptySymTableException.java
	$(JC) $(FLAGS) -cp $(CP) EmptySymTableException.java

###
# test
###
test:
	java -cp $(CP) P6 test.base test.s

###
# clean
###
clean:
	rm -f *~ *.class parser.java base.jlex.java sym.java

cleantest:
	rm -f *.s
