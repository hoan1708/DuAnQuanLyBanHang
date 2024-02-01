package vn.edu.devpro.baitapcuoikhoa.quanlyshopthoitrang.timkiem.find;

import java.util.Scanner;

import vn.edu.devpro.baitapcuoikhoa.quanlyshopthoitrang.capnhat.product.ManagerProduct;
import vn.edu.devpro.baitapcuoikhoa.quanlyshopthoitrang.capnhat.provider.ManagerProvider;

public class FindProvider {

	static Scanner sc = new Scanner(System.in);
	
	public static void timKiemNhaCungCap() {
		do {
			System.out.println("\n-----------TIM KIEM THONG TIN NHA CUNG CAP----------");
			System.out.println("Tieu chi tim kiem");
			System.out.println("\t1. Tim theo ma nha cung cap");
			System.out.println("\t2. Tim theo ten nha cung cap");
			System.out.println("\t0. Quay lai");
			
			System.out.print("\t>>> Lua chon cua ban: ");
			int chon = Integer.parseInt(sc.nextLine());
			
			switch (chon) {
			case 1: timTheoIdNhaCungCap(); break;
			case 2: timTheoTenNhaCungCap(); break;
			case 0: return;
			default: System.out.println("Lua chon khong hop le");
			}
		} while (true);
	}

	private static void timTheoIdNhaCungCap() {
		System.out.print("Nhap ma nha cung cap can tim: ");
		int id = Integer.parseInt(sc.nextLine());
		int index = ManagerProvider.getIDByFind(id);
		if (index == -1) {
			System.out.println("Nha cung cap khong co trong danh sach");
			return;
		}
		System.out.println("Thong tin nha cung cap tim duoc");
		ManagerProvider.getDsNhaCungCap().get(index).display();
	}

	private static void timTheoTenNhaCungCap() {
		System.out.print("Nhap ten nha cung cap can tim: ");
		String name = sc.nextLine();
		int index = ManagerProvider.findByName(name);
		
		if (index == -1) {
			System.out.println("Nha cung cap khong co trong danh sach");
			return;
		}
		System.out.println("Thong tin nha cung cap tim duoc");
		ManagerProvider.getDsNhaCungCap().get(index).display();
		
	}

}
