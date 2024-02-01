package vn.edu.devpro.baitapcuoikhoa.quanlyshopthoitrang.quanlybanhang;

import java.util.Scanner;

import vn.edu.devpro.baitapcuoikhoa.quanlyshopthoitrang.quanlybanhang.customerbuy.ManagerCart;
import vn.edu.devpro.baitapcuoikhoa.quanlyshopthoitrang.quanlybanhang.thongke.QuanLyDSGioHang;


public class QuanLyBanHang {

	static Scanner sc = new Scanner(System.in);

	public static void quanLyBanHang() {
		do {
			System.out.println("\n-----------QUAN LY BAN HANG------------");
			System.out.println("Chon cuc nang quan ly");
			System.out.println("\t1. Danh cho khach hang");
			System.out.println("\t2. Danh cho nguoi quan ly");
			System.out.println("\t0. Quay lai");

			System.out.print("\n\t>> Lua chon cua ban: ");
			int chon = Integer.parseInt(sc.nextLine());

			switch (chon) {
			case 1:
				ManagerCart.quanLyGioHang();
				break;
			case 2:
				QuanLyDSGioHang.quanLyGioHang();
				break;
			case 0:
				return;
			default:
				System.out.println("Lua chon khong hop le");
			}
		} while (true);
	}

}
