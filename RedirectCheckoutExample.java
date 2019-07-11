import com.paydunya.neptune.*;

public class RedirectCheckoutExample {
	public static void main(String args[]) throws Exception {

		// Setup your API keys and mode
		PaydunyaSetup apiSetup = new PaydunyaSetup();
        apiSetup.setMasterKey("wQzk9ZwR-Qq9m-0hD0-zpud-je5coGC3FHKW");
        apiSetup.setPrivateKey("test_private_rMIdJM3PLLhLjyArx9tF3VURAF5");
        apiSetup.setPublicKey("test_public_kb9Wo0Qpn8vNWMvMZOwwpvuTUja");
        apiSetup.setToken("IivOiOxGJuWhc5znlIiK");
        apiSetup.setMode("test");

		// Setup your store information
		PaydunyaCheckoutStore storeSetup = new PaydunyaCheckoutStore();
		storeSetup.setName("Magasin Chez Sandra");
		storeSetup.setTagline("L'élégance n'a pas de prix.");
		storeSetup.setPhoneNumber("336530583");
		storeSetup.setPostalAddress("Dakar Plateau - Etablissement kheweul");
		storeSetup.setWebsiteUrl("http://www.chez-sandra.sn");

		// Start creating an Paydunya Checkout
		PaydunyaCheckoutInvoice co = new PaydunyaCheckoutInvoice(apiSetup, storeSetup);
		// Add invoice items
		co.addItem("Clavier DELL",2,3000,6000);
		co.addItem("Ordinateur Lenovo L440",1,400000,400000);
		co.addItem("Casque Logitech",1,8000,8000);

		// You will need to calculated the total amout yourself.
		co.setTotalAmount(414000);

		// Create the invoice
		if (co.create()) {
			System.out.println("Invoice URL: "+co.getInvoiceUrl());
		}else{
			System.out.println("Error Occured: "+ co.getResponseCode());
			System.out.println(co.getResponseText());
		}
	}
}