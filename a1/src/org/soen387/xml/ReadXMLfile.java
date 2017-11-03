package org.soen387.xml;

import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.DocumentBuilder;

import org.w3c.dom.Document;
import org.w3c.dom.NodeList;
import org.w3c.dom.Node;
import org.w3c.dom.Element;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

// Read and parse XML files
public class ReadXMLfile {
	
	public int iteration = 0;
	public String[] fileList = new String[14];
	public GameData[] gameList = new GameData[5];
	public List<GameData> fullGameList = new ArrayList<GameData>();
	
	public ReadXMLfile(){
		// make a 5 games for each xml files
		for(int h=0; h<5;h++){
			gameList[h] = new GameData();
		}
		

		//list of possible xml files to open
		fileList[0] = "zelda";
		fileList[1] = "mario";
		fileList[2] = "batman";
		fileList[3] = "boy";
		fileList[4] = "car";
		fileList[5] = "creed";
		fileList[6] = "diablo";
		fileList[7] = "fish";
		fileList[8] = "miami";
		fileList[9] = "myst";
		fileList[10] = "rabbit";
		fileList[11] = "red";
		fileList[12] = "sky";
		fileList[13] = "tokyo";
		
		//Populate the GameData array
		createGamelist();
	}
    public List<GameData> getGameData(){
    	return fullGameList;
    }
    
	// list of files to loop throught
	private void createGamelist(){
		
		String currentFile = "";

		// loop throught the fileList names
		for(int i=0; i < fileList.length; i++){
			//iteration =0;
			// get file name
			currentFile = fileList[i];
			
			// set first xml in the object
			setGame(currentFile);
		}
		
		for(int k=0; k<fullGameList.size();k++){
			System.out.println("THIS IS THE LIST: "+fullGameList.get(k).getGameTitle() );
		}
	}
	
	private void setGame(String currentFile){
		
		try{
			File myXML = myXML = new File("C:/Users/mrtnchps/workspace/a1/WebContent/WEB-INF/xml/"+currentFile+"/"+currentFile+".xml");
			
			
			DocumentBuilderFactory dbFactory = DocumentBuilderFactory.newInstance();
			DocumentBuilder dBuilder = dbFactory.newDocumentBuilder();
			Document doc = dBuilder.parse(myXML);
			
			doc.getDocumentElement().normalize();
			
			NodeList nList = doc.getElementsByTagName("Game");
			
			for (int i = 0; i < 5; i++) {// 5 because it's the limit of games that I asked
				Node nNode = nList.item(i);
				if(nNode == null) break;
				
				if (nNode.getNodeType() == Node.ELEMENT_NODE) {

					Element eElement = (Element) nNode;
					String id = eElement.getElementsByTagName("id").item(0).getTextContent();
					System.out.println("id : " +  id );
					gameList[i].setId(id);
					String GameTitle = eElement.getElementsByTagName("GameTitle").item(0).getTextContent();
					gameList[i].setGameTitle(GameTitle);
					System.out.println("gameTitle : " + GameTitle);
					String ReleaseDate = eElement.getElementsByTagName("ReleaseDate").item(0).getTextContent();
					System.out.println("releaseDate : " + ReleaseDate);
					gameList[i].setReleaseDate(ReleaseDate);
					String Platform = eElement.getElementsByTagName("Platform").item(0).getTextContent();
					System.out.println("Platform : " + Platform );
					gameList[i].setPlatform(Platform);
					
					
				}
			}
			setGameDescription(currentFile);
			//iteration += 5;// record where you are at.
			
			
		}catch (Exception e) {
			e.printStackTrace();
	    }
	}
	
