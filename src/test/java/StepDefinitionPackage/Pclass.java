package StepDefinitionPackage;

import java.util.HashMap;

public class Pclass {

	public static void main(String[] args) {
		HashMap<Integer, String> hss = new HashMap<Integer, String>();
		hss.put(1, "abcc@gmail.com");
		hss.put(2, "fffff@gmail.com");		
		int hashsize = hss.size();
		
		for(int i=1;i<=hashsize;i++) {
			System.out.println("Mails are.." + hss.get(i));
		}
	}
}
