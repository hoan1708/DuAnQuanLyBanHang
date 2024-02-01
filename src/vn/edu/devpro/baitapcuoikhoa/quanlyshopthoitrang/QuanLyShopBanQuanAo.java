package vn.edu.devpro.baitapcuoikhoa.quanlyshopthoitrang;

import java.util.Scanner;

import vn.edu.devpro.baitapcuoikhoa.quanlyshopthoitrang.capnhat.QuanLyCapNhat;
import vn.edu.devpro.baitapcuoikhoa.quanlyshopthoitrang.capnhat.customer.ManagerCustomer;
import vn.edu.devpro.baitapcuoikhoa.quanlyshopthoitrang.capnhat.product.ManagerProduct;
import vn.edu.devpro.baitapcuoikhoa.quanlyshopthoitrang.capnhat.provider.ManagerProvider;
import vn.edu.devpro.baitapcuoikhoa.quanlyshopthoitrang.capnhat.typeofproduct.ManagerType;
import vn.edu.devpro.baitapcuoikhoa.quanlyshopthoitrang.quanlybanhang.QuanLyBanHang;
import vn.edu.devpro.baitapcuoikhoa.quanlyshopthoitrang.timkiem.QuanLyTimKiem;

public class QuanLyShopBanQuanAo {
	static Scanner sc = new Scanner(System.in);

	public static void main(String[] args) {
		ManagerProvider.init();
		ManagerType.init();
		ManagerCustomer.init();
		ManagerProduct.init();

		do {
			System.out.println("\n========= CHUONG TRINH QUAN LY SHOP THOI TRANG =========");
			System.out.println("Cac chuc nang quan ly cua hang");
			System.out.println("\t1. Cap nhat thong tin he thong");
			System.out.println("\t2. Quan ly ban hang");
			System.out.println("\t3. Tim kiem thong tin he thong");
			System.out.println("\t0. Thoat");

			System.out.print("\n\t>> Moi ban chon chuc nang: ");
			int chon = Integer.parseInt(sc.nextLine());
			switch (chon) {
			case 1:
				QuanLyCapNhat.quanLyCapNhat();
				break;
			case 2:
				QuanLyBanHang.quanLyBanHang();
				break;
			case 3:
				QuanLyTimKiem.quanLyTimKiem();
				break;
			case 0:
				System.out.println("Thoat ung dung");
				System.exit(0);
				break;
			}
		} while (true);
	}
}
