package class8;
// 描述基本动作， loop, loop with random exception
public class BaseObject {

	public void loop(String message) {
		loop(message, 100);
	}

	public void pause(int ms) {
		try {
			Thread.sleep(ms);
		} catch (Exception e) {
		}
	}

	public void loop(String message, int pauseDuration) {
		for (int i = 0; i < 10; i++) {
			System.out.println(message + " -> " + i);
			pause(pauseDuration);
		}
	}

	public void loopWithRandomException(String message, int pauseDuration) {
		for (int i = 0; i < 10; i++) {
			System.out.println(message + " -> " + i);
			int x = getRandomNumber(10);
			if (x < 2) {
				throw new RuntimeException("Problem in " + message + " -> " + x);
			}
			pause(pauseDuration);
		}
	}

	public int getRandomNumber(int x) {
		return (int) (Math.random() * x);
	}
}
