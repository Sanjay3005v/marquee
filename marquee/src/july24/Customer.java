package july24;

public class Customer {
	int id;
	String name;
	long contact;
	String email;
	String dob;
	public Customer(int id, String name, long contact, String email, String dob) {
		
		this.id = id;
		this.name = name;
		this.contact = contact;
		this.email = email;
		this.dob = dob;
	}
	@Override
	public boolean equals(Object obj) {
		// TODO Auto-generated method stub
		Customer c = (Customer)obj;
		return c.email.equals(email)&&c.contact==contact;
	}
	
	@Override
	public String toString() {
		// TODO Auto-generated method stub
		return this.id+" "+this.name+" "+this.contact+" "+this.email+" "+this.dob;
	}
	
}
