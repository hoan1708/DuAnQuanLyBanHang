package vn.edu.devpro.baitapcuoikhoa.quanlyshopthoitrang.capnhat;

import java.util.Scanner;

import vn.edu.devpro.baitapcuoikhoa.quanlyshopthoitrang.capnhat.customer.ManagerCustomer;
import vn.edu.devpro.baitapcuoikhoa.quanlyshopthoitrang.capnhat.product.ManagerProduct;
import vn.edu.devpro.baitapcuoikhoa.quanlyshopthoitrang.capnhat.provider.ManagerProvider;
import vn.edu.devpro.baitapcuoikhoa.quanlyshopthoitrang.capnhat.typeofproduct.ManagerType;


public class QuanLyCapNhat {
	static Scanner sc = new Scanner(System.in);

	public static void quanLyCapNhat() {

		do {
			System.out.println("\n-------- CAP NHAT THONG TIN HE THONG -------- ");
			System.out.println("Chon thong tin cap nhat ");
			System.out.println("\t1. Cap nhat thong tin nha cung cap ");
			System.out.println("\t2. Cap nhat thong tin chung loai");
			System.out.println("\t3. Cap nhat thong tin san pham");
			System.out.println("\t4. Cap nhat thong tin khach hang");
			System.out.println("\t0. Quay lai");
			System.out.print("\t>>> Lua chon cua ban: ");
			int chon = Integer.parseInt(sc.nextLine());

			switch (chon) {
			case 1:
				ManagerProvider.capNhatNhaCungCap();
				break;
			case 2:
				ManagerType.capNhatChungLoai();
				break;
			case 3:
				ManagerProduct.capNhatSanPham();
				break;
			case 4:
				ManagerCustomer.capNhatKhachHang();
				break;
			case 0:
				return;
			default:
				System.out.println("Lua chon khong hop le ..");
			}

		} while (true);
	}
}
