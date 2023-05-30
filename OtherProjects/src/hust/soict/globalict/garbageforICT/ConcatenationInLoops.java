package hust.soict.globalict.garbageforICT;
import java.util.Random;

public class ConcatenationInLoops {
	public static void main(String args[]) {
		Random r = new Random(123);
		long start = System.currentTimeMillis();
		String s = "";
		for (int i = 0; i < 65536; i++)
			s += r.nextInt(2);
		System.out.println(System.currentTimeMillis() - start); // This is roughly 4500.
		
		r = new Random(123);
		start = System.currentTimeMillis();
		StringBuilder sb = new StringBuilder();
		for (int i = 0; i < 65536; i++) 
			sb.append(r.nextInt(2));
		s = sb.toString();
		System.out.println(System.currentTimeMillis() - start); // This print s
	}
}

/*
String filename = "test.exe";
byte[] inputBytes = {0};
long startTime, endTime;

inputBytes = Files.readAllBytes(Paths.get(filename));
startTime = System.currentTimeMills();
String outputString = "";
for (byte b: inputBytes) {
	outputString += (char)b;
}
endTime = System.currentTimeMills();
System.out.println(endTime - startTime);

Change the code in line 14-17 above to use StringBuffer instead of “+” operator to build string and observe result

StringBuilder outputStringBuilder = new StringBuilder();
for(byte b: inputBytes) {
	outputStringBuilder.append((char)b);
}
*/
