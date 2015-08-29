package persistence.clusterPoint;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.w3c.dom.Element;
import org.w3c.dom.NodeList;

import com.clusterpoint.api.CPSConnection;
import com.clusterpoint.api.request.CPSSearchRequest;
import com.clusterpoint.api.response.CPSSearchResponse;

import model.Champion;
import model.Summoner;
import model.facade.FacadeChampion;
import persistence.SummonerDAO;

public class SummonerDAOClusterPoint implements SummonerDAO {
	private DataSource data;

	public SummonerDAOClusterPoint() {
		this.data = new DataSource();
	}

	public boolean insert(Summoner summoner) {
		// TODO Auto-generated method stub
		return false;
	}

	public boolean delete(Summoner summoner) {
		// TODO Auto-generated method stub
		return false;
	}

	public boolean deleteAll() {
		// TODO Auto-generated method stub
		return false;
	}

	public Summoner findByUsername(String username) {
		
		Summoner summoner = new Summoner();
		FacadeChampion facadeChampion = new FacadeChampion();

		CPSConnection connessione;

		try {
			connessione = this.data.getConnection("Summoners");

			String query = "<id>" + username + "</id>";

			// return documents starting with the first one - offset 0
			int offset = 0;
			// return not more than 5 documents
			int docs = 5;
			// return these fields from the documents
			Map<String, String> list = new HashMap<String, String>();
			list.put("id", "yes");

			CPSSearchRequest search_req = new CPSSearchRequest(query, offset, docs, list);
			CPSSearchResponse search_resp = (CPSSearchResponse) connessione.sendRequest(search_req);

			if (search_resp.getHits() > 0) {
				List<Element> documents = search_resp.getDocuments();

				for (Element element : documents) {
					NodeList attributes = element.getChildNodes();
					String id = attributes.item(0).getTextContent();
					String password = attributes.item(1).getTextContent();
					List<Champion> favouriteChampions = new ArrayList<Champion>();

					NodeList champions = attributes.item(2).getChildNodes();

					for (int i = 0; i < champions.getLength() -1; i++) {
						NodeList championNode = champions.item(i).getChildNodes();
						String championName = championNode.item(0).getTextContent();
						String championRole = championNode.item(1).getTextContent();
						Champion champion = facadeChampion.findChampion(championName);
						champion.setRole(championRole);
						favouriteChampions.add(champion);
					}

					summoner = new Summoner(id, password, favouriteChampions);
				}
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return summoner;

	}

	public List<Summoner> findAll() {
		// TODO Auto-generated method stub
		return null;
	}

}
