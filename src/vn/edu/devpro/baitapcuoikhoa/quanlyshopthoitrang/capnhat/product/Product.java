package vn.edu.devpro.baitapcuoikhoa.quanlyshopthoitrang.capnhat.product;

import java.util.Scanner;

import vn.edu.devpro.baitapcuoikhoa.quanlyshopthoitrang.capnhat.provider.ManagerProvider;
import vn.edu.devpro.baitapcuoikhoa.quanlyshopthoitrang.capnhat.typeofproduct.ManagerType;


public class Product {
	static Scanner sc = new Scanner(System.in);
	private int idSP;
	private int idLoaiSP;
	private int idNhaCungCap;
	private String nameSP;
	private double amount;
	private double price;
	
	public void display() {
		System.out.printf("%5d  %7d  %6d %-30s %8.1f %,15.1f %n"
				, this.idSP, this.idLoaiSP, this.idNhaCungCap, this.nameSP, this.amount, this.price);
	}
	
	public Product() {
		// TODO Auto-generated constructor stub
	}

	

	public Product(int idSP, int idLoaiSP, int idNhaCungCap, String nameSP, double amount, double price) {
		super();
		this.idSP = idSP;
		this.idLoaiSP = idLoaiSP;
		this.idNhaCungCap = idNhaCungCap;
		this.nameSP = nameSP;
		this.amount = amount;
		this.price = price;
	}

	public int getIdSP() {
		return idSP;
	}

	public void setIdSP(int idSP) {
		this.idSP = idSP;
	}

	public int getIdLoaiSP() {
		return idLoaiSP;
	}

	public void setIdLoaiSP(int idLoaiSP) {
		this.idLoaiSP = idLoaiSP;
	}

	public int getIdNhaCungCap() {
		return idNhaCungCap;
	}

	public void setIdNhaCungCap(int idNhaCungCap) {
		this.idNhaCungCap = idNhaCungCap;
	}

	public String getNameSP() {
		return nameSP;
	}

	public void setNameSP(String nameSP) {
		this.nameSP = nameSP;
	}

	public Double getAmount() {
		return amount;
	}

	public void setAmount(Double amount) {
		this.amount = amount;
	}

	public Double getPrice() {
		return price;
	}

	public void setPrice(Double price) {
		this.price = price;
	}

	public void updateLoaiSanPham() {
		System.out.print("Nhap id loai san pham moi muon sua tu 100 tro di: ");
		int id = Integer.parseInt(sc.nextLine());
		if (ManagerType.getIDByFind(id) == -1) {
			System.out.println("Loai san pham vua chon khong co trong ds loai san pham");
			return;
		}
		this.setIdLoaiSP(id);
		System.out.println("Sua ID loai hang thanh cong");
	}

	public void updateNhaCungCap() {
		System.out.print(">> Nhap id nha cung cap moi muon sua tu 200 tro di: ");
		int id = Integer.parseInt(sc.nextLine());
		if (ManagerProvider.getIDByFind(id) == -1) {
			System.out.println("ID nha cung cap vua nhap khong co trong ds loai san pham");
			return;
		}
		this.setIdLoaiSP(id);
		System.out.println("\nSua ID nha cung cap thanh cong");
	}

	public void updateTenSanPham() {
		System.out.print(">> Nhap ten san pham moi: ");
		String name = sc.nextLine();
		
		if (name.trim().length() == 0) {
			System.out.println("Ten san pham khong duoc de trong");
			return;
		}
		if (ManagerProduct.checkTrung(name)) {
			System.out.println("Ten san pham nay da co trong danh sach");
			return;
		}
		this.setNameSP(name);
		System.out.println("\nSua ten san pham thanh cong!");
	}

	public void updateSoLuongSanPham() {
		System.out.print(">> Nhap so luong san pham: ");
		double amount = Double.parseDouble(sc.nextLine());
		
		if (amount < 0) {
			System.out.println("So luong khong duoc la so am");
			return;
		}
		this.setAmount(amount);
		System.out.println("\nSua so luong san pham thanh cong!");
	}

	public void updateGiaSanPham() {
		System.out.print(">> Nhap don gia ban san pham: ");
		double price = Double.parseDouble(sc.nextLine());
		
		if (price < 0) {
			System.out.println("Don gia ban khong duoc la so am");
			return;
		}
		this.setPrice(price);
		System.out.println("\nSua don gia ban san pham thanh cong!");
	}
	
	
	
}
