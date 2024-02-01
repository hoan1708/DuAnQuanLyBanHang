package vn.edu.devpro.baitapcuoikhoa.quanlyshopthoitrang.capnhat.customer;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.Scanner;

import vn.edu.devpro.baitapcuoikhoa.quanlyshopthoitrang.capnhat.product.ManagerProduct;
import vn.edu.devpro.baitapcuoikhoa.quanlyshopthoitrang.quanlybanhang.thongke.QuanLyDSGioHang;


public class ManagerCustomer {
	static Scanner sc = new Scanner(System.in);

	private static ArrayList<Customer> ds_khachHang = new ArrayList<Customer>();

	public static ArrayList<Customer> getDs_khachHang() {
		return ds_khachHang;
	}

	public static int autoID = 10;

	public static void setDs_khachHang(ArrayList<Customer> ds_khachHang) {
		ManagerCustomer.ds_khachHang = ds_khachHang;
	}

	public static void init() {
		ds_khachHang.add(new Customer(autoID++, "Nguyen Van Truong", "0987654321"));
		ds_khachHang.add(new Customer(autoID++, "Tran Trung Quang", "0987654999"));
		ds_khachHang.add(new Customer(autoID++, "Trung Van Kien", "0987654765"));
		ds_khachHang.add(new Customer(autoID++, "Manh Van Son", "0987654231"));

	}

	public static void capNhatKhachHang() {
		do {
			System.out.println("\n\n-------- CAP NHAT THONG TIN KHACH HANG -------- ");
			System.out.println("Chon thong tin cap nhat ");
			System.out.println("\t1. Xem danh sach khach hang ");
			System.out.println("\t2. Them khach hang moi");
			System.out.println("\t3. Sua thong tin khach hang");
			System.out.println("\t4. Xoa thong tin khach hang");
			System.out.println("\t5. Sap xep danh sach khach hang theo ten khach hang");
			System.out.println("\t0. Quay lai");
			System.out.print("\t>>> Lua chon cua ban: ");
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
				System.out.println(" Sap xep danh sach khach hang theo ten khach hang thanh cong");
				break;
			case 0:
				return;
			default:
				System.out.println("Lua chon khong hop le ..");
			}

		} while (true);
	}

	private static void sort() {
		Collections.sort(ds_khachHang, new Comparator<Customer>() {
			@Override
			public int compare(Customer o1, Customer o2) {
				String name1 = o1.getName().substring(o1.getName().lastIndexOf(" "),o1.getName().length()-1);
				String name2 = o2.getName().substring(o2.getName().lastIndexOf(" "),o2.getName().length()-1);
				
				return name1.compareTo(name2);
			}
		});
	}

	private static void remove() {
		System.out.println("\n----------XOA THONG TIN KHACH HANG----------");
		System.out.print("Nhap id cua khach hang tu 10 - " + (autoID-1) + " muon xoa: ");
		int id = Integer.parseInt(sc.nextLine());

		int index = getIDByFind(id);
		if (index == -1) {
			System.out.println("Khach hang khong co trong danh sach");
			return;
		}
		// Kiem tra rang buoc lien ket voi Cart - sau khi tao xong Class manager Cart
		if(QuanLyDSGioHang.findByIdCustomer(id)!=-1) {
			System.out.println("Khach hang dang duoc su dung trong gio hang, nen khong the xoa");
			return;
		}
		
		ds_khachHang.remove(index);
		System.out.println("Xoa khach hang thanh cong!");
	}

	private static void update() {
		System.out.println("\n\n----------SUA THONG TIN KHACH HANG ----------");
		System.out.print("Nhap id cua khach hang tu 10 - " + (autoID-1) + " muon sua: ");
		int id = Integer.parseInt(sc.nextLine());

		int index = getIDByFind(id);
		if (index == -1) {
			System.out.println("Khach hang khong co trong danh sach");
			return;
		}

		do {
			System.out.println("\n\n\tSua thong tin khach hang: " + id);
			System.out.println("\tChon thong tin can sua");
			System.out.println("\t1. Sua ten khach hang");
			System.out.println("\t2. Sua so dien thoai khach hang");
			System.out.println("\t0. Quay lai");

			System.out.print("\t>>> Lua chon cua ban: ");
			int chon = Integer.parseInt(sc.nextLine());

			System.out.println("");
			switch (chon) {
			case 1:
				ds_khachHang.get(index).updateTenKh();
				break;
			case 2:
				ds_khachHang.get(index).updateSDT();
				break;
			case 0:
				return;
			default:
				System.out.println("Lua chon khong hop le");
			}
		} while (true);
	}

	private static void add() {
		System.out.println("Them moi 1 nha khach hang");
		
		// nhap ten khach hang
		System.out.print("Nhap ten khach hang: ");
		String name = sc.nextLine();

		if (name.equals("")) {
			System.out.println("Khong duoc de trong ten khach hang");
			return;
		}

		// nhap sdt khach hang
		System.out.print("Nhap so dien thoai: ");
		String sdt = sc.nextLine();

		if (sdt.equals("")) {
			System.out.println("Khong duoc de trong so dien thoai");
			return;
		}

		ds_khachHang.add(new Customer(autoID++, name, sdt));
		System.out.println("Them moi khach hang thanh cong ^^ ");
	}

	private static void display() {
		System.out.println("================= HIEN THI THONG TIN KHACH HANG =====================");
		System.out.printf("%-2s %-20s %-12s%n","ID","Ho va ten","SDT");
		for (Customer kh : ds_khachHang) {
			kh.hienThi();
		}
	}

	// cac ham ho tro
	public static Boolean checkTrung(String name) {
		for (Customer kh : ds_khachHang) {
			if (kh.getName().trim().equalsIgnoreCase(name.trim())) {
				return true;
			}
		}
		return false;
	}

	// lay ra id
	public static int getIDByFind(int id) {
		for (int i = 0; i < ds_khachHang.size(); i++) {
			if (ds_khachHang.get(i).getId() == id) {
				return i;
			}
		}
		return -1;
	}

	
	//+ Lay ten khach hang theo id
	public static String getNameById(int id) {
		for (Customer x : ds_khachHang) {
			if (x.getId() == id) {
				return x.getName();
			}
		}
		return null;
	}
	
	public static int findById(int id) {
		for (int index = 0; index < ds_khachHang.size(); index++) {
			if (ds_khachHang.get(index).getId() == id) {
				return index;
			}
		}
		return -1;
	}
	
	public static int findByName(String name) {
		for (int index = 0; index < ds_khachHang.size(); index++) {
			if (ds_khachHang.get(index).getName().trim().equalsIgnoreCase(name.trim())) {
				return index;
			}
		}
		return -1;
	}
}
