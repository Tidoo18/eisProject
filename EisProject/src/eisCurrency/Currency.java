package eisCurrency;

import java.time.LocalDate;
import java.util.Arrays;
import java.util.Scanner;

public class Currency {

	String tp; // type EU or LT
	String ccy; // Currency
	String dtFrom; // Date from
	String dtTo; // Date to

	Scanner sc = new Scanner(System.in);
	final String[] countryCurrencyName = { "AUD", "BGN", "BRL", "CAD", "CHF", "CNY", "CZK", "DKK", "GBP", "HKD", "HRK",
			"HUF", "IDR", "ILS", "INR", "ISK", "JPY", "KRW", "MXN", "MYR", "NOK", "NZD", "PHP", "PLN", "RON", "RUB",
			"SEK", "SGD", "THB", "TRY", "USD", "ZAR" };

	boolean MainMenu = true;
	boolean SubMenu = true;
	CurrencyDownloadAndRead initialize = new CurrencyDownloadAndRead();

	public void launch() {
		while (MainMenu) {
			do {
				System.out.println("Iveskite valiutos koda á kurá konvertuosite:");
				ccy = sc.nextLine().toUpperCase();
			} while (!isCurrencyValid(ccy));

			System.out.println("A: Gauti vienos datos valiutos kursà?");
			System.out.println("B: Gauti datø periodo valiutos kursus?");
			String choseAnswer = sc.next().toUpperCase();
			switch (choseAnswer) {
			case "A":
				do {
					System.out.println("\nDatos formatas yyyy-mm-dd \nIveskite data:  ");
					dtFrom = sc.next().replaceAll("\\s", "");
				} while (!isDateValid(dtFrom));
				initialize.urlSetUp(ccy, dtFrom, dtFrom);
				initialize.XMLReading(ccy);
				break;
			case "B":
				do {
					System.out.println("\nDatos formatas yyyy-mm-dd \nIveskite data nuo:  ");
					dtFrom = sc.next().replaceAll("\\s", "");
				} while (!isDateValid(dtFrom));
				do {
					System.out.println("\nDatos formatas yyyy-mm-dd \nIveskite data iki:");
					dtTo = sc.next().replaceAll("\\s", "");
				} while (!isDateValid(dtTo));
				initialize.urlSetUp(ccy, dtFrom, dtTo);
				initialize.XMLReading(ccy);
				break;
			default:
				System.out.println("Ávyko klaida, praðome bandyti dar karta.");
				break;
			}
			System.out.println("\nAr norëtumëte dar karta paleisti programa?\n1 ) Taip\n2 ) Ne");
			if (sc.nextInt() == 1) {
				MainMenu = true;
			} else {
				System.out.println("Programa iðjungta.");
				System.exit(0);
			}
		}
		sc.close();

	}

	public boolean isCurrencyValid(String currency) {
		if (Arrays.asList(countryCurrencyName).contains(currency)) {
			return true;
		}
		System.out.println("Valiuta ávesta neteisingai. Bandykite dar karta.");
		return false;
	}

	public boolean isDateValid(String date) {
		LocalDate lastDateAvailable = LocalDate.parse("2014-09-30");
		try {
			LocalDate inputDate = LocalDate.parse(date);
			if (inputDate.isBefore(lastDateAvailable)) {
				System.out.println("Áraðai rodomi nuo 2014-09-30 dienos.");
			} else if (inputDate.isAfter(LocalDate.now())) {
				System.out.println("Data negali buti didesnë nei ðiandienos diena.\nRodoma paskutinë galima diena.");
			}
			return true;
		} catch (Exception e) {
			e.printStackTrace();
			System.out.println("Data neteisingai suvesta");
			return false;
		}
	}
}
