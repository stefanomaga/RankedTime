public class MainHelper {

	public void rolePicked(String role) {
	
		if(role.equals("Top")) {
			Main.TOP = false;
		}
		
		if(role.equals("Mid")) {
			Main.MID = false;
		}
		
		if(role.equals("Jungler")) {
			Main.JUNGLER = false;
		}
		if(role.equals("Adc")) {
			Main.ADC = false;
		}
		if(role.equals("Support")) {
			Main.SUPPORT = false;
		}
		
	}
	
}
