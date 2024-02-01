package vn.edu.devpro.baitapcuoikhoa.quanlyshopthoitrang.capnhat.typeofproduct;

import java.util.Scanner;

public class Type {
	static Scanner sc = new Scanner(System.in);
	private int id;
	private String name;
	private String description;
	
	public Type() {
		// TODO Auto-generated constructor stub
	}
	
	public void display() {
		System.out.printf("%10d %-20s %-30s %n", this.id, this.name, this.description);
	}

	public Type(int id, String name, String description) {
		super();
		this.id = id;
		this.name = name;
		this.description = description;
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

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public void updateTenLoai() {
		System.out.print("\nNhap ten loai san pham muon sua: ");
		String name = sc.nextLine();
		
		if(name.isBlank()) {
			System.out.println("Khong duoc de trong ten loai san pham");
			return;
		}
		
		if(ManagerType.checkTrung(name)) {
			System.out.println("Ten loai san pham da co trong danh sach");
			return;
		}
		
		this.setName(name);
		System.out.println("Cap nhat ten loai thanh cong");
	}

	public void updateMoTa() {
		System.out.print("\nNhap mo ta loai san pham muon sua: ");
		String moTa = sc.nextLine();
		
		if(moTa.isBlank()) {
			System.out.println("Khong duoc de trong mo ta loai san pham");
			return;
		}
		
		this.setName(moTa);
		System.out.println("Cap nhat mo ta ten loai thanh cong");
	}
	
	
}
