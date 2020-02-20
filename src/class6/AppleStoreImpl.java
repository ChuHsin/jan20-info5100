package class6;

public class AppleStoreImpl implements AppleStore {

	private iPhone[] phones = new iPhone[3]; // 创建指定大小 3 的 array
	private float saleAmount = 0; // 初始化 saleAmount 0

	AppleStoreImpl() {
		init(); // 构造方法
	}

	private void init() {
		for (int i = 0; i < phones.length; i++) {
			iPhone p = makePhone(i);
			phones[i] = p;
		}
// 创造phones长度个数个 phone, 并把它们保存在 array 定义的 index 上
	}

	@Override
	public iPhone buyPhone() {
		for (int i = 0; i < phones.length; i++) {
			iPhone p = phones[i];
			if (p != null) {
				saleAmount += p.price; // saleAmount = p.price + saleAmount
				phones[i] = null;
				return p;
			}
		}
		return null;
	}

	@Override
	public void returnPhone(iPhone phone) {
		for (int i = 0; i < phones.length; i++) {
			iPhone p = phones[i];
			if (p == null) {
				phones[i] = phone;
				saleAmount -= phone.price;
				return;
			}
		}
		expandPhoneArray(1);
		phones[phones.length - 1] = phone;
		saleAmount -= phone.price;
	}

	private void expandPhoneArray(int i) {
		int newSize = phones.length + i;
		iPhone x[] = new iPhone[newSize];
		for (int j = 0; j < phones.length; j++) {
			x[j] = phones[j];
		}
		phones = x;

	}

	@Override
	public int getNumberOfPhones() {
		int n = 0;
		for (iPhone p : phones) {
			if (p != null)
				n++;
		}
		return n;
	}

	@Override
	public void addPhones(int numberOfPhones) {
		int size = phones.length;
		expandPhoneArray(numberOfPhones);
		for (int i = size; i < size + numberOfPhones; i++) {
			phones[i] = makePhone(i);
		}

	}

	@Override
	public int getTotalSales() {
		return (int) saleAmount;
	}

}
