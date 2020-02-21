package class5;

import java.text.NumberFormat; // 
import java.text.SimpleDateFormat; // 

public class Professor {
// throw 一般用于程序出现“某种逻辑”（if判断）时，程序员主动抛出某种特定类型的异常
// throws 方法可能抛出的异常的声明，当某个方法可能会抛出某种异常时用 throws 声明可能抛出的异常，然后交给上层调用它的方法程序处理
// Exception 是所有异常类的父类， catch 必须抓住 Exception 的子类
// finally 表示不管异常是否发生，都得进行 finally {} 中的处理
// 某个函数或某段程序块不管会不会，有没有可能抛出异常，都可以加 try{...} catch{ ...} 去捕捉它；
// 自定义异常：新建一个异常类，让其继承 Exception 类 或 Exception 的某个子类， 然后用 throws 抛出自己定义的异常类对象
	public static void main(String args[]) throws ProjectorException {
		Professor siva = new Professor();
		// try catch, 
		try { 
			System.out.println("Before writing code");
			siva.writeCode(); //可能会抛出 Battery 和 Projector
			System.out.println("After writing code");
		} catch (ProjectorException pe) { // 如果 catch 到 Projector， 运行以下代码
			System.out.println("******ProjectorException***** Siva is trying other options to write code..");
		} catch (BatteryLowException be) { // 如果 catch 到 Battery， 运行以下代码
			System.out.println("****BatteryLowException****** Please connect power cable");
		} catch (RuntimeException e) { // 如果 catch 到 其他 RuntimeException 类的 exception， 进行以下流程
			String message = e.getMessage(); // 获取这个 Exception 的 Message
			if (message.contains("Battery")) { // 如果这个 message 中含有 “Battery”
				System.out.println("Please connect power cable"); // Battery 相关内容
			} else {
				System.out.println("Siva is trying other options to write code.."); // 否则尝试其他方法
			}
		} finally {
			System.out.println("I will get executed irrespective of having an exception or not..");
			// 不管是否 catch 到任何 Exception， 最后都会进行这一步
		}

		System.out.println("Finally Done..");
	}

	public void writeCode() throws ProjectorException, BatteryLowException { // a method can throw more than one exception
		// 这个 method 可能会抛出 ProjectorException 和 BatteryLowException
		openLaptop();
		openLaptop();
		connectProjectorCableToLaptop();
		turnOnTheProjector();
		makeScreenVisible();
		try {
			// makeScreenVisible(); // 运行这一段代码，当发生 Exception e 时捕捉到，并运行 catch 中的代码
		} catch (Exception e) {
			System.out.println("*****Screen Exception --- Pull the screen manually with your hand");
		}
		typeOnLaptop();
		projectorEmitTextOnScreen();

	}

	private void projectorEmitTextOnScreen() {
		System.out.println("Project emits text on to screen");
	}

	private void typeOnLaptop() {
		System.out.println("Type some code on laptop");

	}

	private void makeScreenVisible() throws RuntimeException { // 声明这个 method 可能会抛出 RuntimeException 并交由调用它的method 来
		int x = Util.getRandomNumber(10);
		if (x < 9) {
			throw new RuntimeException(); // if x < 9, throw the RuntimeException
		}
		System.out.println("Make Screen visible");

	}

	private void turnOnTheProjector() throws ProjectorException { // 声明该 method 可能抛出 ProjectorException 类 异常
		System.out.println("Turn on projector");
		int x = Util.getRandomNumber(10);
		System.out.println("Random number -> " + x);
		if (x < 1) {
			// RuntimeException exception = new RuntimeException();
			ProjectorException exception = new ProjectorException(); // 自定义 异常
			throw exception; // 抛出 自定义异常 exception
		} else {
			System.out.println("Projector confirms that content from laptop is shown on screen");
		}

	}

	private void connectProjectorCableToLaptop() {
		System.out.println("Connect Projector cable to Laptop");
	}

	private void openLaptop() throws BatteryLowException { // 声明该 method 可能抛出 BatteryLowException
		System.out.println("Open Laptop");
		System.out.println("Checking the battery");
		int x = Util.getRandomNumber(10);
		System.out.println("Battery random -> " + x);
		if (x < 1) {
			// throw new RuntimeException("Battery is low");
			throw new BatteryLowException(); // 当 x<1 实现时， 抛出 BatteryLowException
		} else {
			System.out.println("Battery is sufficient..");
		}

	}

}

class BatteryLowException extends RuntimeException { // 声明 自定义 Exception，它需要继承 Exception类 或者它的子类

}

class ProjectorException extends Exception { // 声明 自定义 Exception，它需要继承 Exception类 或者它的子类
}

class Util {
	public static int getRandomNumber(int x) {
		return (int) (Math.random() * x);
	}

}

//throw an Exception
//catch an exception
//Use try{} catch block to handle exceptions
//Throw a specific type of exception by extending RuntimeException
//Expand the method signature to have throws xxxException in it
