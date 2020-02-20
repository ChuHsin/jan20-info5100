package class6;

import java.util.HashMap;
import java.util.Map;
// using Map to implement the AppleStore interface
public class AppleStoreMapImpl implements AppleStore {

	private Map<String, iPhone> phonesMap = new HashMap<String, iPhone>();
	int totalSales = 0;
// using String as key and iPhone as value
	@Override
	public iPhone buyPhone() {
		String number = phonesMap.keySet().iterator().next(); 
		// .keySet() return a set having the keys of the hash map
		// .iterator().next(); return the next key value in the set,
		// it returns the key of the removed iPhone to the variable "number"
		iPhone p = phonesMap.remove(number); // return the bought iPhone
		totalSales += p.price; // sale increase
		return p; // return an iPhone

	}

	@Override
	public void returnPhone(iPhone phone) {
		String key = phone.number; // get the key of returned phone
		if (phonesMap.containsKey(key)) { // check if this shop have this phone
			System.out.println("I already have a phone with # " + key);
			return;
		}
		totalSales -= phone.price; // reduce the total sales
		phonesMap.put(phone.number, phone); // the this phone into the Map,
		// key is the phone.number and the value is phone object

	}

	@Override
	public int getNumberOfPhones() {
		return phonesMap.size(); // number of whole phone this store has
	}

	@Override
	public void addPhones(int numberOfPhones) {
		for (int i = phonesMap.size(); i < numberOfPhones + phonesMap.size(); i++) {
			iPhone p = makePhone(i); // add the wanted number of Phones into map
			phonesMap.put(p.number, p); // hashMap 可以随意自定义 key value, 只要保证
			// key 不重复
			
		}

	}

	@Override
	public int getTotalSales() {
		return totalSales;
	}

}
