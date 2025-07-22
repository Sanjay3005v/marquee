package july22;

public class VariableArgumentMethod {
	public static void main(String... args) {
		sum(new int[] {1,2,3});
		sum(1,2,3,4);
	}
	public static void sum(int... vals) {
		var sum=0;
		for(int num:vals) {
			sum+=num;
		}
		System.out.println(sum);
	}
}
