package july23;

import java.util.TreeSet;

public class treeset {
	public static void main(String[] args) {
		TreeSet<Integer> set = new TreeSet<>();
		set.add(10);
		set.add(4);
		set.add(16);
		set.add(13);
		set.add(11);
		
		for(Object val:set.reversed()) {
			System.out.print(val+" ");
		}
		System.out.println();
		System.out.println(set);
	}
}
