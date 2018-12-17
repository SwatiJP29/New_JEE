package pack010welcome;

import java.util.Calendar;
import java.util.Date;
import java.util.TimeZone;

public class ZoneWiseTime
	{	public static String getTimeInZone(String country)
			{	String zone;
				if (country.equalsIgnoreCase("usa"))
					zone = "America/Los_Angeles";
				else if (country.equalsIgnoreCase("Russia"))
					zone = "Europe/Moscow";
				else if (country.equalsIgnoreCase("Japan"))
					zone = "Asia/Tokyo";
				else if (country.equalsIgnoreCase("Britain"))
					zone = "Europe/London";
				else if (country.equalsIgnoreCase("South Africa"))
					zone = "Africa/Johannesburg";
				else
					zone = "Asia/Calcutta";
			
				Calendar cal = Calendar.getInstance(TimeZone.getTimeZone(zone));
				cal.setTime(new Date());
				return format(cal);
			}
				
		public static String format(Calendar cal)
			{	int day = cal.get(Calendar.DAY_OF_MONTH);
				int month = cal.get(Calendar.MONTH);
				int year = cal.get(Calendar.YEAR);
				int hours = cal.get(Calendar.HOUR_OF_DAY);
				int minutes = cal.get(Calendar.MINUTE);
				
				String [] monthNames = {"Jan", "Feb", "Mar", "Apr", "May", "Jun", "Jul", "Aug", "Sep", "Oct", "Nov", "Dec"};
				return day+"th "+monthNames[month]+" "+year+"  "+hours+":"+minutes;
			}
		
		public static void main(String[] argb)
			{	System.out.println("Time India       :"+ZoneWiseTime.getTimeInZone("India"));
				System.out.println("Time USA     	 :"+ZoneWiseTime.getTimeInZone("usa"));
				System.out.println("Time Russia      :"+ZoneWiseTime.getTimeInZone("Russia"));
				System.out.println("Time Japan       :"+ZoneWiseTime.getTimeInZone("Japan"));
				System.out.println("Time Britain	 :"+ZoneWiseTime.getTimeInZone("Britain"));
				System.out.println("Time South Africa:"+ZoneWiseTime.getTimeInZone("South Africa"));
			}
	}
