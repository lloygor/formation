package fr.uga.projet1;

import java.text.SimpleDateFormat;
import java.time.DayOfWeek;
import java.time.Duration;
import java.time.Instant;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.Month;
import java.time.MonthDay;
import java.time.OffsetDateTime;
import java.time.Period;
import java.time.YearMonth;
import java.time.ZoneId;
import java.time.ZoneOffset;
import java.time.ZonedDateTime;
import java.time.format.DateTimeFormatter;
import java.time.temporal.ChronoUnit;
import java.time.temporal.TemporalAdjusters;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Calendar;
import java.util.Collections;
import java.util.Date;
import java.util.List;
import java.util.Set;

import fr.uga.projet1.genericite.ExportTools;
import fr.uga.projet1.poo.Contact;
import fr.uga.projet1.poo.abstraction.CompSoldeDec;
import fr.uga.projet1.poo.heritage.CompteB;

public class App {
	@SuppressWarnings("deprecation")
	public static void main(String[] args) {
		try {
			
			CompteB cb1 = new CompteB("AAA", 400);
			CompteB cb2 = new CompteB("BBB", 300);
			int resComp = cb1.compareTo(cb2);
			System.out.println("resComp = "+resComp);
			List<CompteB> lc = new ArrayList<>();
			lc.add(cb1);
			lc.add(cb2);
			
			List<CompteB> lc2 = Arrays.asList(cb1, cb2);
			Collections.sort(lc2);
			System.out.println("Apres tri croissant :");
			for (CompteB cb: lc2) {
				System.out.println(cb);
			}
			
			lc2.sort(new CompSoldeDec());
			System.out.println("Apres tri décroissant :");
			for (CompteB cb: lc2) {
				System.out.println(cb);
			}
			
			List<Contact> contacts = 
					Arrays.asList(new Contact(1,"toto",45), 
								  new Contact(2,"titi",1));
			ExportTools.exportCsv("contacts.csv", contacts);
			System.out.println("Export OK");
			
			// java 7
			Date d = new Date();
			System.out.println(d.getDay() + "/" +  d.getMonth() + "/" + d.getYear());
			
			Calendar c = Calendar.getInstance();
			SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
			System.out.println(sdf.format(d));
			
			// copier une date
			Date d1 = new Date();
			Date d2 = new Date(d1.getTime());
			
			// java 8
			LocalDate loDate1 = LocalDate.now();
			System.out.println("loDate1" + loDate1);
			
			DateTimeFormatter dtf = DateTimeFormatter.ofPattern("dd/MM/yyyy");
			
			String loDate1Formatee = loDate1.format(dtf);
			
			// copier une date
			LocalDate  loDate3 = LocalDate.of(2018, Month.DECEMBER, 31);
			LocalDate  loDate4 = LocalDate.from(loDate3);
			
			  LocalDate dy2 = LocalDate.from(loDate3);
	            System.out.println(dy2.toString()); //yyyy-MM-dd
	            
	            //Instant : un point précis dans le temps ______________________
	            Instant instant1 = Instant.now();
	            System.out.println("instant1 = " + instant1);
	            
	            Instant instant2 = Instant.ofEpochSecond(1395100800);
	            System.out.println("instant2 = " + instant2);
	            
	            Instant instant3 = Instant.parse("2018-04-23T00:00:00.000Z");
	            System.out.println("instant3 = " + instant3);
	            
	            //Duration ___________________________________________________________
	            //ou durée en jours/heures/minutes/secondes/millisecondes/nanosecondes
	            Duration duration1 = Duration.ofDays(5);
	            Duration duration2 = Duration.of(15,  ChronoUnit.DAYS);
	            
	            //durée entre 2 instants
	            Duration diffDur = Duration.between(instant1, instant2);
	            System.out.println("diffDur = " + diffDur.toMinutes());
	            
	            //Temps Humain (fuseau horaire) ______________________________________
	            //ZonedDateTime et OffsetDateTime (équivalent à GregorianCalendar)
	            System.out.println("Available zoneIds : -----");
	            Set<String> zones =  ZoneId.getAvailableZoneIds();
	            for (String z : zones) {
	                        System.out.println(z);
	                }
	            System.out.println("---------------------------");
	            
	            //nom de la zone
	            ZonedDateTime z = ZonedDateTime.ofInstant(Instant.now(), ZoneId.of("Europe/Paris"));
	            
	            OffsetDateTime.ofInstant(Instant.now(), ZoneId.of("GMT+1"));
	            OffsetDateTime.ofInstant(Instant.now(), ZoneOffset.of("+1"));
	            
	            //Manip diverses __________________________________________
	            LocalDateTime dt1 = LocalDateTime.of(LocalDate.of(2018, 4, 24), LocalTime.of(12, 30));
	            System.out.println("dt1(iso) = " + dt1.format(DateTimeFormatter.ISO_DATE));
	            System.out.println("dt1(formatter) = " + dt1.format(DateTimeFormatter.ofPattern("dd/MM/yyyy HH:mm")));
	            
	            LocalDateTime dt2 = dt1.withHour(16).plusWeeks(3); //on se positionne à 16h et on ajoute 3 semaines
	            System.out.println("dt2 = " + dt2.toString());
	            
	            LocalDateTime dt3 = dt1.with(TemporalAdjusters.firstDayOfNextMonth()); //premier jour du mois prochain
	            System.out.println("dt3 = " + dt3.toString());
	            
	            //Dates et heures partielles ____________________________
	            LocalDate ld = LocalDate.of(2018, Month.MARCH, 18);
	            System.out.println("ld = " + ld);
	            
	            LocalTime lt = LocalTime.of(12, 0);
	            System.out.println("lt = " + lt);
	            DayOfWeek dow = DayOfWeek.of(2); //2ème jour de la semaine => TUESDAY
	            System.out.println("dow = " + dow);
	            
	            MonthDay md = MonthDay.of(Month.MARCH, 18);
	            System.out.println("md =" + md);
	            
	            YearMonth ym = YearMonth.of(2016, Month.APRIL);
	            System.out.println("ym = " + ym);
	            
	            //Period __________________________________________________
	            //représentation humaine d'une durée
	            //exemple : 1 mois (qu'il y ait 28 ou 31jours)
	            Period period1 = Period.ofMonths(3);
	            
	            //moins précis que duration
	            Period period2 = Period.between(LocalDate.of(2018, Month.JULY, 28), LocalDate.of(2018, Month.SEPTEMBER, 3));
	            System.out.println("period2(totalMonth) = " + period2.toTotalMonths());
	            System.out.println("period2(totalMonth) = " + period2.getDays());
	            
	          //date sql => localDate
                java.sql.Date d1sql = new java.sql.Date(10000);
                Date d1Convertie = new Date(d1sql.getTime());
                //Ou : 
                Date d2Convertie = Date.from(Instant.ofEpochMilli(d1sql.getTime()));
			
		} catch (Exception e) {
			System.out.println(e.getMessage());
			e.printStackTrace();
		}
	}
}
