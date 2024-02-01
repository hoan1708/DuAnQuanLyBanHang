package vn.edu.devpro.baitapcuoikhoa.quanlyshopthoitrang.quanlybanhang.customerbuy;

import vn.edu.devpro.baitapcuoikhoa.quanlyshopthoitrang.capnhat.product.ManagerProduct;
import vn.edu.devpro.baitapcuoikhoa.quanlyshopthoitrang.capnhat.product.Product;

public class Hang {
	private int idh;
	private double amount;
	
	public void display() {  // %30s %10s %10s %15s
		Product x = ManagerProduct.getHangHoaByID(this.idh);
		System.out.printf("%-30s %,10.1f %,15.2f %,15.2f %n",
				x.getNameSP(), this.amount, x.getPrice(), 
				this.amount * x.getPrice());
	}
	
	public double thanhTien() {
		Product x = ManagerProduct.getHangHoaByID(this.idh);
		return this.amount * x.getPrice();
	}
	
	public Hang() {
		super();
	}
	public Hang(int idh, double amount) {
		super();
		this.idh = idh;
		this.amount = amount;
	}
	public int getIdh() {
		return idh;
	}
	public void setIdh(int idh) {
		this.idh = idh;
	}
	public double getAmount() {
		return amount;
	}
	public void setAmount(double amount) {
		this.amount = amount;
	}
}
