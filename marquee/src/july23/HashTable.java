package july23;
import java.util.Hashtable;

public class HashTable {
	public static void main(String[] args) {
		Hashtable tb = new Hashtable();
		tb.put(1,"hello");
		tb.put(2,55);
		tb.put(3,"hello");
		tb.put(4, 'G');
		tb.put(5, 80.0f);
		tb.put(11, 10);
		Hashtable ht1 = new Hashtable();
		ht1.putAll(tb);
		ht1.remove(4);
		ht1.replace(5, 80.0f,90.0f);
		System.out.println(ht1.get(1));
		System.out.println(tb);
		System.out.println(ht1);
	}
}
