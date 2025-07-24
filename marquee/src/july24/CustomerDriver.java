package july24;

import java.util.*;


public class CustomerDriver {
	
	public static void main(String[] args) {
		HashMap<Integer,Customer> map = new HashMap<>();
		Customer c1 = new Customer(1,"ABC",986769789,"abc@gmail.com","30-05-2005");
		Customer c2 = new Customer(2,"DEF",986689789,"def@gmail.com","20-04-1981");
		Customer c3 = new Customer(3,"XYZ",984169789,"xyz@gmail.com","16-12-1999");
		
		map.put(c1.id, c1);
		map.put(c2.id, c2);
		map.put(c3.id, c3);
		
		long s1 = System.nanoTime();
//		System.out.println(map.get(c3.id));
		map.get(c3.id);
		System.out.println("HM="+(System.nanoTime()-s1));
		
		ArrayList<Customer> list = new ArrayList<>(Arrays.asList(c1,c2,c3));
		long s2 = System.nanoTime();
//		System.out.println(list.contains(c3));
		list.contains(c3);
		System.out.println("AL="+(System.nanoTime()-s2));
		
		TreeSet<Customer> set = new TreeSet<>(Comparator.comparingInt(c -> c.id));
		set.addAll(list);
		long s3 = System.nanoTime();
//		System.out.println(set.contains(c3));
		set.contains(c3);
		System.out.println("TS="+(System.nanoTime()-s3));
	}
}
