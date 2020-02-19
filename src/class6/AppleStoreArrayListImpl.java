package class6;

import java.util.ArrayList;
// 使用 ArrayList 实现 AppleStore Interface
public class AppleStoreArrayListImpl implements AppleStore {

	private ArrayList<iPhone> phones = new ArrayList<iPhone>(); // 创建 iPhone 对象的 ArrayList
	private int totalSales = 0;

	AppleStoreArrayListImpl() {
		for (int i = 0; i < 3; i++) {
			phones.add(makePhone(i));
		} // constructor 默认有3个 iPhone
	}

	@Override
	public iPhone buyPhone() { // 重写 AppleStore interface 下的 buyPhone() method
		if (phones.size() == 0)
			return null;
		iPhone p = phones.remove(0);
		totalSales += p.price;
		return p;
	}

	@Override
	public void returnPhone(iPhone phone) { // 重写 AppleStore interface 下的 return() method
		totalSales -= phone.price;
		phones.add(phone);

	}

	@Override
	public int getNumberOfPhones() { // 重写 AppleStore interface 下的 getNumberOfPhones() method
		return phones.size();
	}

	@Override
	public void addPhones(int numberOfPhones) { // 重写 AppleStore interface 下的 addPhones() method
		for (int i = 0; i < numberOfPhones; i++) {
			phones.add(makePhone(i));
		}

	}

	@Override
	public int getTotalSales() { // 重写 AppleStore interface 下的 getTotalSales() method
		return totalSales;
	}

	public String toString() { // 重写 java.lang.Object 下的 toString() mehtod
		return phones.toString();
	}

}
