package eisCurrency;

import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.ArrayList;
import java.util.Scanner;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;

public class CurrencyDownloadAndRead {
	Scanner sc = new Scanner(System.in);
	String url;

	public void urlSetUp(String ccy, String dtFrom, String dtTo) {
		url = "http://www.lb.lt/webservices/fxrates/FxRates.asmx/getFxRatesForCurrency?tp=Eu" + "&ccy=" + ccy
				+ "&dtFrom=" + dtFrom + "&dtTo=" + dtTo;
	}

	public Document DownloadXML() {
		try {
			HttpURLConnection connection = (HttpURLConnection) new URL(url).openConnection();
			connection.addRequestProperty("User-Agent", "UFC-8");
			InputStream response = connection.getInputStream();
			DocumentBuilderFactory dbf = DocumentBuilderFactory.newInstance();
			DocumentBuilder db = dbf.newDocumentBuilder();
			Document doc = db.parse(response);
			return doc;
		} catch (Exception e) {
			e.printStackTrace();
			System.out.println("Klaida ávyko bandant nuskaityti XML faila.");
			return null;
		}
	}

	public void XMLReading(String ccy) {
		ArrayList<Float> changeInRate = new ArrayList<>();
		NodeList currency = DownloadXML().getElementsByTagName("FxRate");
		System.out.println("EUR santykis su " + ccy);
		for (int i = 0; i < currency.getLength(); i++) {
			Node node = currency.item(i);
			if (node.getNodeType() == Node.ELEMENT_NODE) {
				Element el = (Element) node;
				System.out.println("Data: " + el.getElementsByTagName("Dt").item(0).getTextContent());
				System.out.println("Kursas: " + el.getElementsByTagName("Amt").item(1).getTextContent());
				float amtFloat = Float.parseFloat(el.getElementsByTagName("Amt").item(1).getTextContent());
				changeInRate.add(amtFloat);
				float RatesChangeCount = changeInRate.get(0) - changeInRate.get(changeInRate.size() - 1);
				if (RatesChangeCount != 0)
					System.out.println("Pokytis: " + RatesChangeCount + "\n");
			} else {
				System.out.println("");
			}
		}
	}
}
