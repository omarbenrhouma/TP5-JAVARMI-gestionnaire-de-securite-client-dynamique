import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;

public class ReverseClient {
    public static void main(String[] args) {
        if (System.getSecurityManager() == null) {
            System.setSecurityManager(null); // Désactive le gestionnaire de sécurité
        }



        try {
            Registry registry = LocateRegistry.getRegistry("localhost");
            FabReverseInterface fab = (FabReverseInterface) registry.lookup("Fabrique");
            ReverseInterface instance = fab.createInstance();
            System.out.println(instance.reverseString("Hello, World!"));
        } catch (Exception e) {
            System.err.println("Erreur du client : " + e.toString());
            e.printStackTrace();
        }
    }
}
