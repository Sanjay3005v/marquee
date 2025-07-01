package july1;

public class generics {
	public static void main(String[] args) {
		Demo<String> d = new Demo<>("Hello");
		System.out.println(d.getValue());
	}
}

class Demo<T> {
	T value;

	Demo(T value) {
		this.value = value;
	}

	public T getValue() {
		return value;
	}

	public void setValue(T value) {
		this.value = value;
	}
}
