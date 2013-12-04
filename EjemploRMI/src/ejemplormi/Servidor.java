package ejemplormi;

 
import java.rmi.registry.Registry;
import java.rmi.registry.LocateRegistry;
import java.rmi.server.UnicastRemoteObject;
	
public class Servidor {
	
    public Servidor() {}

    public static void main(String args[]) {
	
	try {
	    ImplementacionAlgo robj = new ImplementacionAlgo();
	    Algo stub = (Algo) UnicastRemoteObject.exportObject(robj, 0);
            
            LocateRegistry.createRegistry(1099);
	    Registry registry = LocateRegistry.getRegistry();
	    registry.bind("Mortgage", stub);
	    System.out.println("Mortgage Server is ready to listen...");

	} catch (Exception e) {
	    System.err.println("Excepcion en el servidor: " + e.toString());
	    e.printStackTrace();
	}
    }
}
