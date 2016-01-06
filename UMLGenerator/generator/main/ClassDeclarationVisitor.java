package generator.main;

import java.util.Arrays;

import org.objectweb.asm.ClassVisitor;

public class ClassDeclarationVisitor extends ClassVisitor {
	public ClassDeclarationVisitor(int api){
		super(api);
	}
	
	@Override
	public void visit(int version, int access, String name, String signature, String superName, String[] interfaces){
		// : construct an internal representation of the class for later use by decorators
		IClass clazz = new ClassRepresentation(version, access, name, signature, superName, interfaces);
		// TODO: do something with the internal representation
		
		super.visit(version, access, name, signature, superName, interfaces);
		
	}
}
