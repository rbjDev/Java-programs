import java.time.*;
import java.time.format.*;
import java.time.temporal.TemporalAccessor;
import java.util.Locale;
public class DateTimeExample {
    public static void main(String[] args){
    DateTimeFormatter dtf = DateTimeFormatter.ofPattern("MMM dd yyyy hh:mm:ssa z");
    // DateTimeFormatter dtf = new DateTimeFormatterBuilder()
    // .append(DateTimeFormatter.ofPattern("MMM dd YYYY hh:mm:ssa z"))
    // .toFormatter()
    // .withZone(ZoneId.of("America/New_York"));

    ZonedDateTime now = ZonedDateTime.now();
	ZoneId TIMEZONE_ET = ZoneId.of("America/New_York");
	ZonedDateTime estDateTime = now.withZoneSameInstant(TIMEZONE_ET);
    String estDateString = "Feb 14 2022 08:31:09AM EST";//dtf.format(estDateTime);
    System.out.println("String date-time:" + estDateString);
    
    //.parseCaseInsensitive()
   // DateTimeFormatter dtf1 = DateTimeFormatter.ofLocalizedDateTime(FormatStyle.MEDIUM).ofPattern("MMM-dd-YYYY hh:mm:ssa z");
    TemporalAccessor t = dtf.parse(estDateString);
    // LocalDate localDate = LocalDate.from(t);
    System.out.println(ZonedDateTime.parse(estDateString,dtf));


    
    }
}
