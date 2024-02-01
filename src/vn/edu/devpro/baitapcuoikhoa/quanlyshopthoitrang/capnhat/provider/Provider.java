package vn.edu.devpro.baitapcuoikhoa.quanlyshopthoitrang.capnhat.provider;

import java.util.Scanner;

public class Provider {
	static Scanner sc = new Scanner(System.in);

	private int id;
	private String name;
	private String address;
	
	public Provider() {
		// TODO Auto-generated constructor stub
	}

	public void display() {
		System.out.printf("%3d %-20s %-20s %n", this.id, this.name, this.address);
	}

	public Provider(int id, String name, String address) {
		super();
		this.id = id;
		this.name = name;
		this.address = address;
	}

	

	public int getId() {
		return id;
	}



	public void setId(int id) {
		this.id = id;
	}



	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public void updateTenNCC() {
		System.out.print("\n\t>>> Nhap ten nha cung cap moi: ");
		String name = sc.nextLine();
		
		if (name.trim().length() == 0) {
			System.out.println("Ten nha cung cap khong duoc de trong");
			return;
		}
		
		this.setName(name);
		System.out.println("Sua ten nha cung cap thanh cong\n\n");
	}



	public void updateAddress() {
		System.out.print("\n\t>>> Nhap dia chi nha cung cap moi: ");
		String address = sc.nextLine();
		
		if (name.trim().length() == 0) {
			System.out.println("Dia chi nha cung cap khong duoc de trong");
			return;
		}
		
		this.setAddress(address);
		System.out.println("Sua dia chi nha cung cap thanh cong");
	}
	
	
	
}
