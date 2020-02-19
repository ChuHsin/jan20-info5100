package class6;

public interface AppleStore { // 创建 AppleStore 接口

	public iPhone buyPhone(); // 接口方法

	public void returnPhone(iPhone phone); //接口方法

	public int getNumberOfPhones(); //接口方法

	public void addPhones(int numberOfPhones); // 接口方法

	public int getTotalSales(); //接口方法

	public default iPhone makePhone(int i) { // 在 interface 直接编写 implement 方法，Java8 新特性 ？？
		return iPhone.makePhone(i);
	}
}

class iPhone implements Comparable<iPhone> { 
	/**
	For any class to support natural ordering, 
	it should implement the Comparable interface and override it’s compareTo() method. 
	It must return a negative integer, zero, or a positive integer as this object is 
	less than, equal to, or greater than the specified object.
	https://howtodoinjava.com/java/collections/java-comparable-interface/
	*/
	float price; // initializing field
	String number;

	public static iPhone makePhone(int i) { // 创建 iPhone 类的方法
		iPhone p = new iPhone();
		p.price = 1099;
		p.number = i + "";
		return p;
	}

	public boolean equals(Object o) { // 重写 equals 方法用于比较这一类，供 hashMap 比较使用（hashMap) 要重写 equals and hashCode
		//hashMap 中的 key 值不能重复 先比较 hashCode 再看是否相等，都不同才能加入
		iPhone p = (iPhone) o;
		if (p.number.equals(this.number)) {
			return true;
		}
		return false;
	}

	public int hashCode() {
		return number.hashCode();
	}

	public String toString() { // 重写 toString
		return "[Number,Price]=[" + n umber + "," + price + "]";
	}

	@Override
	public int compareTo(iPhone o) { // 重写 compareTo 方法
		// return this.number.compareTo(o.number);
		return Integer.parseInt(number) - Integer.parseInt(o.number);
	}
}