	public void setGameDescription(String currentFile){
		
		// go back in the list to set description and art
		
		//int start = iteration; 
		//int end = iteration +10;
		try{
			File myXMLdesc = null;
			File myXMLart = null;
			for(int it = 0; it < 5; it++){
				try{
					myXMLdesc = new File("C:/Users/mrtnchps/workspace/a1/WebContent/WEB-INF/xml/"+currentFile+"/"+currentFile+"_desc"+it+".xml");
					myXMLart = new File("C:/Users/mrtnchps/workspace/a1/WebContent/WEB-INF/xml/"+currentFile+"/"+currentFile+"_art"+it+".xml");
					
				}catch(Exception e){
					System.out.println("file is not found");
					return;
				}
				DocumentBuilderFactory dbFactorydesc = DocumentBuilderFactory.newInstance();
				DocumentBuilderFactory dbFactoryart = DocumentBuilderFactory.newInstance();
				DocumentBuilder dBuilderdesc = dbFactorydesc.newDocumentBuilder();
				DocumentBuilder dBuilderart = dbFactoryart.newDocumentBuilder();
				Document docDesc = dBuilderdesc.parse(myXMLdesc);
				Document docArt = dBuilderart.parse(myXMLart);
				
				docDesc.getDocumentElement().normalize();
				docArt.getDocumentElement().normalize();
				
				NodeList nListDesc = docDesc.getElementsByTagName("Game");
				NodeList nListArt = docArt.getElementsByTagName("Images");
				
				Node nNodeDesc = nListDesc.item(0);
				Node nNodeArt = nListArt.item(0);
				if (nNodeDesc.getNodeType() == Node.ELEMENT_NODE) {
					
					Element eElementDesc = (Element) nNodeDesc;
					
					if(eElementDesc.getElementsByTagName("Overview").item(0) != null){
						String overview = eElementDesc.getElementsByTagName("Overview").item(0).getTextContent();
						gameList[it].setOverview(overview);
						System.out.println("overview : " +  overview );
					}
					
					
					if(eElementDesc.getElementsByTagName("Players").item(0) != null){
						String num_players = eElementDesc.getElementsByTagName("Players").item(0).getTextContent();
						gameList[it].setNum_players(num_players);
						System.out.println("num_players : " +  num_players );
					}
					
					if(eElementDesc.getElementsByTagName("Co-op").item(0) != null){
						String coop = eElementDesc.getElementsByTagName("Co-op").item(0).getTextContent();
						gameList[it].setCoop(coop);
						System.out.println("coop : " +  coop );
					}
					
					if(eElementDesc.getElementsByTagName("Genres").item(0) != null){
						String genre = eElementDesc.getElementsByTagName("Genres").item(0).getTextContent();
						gameList[it].setGenre(genre);
						System.out.println("genre : " +  genre );
					}
					
					if(eElementDesc.getElementsByTagName("Developer").item(0) != null){
						String developer = eElementDesc.getElementsByTagName("Developer").item(0).getTextContent();
						gameList[it].setGenre(developer);
						System.out.println("developer : " +  developer );
					}
					
					if( eElementDesc.getElementsByTagName("Publisher").item(0) != null){
						String publisher = eElementDesc.getElementsByTagName("Publisher").item(0).getTextContent();
						gameList[it].setGenre(publisher);
						System.out.println("publisher : " +  publisher );
					}
					gameList[it].setComments("no comments");
				}
				
				if (nNodeArt.getNodeType() == Node.ELEMENT_NODE) {
					Element eElementArt = (Element) nNodeArt;
					
					if(eElementArt.getElementsByTagName("boxart").item(0) != null){
						String frontArt = eElementArt.getElementsByTagName("boxart").item(0).getTextContent();
						gameList[it].setFront_box_art(frontArt);
						System.out.println("developer : " +  frontArt );
					}
					
					
					if(eElementArt.getElementsByTagName("banner").item(0) != null){
						String backArt = eElementArt.getElementsByTagName("banner").item(0).getTextContent();
						gameList[it].setBack_box_art(backArt);
						System.out.println("developer : " +  backArt );
					}
					
					if(eElementArt.getElementsByTagName("logo").item(0) != null){
						String logo = eElementArt.getElementsByTagName("logo").item(0).getTextContent();
						gameList[it].setLogo(logo);
						System.out.println("developer : " +  logo );
					}
					
				}
				/*
				if((nNodeArt.getNodeType() == Node.ELEMENT_NODE) || (nNodeDesc.getNodeType() == Node.ELEMENT_NODE)){
					
					
					// reset the array for the next loop
					gameList = new GameData[5];
					for(int i=0; i< gameList.length;i++){
						gameList[i] = new GameData();
					}
				}
				*/
				/*
				// inside the loop because it is taking 5 description and 5 art for each file xml
				for(int i = 0; i< gameList.length;i++){
					System.out.println(gameList[i].getGameTitle() +" is added at position "+ i);
					fullGameList.add(gameList[i]);
				}*/
			}//end of for loop
			
			

			
		}catch(Exception e){
			e.printStackTrace();
		}finally{
			for(int ii=0; ii< gameList.length; ii++){
				fullGameList.add(gameList[ii]);
				System.out.println("ADDING..."+gameList[ii].getGameTitle());
			}
			
			// reset the array for the next loop
			gameList = new GameData[5];
			for(int i=0; i< gameList.length;i++){
				gameList[i] = new GameData();
			}
		}
	}
	public static void main(String[] args) {
		ReadXMLfile xm = new ReadXMLfile();
		System.out.println("iteration: ");
	}
		
}
