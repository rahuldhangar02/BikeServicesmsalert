package com.smsalert.helpers;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.UnknownHostException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import com.smsalert.model.Bike;
import com.smsalert.repository.BikeRepository;

public class SMSHelper {

	@Autowired
	private BikeRepository bikeRepository;
    
	
	
  public String Message1(String name,long mobile,String vno) throws MalformedURLException, UnknownHostException,IOException
		 {
		
		    String postData="";
		    String retval = "";
		    String Key ="45CCA906FC8559";
		    String Rootid = "100642";
		    String SenderID = "RAJASP";
		    String rootid="100642";
		    String key="45F2CE768301E7";
	          
		   String Message1="प्रिय ग्राहक "+name+" आपके किमती दो पहिया वाहन क्रमांक "+vno+" का सर्विसिंग का समय आ गया है अतः आप सर्विस कराने का कष्ट करें पता राजा सर्विस प्वाइंट बिस्टान रोड खरगोन मोबाइल नंबर 9826378167"; 
		  // String Message1 = "Dear Customer "+name+" this gentle reminder for  Service Maintaince of Your Vehicle No "+vno+" . Thank You,Regards-Raja Service Point Khargone(M.P), Helpline No:9826378167";
		    postData += "&key=" + Key + "&routeid=" + Rootid +"&contacts="+mobile+"&senderid=" + SenderID + "&msg=" + Message1;
		   // postData1 += "username=" + Username + "&password=" + Password + "&to=" + MobileNo1 +"&sender=" + SenderID + "&message=" + Message;
		   // URL url=new URL("http://sambsms.com/app/smsapi/index.php?key=55BED10B1C5C30&campaign=0&routeid=26&type=text&contacts="+MobileNo+"&senderid=MARTHN&msg='"+u1.getText()+"'");
		    URL url=new URL("http://newsms.stringsoftsolution.in/app/smsapi/index.php");
		      HttpURLConnection urlconnection = (HttpURLConnection) url.openConnection();

		                  urlconnection.setRequestMethod("POST");

		      urlconnection.setRequestProperty("Content-Type","application/x-www-form-urlencoded");

		                  urlconnection.setDoOutput(true);

		      OutputStreamWriter out = new OutputStreamWriter(urlconnection.getOutputStream());

		                out.write(postData);

		                out.close();

		                BufferedReader in = new BufferedReader(   new

		                      InputStreamReader(urlconnection.getInputStream()));

		               String decodedString;

		               while ((decodedString = in.readLine()) != null) {

		                        retval += decodedString;

		                  }

		                  in.close();

		                  System.out.println(retval);
		                  return retval;
		   }
  ///
  public String Message2(String name,long mobile,String vno) throws MalformedURLException, UnknownHostException,IOException
	 {
	
	    String postData="";
	    String retval = "";
	    String Key ="45CCA906FC8559";
	    String Rootid = "100642";
	    String SenderID = "RAJASP";
	    String rootid="100642";
	    String key="45F2CE768301E7";
       
	    String Message1="प्रिय ग्राहक "+name+" हमारे  द्वारा आपके दुपहिया वाहन  क्रमांक "+vno+"  की सर्विस की गई है। आपका दिल से धन्यवाद्।वाहन में कोई परेशानी होने पर हमें पुनः सम्पर्क करें।राजा सर्विस पांइट खरगोन मो0नं0-9826378167";
	   //String Message1 = "Thank You Mr. "+name+" for Servicing your vehicle "+vno+" at Our Service Center .Regards-Raja Service Point Khargone(M.P), Helpline No:9826378167";
	    postData += "&key=" + Key + "&routeid=" + Rootid +"&contacts="+mobile+"&senderid=" + SenderID + "&msg=" + Message1;
	   // postData1 += "username=" + Username + "&password=" + Password + "&to=" + MobileNo1 +"&sender=" + SenderID + "&message=" + Message;
	   // URL url=new URL("http://sambsms.com/app/smsapi/index.php?key=55BED10B1C5C30&campaign=0&routeid=26&type=text&contacts="+MobileNo+"&senderid=MARTHN&msg='"+u1.getText()+"'");
	    URL url=new URL("http://newsms.stringsoftsolution.in/app/smsapi/index.php");
	      HttpURLConnection urlconnection = (HttpURLConnection) url.openConnection();

	                  urlconnection.setRequestMethod("POST");

	      urlconnection.setRequestProperty("Content-Type","application/x-www-form-urlencoded");

	                  urlconnection.setDoOutput(true);

	      OutputStreamWriter out = new OutputStreamWriter(urlconnection.getOutputStream());

	                out.write(postData);

	                out.close();

	                BufferedReader in = new BufferedReader(   new

	                      InputStreamReader(urlconnection.getInputStream()));

	               String decodedString;

	               while ((decodedString = in.readLine()) != null) {

	                        retval += decodedString;

	                  }

	                  in.close();

	                  System.out.println(retval);
	                  return retval;
	   }
		 ///

       public void serviceReminder()
       {
    	   
    	     List<Bike> customers = bikeRepository.findAll();
    	     customers.forEach(c->System.out.println(c.getName()+" "+c.getMobileNo()+" "+c.getNextServiceDate()));
       }
  
  
  
}
