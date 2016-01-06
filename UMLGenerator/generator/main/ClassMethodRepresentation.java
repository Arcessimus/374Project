package generator.main;

import org.objectweb.asm.ClassVisitor;

public class ClassMethodRepresentation implements IMethod,ITraverser{
	@Override
	public int hashCode() {
		// TODO Auto-generated method stub
		return super.hashCode();
	}
	@Override
	public boolean equals(Object obj) {
		// TODO Auto-generated method stub
		return super.equals(obj);
	}
	
	public int getAccess() {
		return access;
	}
	public String getName() {
		return name;
	}
	public String getDesc() {
		return desc;
	}
	public String getSignature() {
		return signature;
	}
	public String[] getExceptions() {
		return exceptions;
	}
	@Override
	protected void finalize() throws Throwable {
		// TODO Auto-generated method stub
		super.finalize();
	}
	public ClassMethodRepresentation(int access, String name, String desc, String signature, String[] exceptions) {
		super();
		this.access = access;
		this.name = name;
		this.desc = desc;
		this.signature = signature;
		this.exceptions = exceptions;
	}
	int access;
	String name;
	String desc;
	String signature;
	String[] exceptions;
	@Override
	public void accept(ClassVisitor c) {
		// TODO Auto-generated method stub
		
	}
	
}
