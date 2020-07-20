import org.xml.sax.SAXException;

import javax.xml.parsers.ParserConfigurationException;
import javax.xml.parsers.SAXParser;
import javax.xml.parsers.SAXParserFactory;
import java.io.File;
import java.io.IOException;
import java.util.Map;

public class Main extends AddressParser {
    public static void main(String[] args) throws ParserConfigurationException, SAXException, IOException {

        try {
            SAXParserFactory parserFactor = SAXParserFactory.newInstance();
            SAXParser parser = parserFactor.newSAXParser();
            AddressParser handler = new AddressParser();

            parser.parse(new File(args[0]), handler);

            System.out.println("Дублирующиеся записи");
            for (Map.Entry<String, Integer> entry : addrMap.entrySet()) {
                if (entry.getValue() > 1) {
                    System.out.println(entry.getKey() + " // Количество повторений: " + entry.getValue());
                }
            }
            addrMap.clear();

            for (int f = 1; f < 6; f++) {
                System.out.println("\n======");
                System.out.println(f + "-этажных зданий:");
                for (Address a : addrList) {
                    if (a.getFloor() == f) {
                        if (addrMap.containsKey(a.getCity())) {
                            addrMap.put(a.getCity(), addrMap.get(a.getCity()) + 1);
                        } else addrMap.put(a.getCity(), 1);
                    }
                }

                for (Map.Entry<String, Integer> entry : addrMap.entrySet()) {
                    System.out.println(entry.getKey() + " = " + entry.getValue());
                }
                addrMap.clear();
            }
        } catch (SAXException e) {
            e.printStackTrace();
        }
    }
}