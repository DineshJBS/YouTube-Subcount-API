import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLConnection;
import java.util.Scanner;

import org.json.JSONObject;

public class YT {

	public static void main(String[] args) {
		
		
		// YouTube : CookingShooking
		
		StringBuilder url1 = 
				new StringBuilder("https://www.googleapis.com/youtube/v3/channels?part=statistics&forUsername=CookingShooking&key=AIzaSyA38rFAy0KNNvdXj81yFeHFRkkU1RkZDjA");
		
		// YouTube : Shaan Geo
		
		StringBuilder url2 = 
				new StringBuilder("https://www.googleapis.com/youtube/v3/channels?part=statistics&forUsername=ShaanGeo&key=AIzaSyA38rFAy0KNNvdXj81yFeHFRkkU1RkZDjA");
		
		
		// YouTube API is providing data of only few channels
		
		try {
			
			URL u = 
					new URL(url2.toString());
			try {
				// creating URL connection and opening the connection
				
				URLConnection conn = u.openConnection();
				
				conn.connect();
				
				// Using BufferReader to read the inputStream from connection
				BufferedReader br = new BufferedReader(new InputStreamReader(conn.getInputStream()));
				
				StringBuilder sb = new StringBuilder();
				
				String line;
				
				// reads the lines of text from BufferredReader object and append it to StringBuilder object
				
				while((line = br.readLine()) != null) {
					sb.append(line + "\n");
				}
				
				br.close();
				
				// converting StringBuilder object to String and then to JSON
				
				JSONObject jsonObj = new JSONObject(sb.toString());
				
				
				// accessing the nested object subscribersCount from the larger JSON Object 
				JSONObject subJSONObj= 
						jsonObj.getJSONArray("items").getJSONObject(0).getJSONObject("statistics");
				
				System.out.println("Total Subscribers of the channel " + subJSONObj.get("subscriberCount").toString());
			} catch (IOException e) {
				
				e.printStackTrace();
			}
		} catch (MalformedURLException e) {
			
			e.printStackTrace();
		}

	}

}
