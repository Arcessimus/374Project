package generator.main;

import org.objectweb.asm.ClassVisitor;

public class ClassRepresentation implements IClass, ITraverser {
	int version;
	int access;
	String name;
	String signature;
	String superName;
	String[] interfaces;
	
	public ClassRepresentation(int version, int access, String name, String signature, String superName,
			String[] interfaces) {
		this.version = version;
		this.access = access;
		this.name = name;
		this.signature = signature;
		this.superName = superName;
		this.interfaces = interfaces;
	}

	public int getVersion() {
		return version;
	}

	public int getAccess() {
		return access;
	}

	public String getName() {
		return name;
	}

	public String getSignature() {
		return signature;
	}

	public String getSuperName() {
		return superName;
	}

	public String[] getInterfaces() {
		return interfaces;
	}

	@Override
	public void accept(ClassVisitor c) {
		// TODO Auto-generated method stub
		
	}
	
	
}
