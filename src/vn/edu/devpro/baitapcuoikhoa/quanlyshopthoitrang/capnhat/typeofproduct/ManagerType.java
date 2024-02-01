package vn.edu.devpro.baitapcuoikhoa.quanlyshopthoitrang.capnhat.typeofproduct;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.Scanner;

import vn.edu.devpro.baitapcuoikhoa.quanlyshopthoitrang.capnhat.product.ManagerProduct;
import vn.edu.devpro.baitapcuoikhoa.quanlyshopthoitrang.capnhat.provider.Provider;

public class ManagerType {
	static Scanner sc = new Scanner(System.in);

	private static ArrayList<Type> ds_type = new ArrayList<Type>();

	private static int autoID = 100;

	public static void init() {
		ds_type.add(new Type(autoID++, "Ao coc tay", "Ao ngan tay"));
		ds_type.add(new Type(autoID++, "Quan dai", "Quan dai cac mau sac"));
		ds_type.add(new Type(autoID++, "Ao so mi", "Dai tay, co co"));
	}
	public static ArrayList<Type> getDs_type() {
		return ds_type;
	}

	public static void setDs_type(ArrayList<Type> ds_type) {
		ManagerType.ds_type = ds_type;
	}

	public static void capNhatChungLoai() {
		do {
			System.out.println("\n\n\n-------- CAP NHAT THONG TIN LOAI SAN PHAM -------- ");
			System.out.println("Chon thong tin cap nhat ");
			System.out.println("\t1. Xem danh sach loai san pham ");
			System.out.println("\t2. Them loai san pham moi");
			System.out.println("\t3. Sua thong tin loai san pham");
			System.out.println("\t4. Xoa thong tin loai san pham");
			System.out.println("\t5. Sap xep danh sach loai san pham theo ten loai san pham");
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
				System.out.println("Sap xep danh sach loai san pham theo ten loai san pham thanh cong");
				
				break;
			case 0:
				return;
			default:
				System.out.println("Lua chon khong hop le ..");
			}

		} while (true);
	}

	private static void sort() {
		Collections.sort(ds_type, new Comparator<Type>() {
			@Override
			public int compare(Type o1, Type o2) {
				return o1.getName().compareTo(o2.getName());
			}
		});
	}

	private static void remove() {
		System.out.println("Xoa 1 loai san pham\n");
		System.out.print(">> Nhap id loai san pham tu 100 - " + (autoID-1) + " muon xoa: ");
		int id = Integer.parseInt(sc.nextLine());

		int index = getIDByFind(id);
		if (index == -1) {
			System.out.println("ID khong ton tai trong danh sach !!!");
			return;
		}

		// check rang buoc voi bang Product , sau khi tao Class product 
		if(ManagerProduct.findByIDType(id)!=-1) {
			System.out.println("Ma loai san pham dang duoc su dung cho San pham, nen khong the xoa");
			return;
		}

		ds_type.remove(index);
		System.out.println("Xoa loai san pham thanh cong ^^");

	}

	private static void update() {
		System.out.println("\n\n----------SUA THONG TIN LOAI SAN PHAM ----------");
		System.out.print("Nhap id loai san pham tu 100 - " + (autoID-1) + " muon sua: ");
			
		int id = Integer.parseInt(sc.nextLine());

		int index = getIDByFind(id);
		if (index == -1) {
			System.out.println("Loai san pham khong co trong danh sach");
			return;
		}

		do {
			System.out.println("\n\n\tSua thong tin loai san pham: " + id);
			System.out.println("\tChon thong tin can sua");
			System.out.println("\t1. Sua ten loai san pham");
			System.out.println("\t2. Sua mo ta loai san pham");
			System.out.println("\t0. Quay lai");

			System.out.print("\t>>> Lua chon cua ban: ");
			int chon = Integer.parseInt(sc.nextLine());

			switch (chon) {
			case 1:
				ds_type.get(index).updateTenLoai();
				break;
			case 2:
				ds_type.get(index).updateMoTa();
				break;
			case 0:
				return;
			default:
				System.out.println("Lua chon khong hop le");
			}
		} while (true);
	}

	private static void add() {
		System.out.println("Them moi 1 loai san pham");
		
		// nhap ten loai san pham 
		System.out.print(">> Nhap ten loai san pham: ");
		String name = sc.nextLine();

		if (name.equals("")) {
			System.out.println("Khong duoc de trong ten loai san pham");
			return;
		}

		Boolean check = checkTrung(name);
		if (check) {
			System.out.println("Ten loai san pham nay da co trong danh sach");
			return;
		}

		// nhap mo ta san pham 
		System.out.print(">> Nhap mo ta loai san pham: ");
		String moTa = sc.nextLine();

		if (moTa.equals("")) {
			System.out.println("Khong duoc de trong mo ta loai san pham");
			return;
		}

		ds_type.add(new Type(autoID++, name, moTa));
		System.out.println("\nThem moi loai san pham thanh cong");
	}

	private static void display() {
		System.out.println("================= HIEN THI DANH SACH CHUNG LOAI =====================");
		System.out.printf("%-3s %-20s %-30s %n","ID","Ten loai","Mo ta");
		for (Type x : ds_type) {
			x.display();
		}
	}

	// cac ham ho tro
	public static Boolean checkTrung(String name) {
		for (Type ncc : ds_type) {
			if (ncc.getName().trim().equalsIgnoreCase(name.trim())) {
				return true;
			}
		}
		return false;
	}

	// lay ra id
	public static int getIDByFind(int id) {
		for (int i = 0; i < ds_type.size(); i++) {
			if (ds_type.get(i).getId() == id) {
				return i;
			}
		}
		return -1;
	}
	
	public static String getNameById(int id) {
		for (Type x : ds_type) {
			if (x.getId() == id) {
				return x.getName();
			}
		}
		return null;
	}

	
	public static int findByName(String name) {
		for (int index = 0; index < ds_type.size(); index++) {
			if (ds_type.get(index).getName().trim().equalsIgnoreCase(name.trim())) {
				return index;
			}
		}
		return -1;
	}
	
}
