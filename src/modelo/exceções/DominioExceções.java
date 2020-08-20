package modelo.exceções;

public class DominioExceções extends RuntimeException{
	private static final long serialVersionUID = 1L;
	
	public DominioExceções(String msg){
		super(msg);
	}
	
}

