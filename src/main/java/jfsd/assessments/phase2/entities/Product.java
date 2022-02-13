package jfsd.assessments.phase2.entities;

public class Product {
	private int pid;
	private String pname;
	private float avgWeight;
	private float price;
	
	public Product() {
		
	}
	
	public Product(int pid, String pname, float avgWeight, float price) {
		this.pid = pid;
		this.pname = pname;
		this.avgWeight = avgWeight;
		this.price = price;
	}

	public String getPname() {
		return pname;
	}

	public void setPname(String pname) {
		this.pname = pname;
	}

	public double getAvgWeight() {
		return avgWeight;
	}

	public void setAvgWeight(float avgWeight) {
		this.avgWeight = avgWeight;
	}

	public double getPrice() {
		return price;
	}

	public void setPrice(float price) {
		this.price = price;
	}

	public int getPid() {
		return pid;
	}

	@Override
	public String toString() {
		return "Product [pid=" + pid + ", pname=" + pname + ", avgWeight=" + avgWeight + ", price=" + price + "]";
	}
}
