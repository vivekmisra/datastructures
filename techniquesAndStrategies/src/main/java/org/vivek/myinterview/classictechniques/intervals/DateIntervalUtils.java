package org.vivek.myinterview.classictechniques.intervals;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Arrays;
import java.util.Comparator;
import java.util.Date;

public class DateIntervalUtils {
	static SimpleDateFormat formatter = new SimpleDateFormat("dd/MM/yyyy");

	public static void main(String[] args) {
		Period[] periods = new Period[3];
		
		periods[0] = new Period("05/14/2019", "05/17/2019");		
		periods[1] = new Period("05/12/2019", "05/13/2019");
		periods[2] = new Period("05/18/2019", "05/19/2019");
		boolean overlap = isOverLapping(periods);
		System.out.println("overlap==>?"+ overlap);
	}

	static boolean isOverLapping(Period[] periods) {
		Arrays.sort(periods, new PeriodComparator());
		Period t = periods[0];
		for (int i =1;i<periods.length;i++) {
			 Period c = periods[i];
			 Date t_start = toDate(t.getStart());
             Date t_end  = toDate(t.getEnd());
             Date c_start =toDate(c.getStart());
             Date c_end =toDate(c.getEnd());			
			 if(c_start.getTime() <= t_end.getTime()){
		           return true;
		     }else{
		            
		            t = c;
		     }

		}
		return false;
	}



	private static Date toDate(String start) {
		Date date = null;
		try {

			date = formatter.parse(start);

		} catch (ParseException e) {
			e.printStackTrace();
		}
		return date;
	}

	

	static class Period {
		private String start;
		private String end;

		public Period(String start, String end) {
			this.start = start;
			this.end = end;
		}

		public String getStart() {
			return start;
		}

		public void setStart(String start) {
			this.start = start;
		}

		public String getEnd() {
			return end;
		}

		public void setEnd(String end) {
			this.end = end;
		}

		@Override
		public String toString() {
			return "Period [start=" + start + ", end=" + end + "]";
		}

	}

	static class PeriodComparator implements Comparator<Period> {

		public int compare(Period p1, Period p2) {
			String p1start = p1.getStart();
			Date p1startDate = toDate(p1start);
			String p2start = p2.getStart();
			Date p2startDate = toDate(p2start);
			if (p1startDate.before(p2startDate)) {
				return -1;
			} else if (p1startDate.after(p2startDate)) {
				return 1;
			} else {
				return 0;
			}
		}
	}

}
