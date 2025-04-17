package ejercicio3;

public class MiHebraImpresora extends Thread {
	private VariableCompartida v;
	
	public MiHebraImpresora(VariableCompartida v) {
		this.v = v;
	}
	
	@Override
	public void run() {
		for(int i = 0; i<99; i++) {
			System.out.println(v.get());
		}
	}

}
