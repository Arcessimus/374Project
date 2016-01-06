package generator.main;

import org.objectweb.asm.ClassVisitor;

public class ClassFieldRepresentation implements ITraverser,IField{
	int access;
	String name;
	String desc;
	String signature;
	Object value;
	IClass decorated;
	
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
	
	@Override
	protected void finalize() throws Throwable {
		// TODO Auto-generated method stub
		super.finalize();
	}
	public ClassFieldRepresentation(int access, String name, String desc, String signature, Object value, IClass decorated) {
		this.access = access;
		this.name = name;
		this.desc = desc;
		this.signature = signature;
		this.value = value;
		this.decorated = decorated;
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
	public Object getValue() {
		return value;
	}
	public IClass getDecorated() {
		return this.decorated;
	}
	@Override
	public void accept(ClassVisitor c) {
		// TODO Auto-generated method stub
		
	}
}
