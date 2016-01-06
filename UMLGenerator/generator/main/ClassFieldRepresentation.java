package generator.main;

public class ClassFieldRepresentation implements ITraverser,IField{
	int access;
	String name;
	String desc;
	String signature;
	Object value;
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
	protected Object clone() throws CloneNotSupportedException {
		// TODO Auto-generated method stub
		return super.clone();
	}
	@Override
	public String toString() {
		// TODO Auto-generated method stub
		return super.toString();
	}
	@Override
	protected void finalize() throws Throwable {
		// TODO Auto-generated method stub
		super.finalize();
	}
	public ClassFieldRepresentation(int access, String name, String desc, String signature, Object value) {
		super();
		this.access = access;
		this.name = name;
		this.desc = desc;
		this.signature = signature;
		this.value = value;
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
}
