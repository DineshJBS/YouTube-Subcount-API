import java.util.Scanner;

public class testURL {

	public static void main(String[] args) {
		
//		Scanner sc = new Scanner(System.in);
//		String str = sc.nextLine();
		
		StringBuilder url = 
				new StringBuilder("https://www.googleapis.com/youtube/v3/channels?part=statistics&forUsername=&key=AIzaSyA38rFAy0KNNvdXj81yFeHFRkkU1RkZDjA");
		
		//System.out.println(url);
		
		url.insert(75, "ShaanGeo");
		System.out.println(url);
		
		StringBuilder url1 = new StringBuilder("https://www.googleapis.com/youtube/v3/channels?part=statistics&forUsername=ShaanGeo&key=AIzaSyA38rFAy0KNNvdXj81yFeHFRkkU1RkZDjA");

		System.out.println(url.toString().equals(url1));
		System.out.println(url1);
	}

}
