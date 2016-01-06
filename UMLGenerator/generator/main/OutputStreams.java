package generator.main;


import java.io.FilterOutputStream;
import java.io.IOException;
import java.io.OutputStream;


public class OutputStreams extends FilterOutputStream {
	private final  visitor;
	
	public OutputStreams(OutputStream out) throws IOException {
		super(out);
		this.visitor = new Visitor();
		this.setupPreVisitCar();
		this.setupPostVisitCar();
		this.setupVisitBody();
		this.setupVisitEngine();
		this.setupVisitWheel();
	}
	
	private void write(String m) {
		try {
			super.write(m.getBytes());
		}
		catch(IOException e) {
			throw new RuntimeException(e);
		}
	}
	
	public void write(IClass c) {
		ITraverser t = (ITraverser)c;
		t.accept(this.visitor);
	}

	
	private void setupPreVisitCar() {
		IVisitMethod command = new IVisitMethod() {
			@Override
			public void execute(ITraverser t) {
				ICar c = (ICar)t;
				String line = String.format("<car vin=\"%s\" make=\"%s\" model=\"%s\">%n", 
						c.getVIN(),
						c.getMake(),
						c.getModel());
				
				write(line);
			}
		};
		this.visitor.addVisit(VisitType.PreVisit, ICar.class, command);
	}

	private void setupPostVisitCar() {
		this.visitor.addVisit(VisitType.PostVisit, ICar.class, (ITraverser t) -> {
			this.write("</car>\n");
		});
	}

	
	private void setupVisitBody() {
		this.visitor.addVisit(VisitType.Visit, IBody.class, (ITraverser t) -> {
			IBody b = (IBody)t;
			String line = String.format("<body type=\"%s\" material=\"%s\" />%n",
					b.getType(),
					b.getMaterial());
			this.write(line);
		});
	}


	private void setupVisitEngine() {
		this.visitor.addVisit(VisitType.Visit, IEngine.class, (ITraverser t) -> {
			IEngine e = (IEngine)t;
			String line = String.format("<engine cylinder=%d capacity=%.2f />%n",
					e.getCylinder(),
					e.getCapacity());
			this.write(line);
		});
	}

	
	private void setupVisitWheel() {
		this.visitor.addVisit(VisitType.Visit, IWheel.class, (ITraverser t) -> {
			IWheel w = (IWheel)t;
			String line = String.format("<wheel vendor=\"%s\" radius=%.2f width=%.2f />%n",
					w.getVendor(),
					w.getRadius(),
					w.getWidth());
			this.write(line);
		});
	}
}

