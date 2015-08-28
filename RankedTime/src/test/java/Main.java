import java.util.ArrayList;
import java.util.List;

import model.Champion;
import model.Summoner;
import model.facade.FacadeChampion;
import model.facade.FacadeSummoner;

public class Main {

	static boolean TOP = true;
	static boolean MID = true;
	static boolean JUNGLER = true;
	static boolean ADC = true;
	static boolean SUPPORT = true;
	
	public static void main(String[] args) {

		FacadeChampion facadeChampion = new FacadeChampion();
		FacadeSummoner facadeSummoner = new FacadeSummoner();
		
		MainHelper helper = new MainHelper();

		String banAlleato1 = "";
		String banAlleato2 = "";
		String banAlleato3 = "";

		String banNemico1 = "";
		String banNemico2 = "";
		String banNemico3 = "";

		List<String> bans = new ArrayList<String>();
		bans.add(banAlleato1);
		bans.add(banAlleato2);
		bans.add(banAlleato3);
		bans.add(banNemico1);
		bans.add(banNemico2);
		bans.add(banNemico3);

		Champion pickAlleato1 = facadeChampion.findChampion("");
		String rolePickAlleato1 = "";
		pickAlleato1.setRole(rolePickAlleato1);
		helper.rolePicked(rolePickAlleato1);
		
		Champion pickAlleato2 = facadeChampion.findChampion("");
		String rolePickAlleato2 = "";
		pickAlleato2.setRole(rolePickAlleato2);
		helper.rolePicked(rolePickAlleato2);
	
		Champion pickAlleato3 = facadeChampion.findChampion("");
		String rolePickAlleato3 = "";
		pickAlleato3.setRole(rolePickAlleato3);
		helper.rolePicked(rolePickAlleato3);

		
		Champion pickAlleato4 = facadeChampion.findChampion("");
		String rolePickAlleato4 = "";
		pickAlleato4.setRole(rolePickAlleato4);
		helper.rolePicked(rolePickAlleato4);

		
		List<Champion> alliedChampions = new ArrayList<Champion>();
		alliedChampions.add(pickAlleato1);
		alliedChampions.add(pickAlleato2);
		alliedChampions.add(pickAlleato3);
		alliedChampions.add(pickAlleato4);
		
		Champion pickNemico1 = facadeChampion.findChampion("");
		Champion pickNemico2 = facadeChampion.findChampion("");
		Champion pickNemico3 = facadeChampion.findChampion("");
		Champion pickNemico4 = facadeChampion.findChampion("");
		Champion pickNemico5 = facadeChampion.findChampion("");
		
		List<Champion> enemyChampions = new ArrayList<Champion>();
		enemyChampions.add(pickNemico1);
		enemyChampions.add(pickNemico2);
		enemyChampions.add(pickNemico3);
		enemyChampions.add(pickNemico4);
		enemyChampions.add(pickNemico5);

		Summoner summoner = facadeSummoner.findSummoner("");

		List<Champion> favouriteChampions = summoner.getChampions();
		
		if (!TOP) {
			for (Champion champion : favouriteChampions) {
				String role = champion.getRole();
				if (role.equals("Top")) {
					favouriteChampions.remove(champion);
				}
			}
		}
		
		if (!MID) {
			for (Champion champion : favouriteChampions) {
				String role = champion.getRole();
				if (role.equals("Mid")) {
					favouriteChampions.remove(champion);
				}
			}
		}
		
		if (!JUNGLER) {
			for (Champion champion : favouriteChampions) {
				String role = champion.getRole();
				if (role.equals("Jungler")) {
					favouriteChampions.remove(champion);
				}
			}
		}
		
		if (!ADC) {
			for (Champion champion : favouriteChampions) {
				String role = champion.getRole();
				if (role.equals("Adc")) {
					favouriteChampions.remove(champion);
				}
			}
		}
		
		if (!SUPPORT) {
			for (Champion champion : favouriteChampions) {
				String role = champion.getRole();
				if (role.equals("Support")) {
					favouriteChampions.remove(champion);
				}
			}
		}
		
		for (String ban : bans) {
			Champion championBanned = facadeChampion.findChampion(ban);
			favouriteChampions.remove(championBanned);
		}
		
		for (Champion champion : alliedChampions) {
			Champion championPicked = facadeChampion.findChampion(champion.getName());
			favouriteChampions.remove(championPicked);
			List<Champion> goodWith = champion.getGoodWith();
			for (Champion i : goodWith) {
				for (Champion j : favouriteChampions) {
					if(i.equals(j)) {
						i.setValue(i.getValue() + 1);
					}
				}
			}
			
		}
		
		for (Champion champion : enemyChampions) {
			Champion championPicked = facadeChampion.findChampion(champion.getName());
			favouriteChampions.remove(championPicked);
			List<Champion> goodAgainst = champion.getGoodAgainst();
			for (Champion i : goodAgainst) {
				for (Champion j : favouriteChampions) {
					if(i.equals(j)) {
						i.setValue(i.getValue() + 1);
					}
				}
			}
			List<Champion> weakAgainst = champion.getWeakAgainst();
			for (Champion i : weakAgainst) {
				for (Champion j : favouriteChampions) {
					if(i.equals(j)) {
						i.setValue(i.getValue() - 1);
					}
				}
			}
		}
		
		int max = 0;
		for (Champion champion : favouriteChampions) {
			int value = champion.getValue();
			if( value > max) {
				max = value;
			}
		}
		
		for (Champion champion : favouriteChampions) {
			if(champion.getValue() == max){
				System.out.println(champion.toString());
			}
		}

	}
}
