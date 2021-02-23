package com.smsalert;

import java.io.IOException;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.List;
import java.util.concurrent.TimeUnit;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.Configuration;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.web.bind.annotation.GetMapping;

import com.smsalert.helpers.SMSHelper;
import com.smsalert.model.Bike;
import com.smsalert.repository.BikeRepository;

@SpringBootApplication
public class SmsAlert {

	private static BikeRepository bikeRepository;
	public static void main(String[] args) {
	ApplicationContext ctx=	SpringApplication.run(SmsAlert.class, args);
	 		bikeRepository= ctx.getBean(BikeRepository.class);
	}
	
	public void servicingReminder()
	{
	     List<Bike> customers = bikeRepository.findAll();
	     customers.forEach(c->{
	    	 System.out.println(c.getName()+" "+c.getMobileNo()+" "+c.getNextServiceDate()+""+c.getVehicleNo());
	    	 String nextdate =c.getNextServiceDate();
	    	
	    	 DateFormat format = new SimpleDateFormat("yyyy-MM-dd");
	    	 Date ndate=null;
			try {
				ndate = format.parse(nextdate);
			} catch (ParseException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
	    	long days=getDaysBetweenDates(new Date(),ndate);
			System.out.println("Days= "+ days);
	    	if(days == 0  || days == 7 || days == -7)
	    		{
	    		try {
				String response=new SMSHelper().Message1(c.getName(),c.getMobileNo(),c.getVehicleNo());
				if(response !="")
					System.out.println("Servicing Reminder sent to "+c.getName()+" Successfully at "+new Date());
	    		} catch (Exception e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
	    		
	    		}
	     });

		
	}
	
	public static  long getDaysBetweenDates(Date d1, Date d2){
		return TimeUnit.MILLISECONDS.toDays(d1.getTime() - d2.getTime());
		}	

	@Scheduled(cron= "${smsJob.delay}")
	void smsJob()
	{
		System.out.println("Todays date is:"+LocalDateTime.now());
		System.out.println("Servicing Reminder Job Executing..........");
		servicingReminder();
	}

}

@Configuration
@EnableScheduling
@ConditionalOnProperty(name="scheduling.enabled",matchIfMissing=true)
class Schedulingconfigurations
{
}















