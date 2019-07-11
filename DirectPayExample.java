import com.paydunya.neptune.*;
import java.io.*;

public class DirectPayExample {
	public static void main(String args[]) throws Exception {

		// Setup your API keys and mode
		PaydunyaSetup apiSetup = new PaydunyaSetup();
		apiSetup.setMasterKey("wQzk9ZwR-Qq9m-0hD0-zpud-je5coGC3FHKW");
		apiSetup.setPrivateKey("test_private_rMIdJM3PLLhLjyArx9tF3VURAF5");
		apiSetup.setPublicKey("test_public_kb9Wo0Qpn8vNWMvMZOwwpvuTUja");
		apiSetup.setToken("IivOiOxGJuWhc5znlIiK");
		apiSetup.setMode("test");

		// Paydunya TFA Request
		PaydunyaDirectPay co = new PaydunyaDirectPay(apiSetup);

		// Make the Payment
		if (co.creditAccount("alioune", 30000)) {
        System.out.println("Status: "+co.getStatus());
        System.out.println("Descripion: "+co.getDescription());
        System.out.println("Transaction ID: "+co.getTransactionId());
      }else{
        System.out.println("Status: "+co.getStatus());
        System.out.println("Response Message: "+co.getResponseText());
      }
	}
}