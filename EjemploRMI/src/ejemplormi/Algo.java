package ejemplormi;

import java.rmi.Remote;
import java.rmi.RemoteException;

public interface Algo extends Remote {

    public double calcularPago(double principal, double annualRate, int terms)
                    throws RemoteException;
}