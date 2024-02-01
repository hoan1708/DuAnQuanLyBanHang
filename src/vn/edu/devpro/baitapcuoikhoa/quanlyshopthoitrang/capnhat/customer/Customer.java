package vn.edu.devpro.baitapcuoikhoa.quanlyshopthoitrang.capnhat.customer;

import java.util.Scanner;

public class Customer {
	static Scanner sc = new Scanner(System.in);

	private int id;
	private String name;
	private String phone;

	public void hienThi() {
		System.out.printf("%2d %-20s %-12s%n", this.id, this.name, this.phone);
	}

	public Customer() {
		// TODO Auto-generated constructor stub
	}
	

	public Customer(int id, String name, String phone) {
		super();
		this.id = id;
		this.name = name;
		this.phone = phone;
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

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}
	

	public void updateTenKh() {
		System.out.print(">> Nhap ten khach hang moi: ");
		String name = sc.nextLine();

		if (name.equals("")) {
			System.out.println("Ten khach hang khong duoc de trong");
			return;
		}

		this.setName(name);
		System.out.println("\nSua ten khach hang thanh cong ");
	}

	public void updateSDT() {
		System.out.print(">> Nhap so dien thoai moi: ");
		String sdt = sc.nextLine();

		if (sdt.equals("")) {
			System.out.println("So dien thoai khong duoc de trong");
			return;
		}

		this.setPhone(sdt);
		System.out.println("\nSua so dien thoai thanh cong ");
	}

}
