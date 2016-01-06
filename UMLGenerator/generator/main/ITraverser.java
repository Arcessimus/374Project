package generator.main;

import org.objectweb.asm.ClassVisitor;

public interface ITraverser {
	public void accept(ClassVisitor c);
}
