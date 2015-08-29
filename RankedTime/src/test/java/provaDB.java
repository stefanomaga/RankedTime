import model.Champion;
import model.Summoner;
import model.facade.FacadeChampion;
import model.facade.FacadeSummoner;

public class provaDB {

public static void main(String[] args) {
	FacadeChampion facadeChampion = new FacadeChampion();
	Champion champion = facadeChampion.findChampion("Warwick");
	System.out.println(champion.toString());
	
	FacadeSummoner facadeSummoner = new FacadeSummoner();
	Summoner summoner = facadeSummoner.findSummoner("Frappolo");
	System.out.println(summoner.toString());
}	
}
