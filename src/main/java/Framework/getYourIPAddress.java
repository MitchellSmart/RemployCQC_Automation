package Framework;

public class getYourIPAddress {
	
	
	public static String getYourIP() {
    String IP = "";
    try {
    java.net.InetAddress i = java.net.InetAddress.getLocalHost();
    //System.out.println(i);                  // name and IP address
    //System.out.println(i.getHostName());    // name
    //System.out.println(i.getHostAddress()); // IP address only
    IP = i.getHostAddress();
    
    }
    catch(Exception e){e.printStackTrace();}
	return IP;
  }

}
