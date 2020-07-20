import java.util.*;

import org.xml.sax.Attributes;
import org.xml.sax.SAXException;
import org.xml.sax.helpers.DefaultHandler;


public class AddressParser extends DefaultHandler {

    public static Map<String, Integer> addrMap = new HashMap<>();
    public static ArrayList<Address> addrList = new ArrayList<>();
    private static Address addr = null;

    @Override
    public void startElement(String uri, String localName, String qName, Attributes attributes) throws SAXException {

        if (qName.equals("item")) {
            addr = new Address();
            addr.setCity(attributes.getValue("city"));
            addr.setStreet(attributes.getValue("street"));
            addr.setHouse(attributes.getValue("house"));
            addr.setFloor(Integer.parseInt(attributes.getValue("floor")));
        }
    }

    @Override
    public void endElement(String uri, String localName, String qName) throws SAXException {
        if (qName.equals("item")) {
            if (addrMap.containsKey(addr.toString())) {
                addrMap.put(addr.toString(), addrMap.get(addr.toString()) + 1);
            } else {
                addrMap.put(addr.toString(), 1);
                addrList.add(addr);
            }
        }
    }
}