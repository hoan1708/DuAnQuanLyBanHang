package vn.edu.devpro.baitapcuoikhoa.quanlyshopthoitrang.capnhat.provider;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.Scanner;

import vn.edu.devpro.baitapcuoikhoa.quanlyshopthoitrang.capnhat.product.ManagerProduct;

public class ManagerProvider {
	static Scanner sc = new Scanner(System.in);

	private static ArrayList<Provider> dsNhaCungCap = new ArrayList<Provider>();

	public static ArrayList<Provider> getDsNhaCungCap() {
		return dsNhaCungCap;
	}

	public static void setDsNhaCungCap(ArrayList<Provider> dsNhaCungCap) {
		ManagerProvider.dsNhaCungCap = dsNhaCungCap;
	}


	public static int autoID = 200;

	public static void init() {
		dsNhaCungCap.add(new Provider(autoID++, "NCC sao mai", "123 Mai Dich"));
		dsNhaCungCap.add(new Provider(autoID++, "NCC Tuan Hung", "13 Ho Tung Mau"));
		dsNhaCungCap.add(new Provider(autoID++, "NCC Ngoc Lan", "10 Cau Dien"));
		dsNhaCungCap.add(new Provider(autoID++, "NCC Tien Quang", "73 My Dinh"));
	}

	public static void capNhatNhaCungCap() {
		do {
			System.out.println("\n\n-------- CAP NHAT THONG TIN NHA CUNG CAP -------- ");
			System.out.println("Chon thong tin cap nhat ");
			System.out.println("\t1. Xem danh sach nha cung cap ");
			System.out.println("\t2. Them nha cung cap moi");
			System.out.println("\t3. Sua thong tin nha cung cap");
			System.out.println("\t4. Xoa thong tin nha cung cap");
			System.out.println("\t5. Sap xep danh sach nha cung cap theo ten nha cung cap");
			System.out.println("\t0. Quay lai");
			System.out.print("\n\t>>> Lua chon cua ban: ");
			int chon = Integer.parseInt(sc.nextLine());

			System.out.println("\n");

			switch (chon) {
			case 1:
				display();
				break;
			case 2:
				add();
				break;
			case 3:
				update();
				break;
			case 4:
				remove();
				break;
			case 5:
				sort();
				System.out.println("Sap xep danh sach nha cung cap theo ten nha cung cap thanh cong");
				break;
			case 0:
				return;
			default:
				System.out.println("Lua chon khong hop le ..");
			}

		} while (true);
	}

	private static void sort() {
		Collections.sort(dsNhaCungCap, new Comparator<Provider>() {
			@Override
			public int compare(Provider o1, Provider o2) {
				return o1.getName().compareTo(o2.getName());
			}
		});
	}

	private static void remove() {
		System.out.println("Xoa 1 nha cung cap\n");
		System.out.print("Nhap id nha cung cap tu 200 - " + (autoID-1) + " muon xoa: ");
		
		int id = Integer.parseInt(sc.nextLine());

		int index = getIDByFind(id);
		if (index == -1) {
			System.out.println("ID khong ton tai trong danh sach !!!");
			return;
		}

		// check rang buoc voi bang Product
		if(ManagerProduct.findByIDProvider(id)!=-1) {
			System.out.println("Ma nha cung cap dang duoc su dung cho San pham, nen khong the xoa");
			return;
		}

		dsNhaCungCap.remove(index);
		System.out.println("Xoa nha cung cap thanh cong ");

	}

	private static void update() {
		System.out.println("\n----------SUA THONG TIN NHA CUNG CAP ----------");
		System.out.print("Nhap id nha cung cap tu 200 - " + (autoID-1) + " muon sua: ");
		int id = Integer.parseInt(sc.nextLine());

		int index = getIDByFind(id);
		if (index == -1) {
			System.out.println("Nha cung cap khong co trong danh sach");
			return;
		}

		do {
			System.out.println("\n\tSua thong tin nha cung cap: " + id);
			System.out.println("\tChon thong tin can sua");
			System.out.println("\t1. Sua ten nha cung cap");
			System.out.println("\t2. Sua dia chi nha cung cap");
			System.out.println("\t0. Quay lai");

			System.out.print("\t>>> Lua chon cua ban: ");
			int chon = Integer.parseInt(sc.nextLine());

			switch (chon) {
			case 1:
				dsNhaCungCap.get(index).updateTenNCC();
				break;
			case 2:
				dsNhaCungCap.get(index).updateAddress();
				break;
			case 0:
				return;
			default:
				System.out.println("Lua chon khong hop le");
			}
		} while (true);
	}

	private static void add() {
		System.out.println("Them moi 1 nha cung cap\n");
		
		// nhap ten nha cung cap 
		System.out.print(">> Nhap ten nha cung cap: ");
		String name = sc.nextLine();

		if (name.equals("")) {
			System.out.println("Khong duoc de trong ten nha cung cap");
			return;
		}

		// nhap dia chi nha cung cap 
		System.out.print(">> Nhap dia chi nha cung cap: ");
		String address = sc.nextLine();

		if (address.equals("")) {
			System.out.println("Khong duoc de trong dia chi nha cung cap");
			return;
		}

		dsNhaCungCap.add(new Provider(autoID++, name, address));
		System.out.println("\nThem moi nha cung cap thanh cong ");
	}

	private static void display() {
		System.out.println("================= HIEN THI DANH SACH NHA CUNG CAP =====================");
		System.out.printf("%-3s %-20s %-20s %n","ID","Ten nha cung cap", "Dia chi");
		for (Provider x : dsNhaCungCap) {
			x.display();
		}
	}

	// lay ra id
	public static int getIDByFind(int id) {
		for (int i = 0; i < dsNhaCungCap.size(); i++) {
			if (dsNhaCungCap.get(i).getId() == id) {
				return i;
			}
		}
		return -1;
	}

	public static String getNameById(int id) {
		for (Provider x : dsNhaCungCap) {
			if (x.getId() == id) {
				return x.getName();
			}
		}
		return null;
	}
	
	
	public static int findByName(String name) {
		for (int index = 0; index < dsNhaCungCap.size(); index++) {
			if (dsNhaCungCap.get(index).getName().trim().equalsIgnoreCase(name.trim())) {
				return index;
			}
		}
		return -1;
	}
}
