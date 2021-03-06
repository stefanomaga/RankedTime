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
import persistence.ChampionDAO;

public class ChampionDAOClusterPoint implements ChampionDAO {
	private DataSource data;

	public ChampionDAOClusterPoint() {
		this.data = new DataSource();
	}

	public boolean insert(Champion champion) {
		// TODO Auto-generated method stub
		return false;
	}

	public boolean delete(Champion champion) {
		// TODO Auto-generated method stub
		return false;
	}

	public boolean deleteAll() {
		// TODO Auto-generated method stub
		return false;
	}

	public Champion findByName(String name) {

		System.out.println(name);

		Champion champion = new Champion();
		CPSConnection connessione;

		try {
			connessione = this.data.getConnection("Champions");

			String query = "<id>" + name + "</id>";

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
					NodeList goodAgainstNodes = attributes.item(1).getChildNodes();
					NodeList weakAgainstNodes = attributes.item(2).getChildNodes();
					NodeList goodWithNodes = attributes.item(3).getChildNodes();

					List<String> goodAgainst = new ArrayList<String>();
					List<String> weakAgainst = new ArrayList<String>();
					List<String> goodWith = new ArrayList<String>();

					for (int i = 0; i < goodAgainstNodes.getLength(); i++) {
						String championName = goodAgainstNodes.item(i).getTextContent();
						goodAgainst.add(championName);
					}

					for (int i = 0; i < weakAgainstNodes.getLength(); i++) {
						String championName = weakAgainstNodes.item(i).getTextContent();
						weakAgainst.add(championName);
					}

					for (int i = 0; i < goodWithNodes.getLength(); i++) {
						String championName = goodWithNodes.item(i).getTextContent();
						goodWith.add(championName);
					}

					champion = new Champion(id, goodAgainst, weakAgainst, goodWith);
				}
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return champion;
	}

	public List<Champion> findAll() {
		// TODO Auto-generated method stub
		return null;
	}

}
