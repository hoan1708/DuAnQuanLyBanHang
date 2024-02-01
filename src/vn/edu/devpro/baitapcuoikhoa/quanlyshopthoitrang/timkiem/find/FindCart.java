package vn.edu.devpro.baitapcuoikhoa.quanlyshopthoitrang.timkiem.find;

import java.util.Scanner;

import vn.edu.devpro.baitapcuoikhoa.quanlyshopthoitrang.capnhat.typeofproduct.ManagerType;
import vn.edu.devpro.baitapcuoikhoa.quanlyshopthoitrang.quanlybanhang.thongke.QuanLyDSGioHang;

public class FindCart {

	static Scanner sc = new Scanner(System.in);
	
	public static void timKiemGioHang() {
		do {
			System.out.println("\n-----------TIM KIEM THONG TIN GIO HANG----------");
			System.out.println("Tieu chi tim kiem");
			System.out.println("\t1. Tim theo ma gio hang");
			System.out.println("\t0. Quay lai");
			
			System.out.print("\t>>> Lua chon cua ban: ");
			int chon = Integer.parseInt(sc.nextLine());
			
			switch (chon) {
			case 1: timTheoIdGioHang(); break;
			case 0: return;
			default: System.out.println("Lua chon khong hop le");
			}
		} while (true);
	}

	private static void timTheoIdGioHang() {
		System.out.print("Nhap ma gio hang can tim: ");
		int id = Integer.parseInt(sc.nextLine());
		int index = ManagerType.getIDByFind(id);
		if (index == -1) {
			System.out.println("Gio hang khong co trong danh sach");
			return;
		}
		System.out.println("Thong tin gio hang tim duoc");
		QuanLyDSGioHang.getList().get(index).display();
	}


}
