package vn.edu.devpro.baitapcuoikhoa.quanlyshopthoitrang.timkiem.find;

import java.util.Scanner;

import vn.edu.devpro.baitapcuoikhoa.quanlyshopthoitrang.capnhat.customer.ManagerCustomer;
import vn.edu.devpro.baitapcuoikhoa.quanlyshopthoitrang.capnhat.product.ManagerProduct;

public class FindCustomer {

	static Scanner sc = new Scanner(System.in);
	
	public static void timKiemKhachHang() {
		do {
			System.out.println("\n-----------TIM KIEM THONG TIN KHACH HANG----------");
			System.out.println("Tieu chi tim kiem");
			System.out.println("\t1. Tim theo ma khach hang");
			System.out.println("\t2. Tim theo ten khach hang");
			System.out.println("\t3. Tim theo so dien thoai");
			System.out.println("\t0. Quay lai");
			
			System.out.print("\t>>> Lua chon cua ban: ");
			int chon = Integer.parseInt(sc.nextLine());
			
			switch (chon) {
			case 1: timTheoIdKhachHang(); break;
			case 2: timTheoTenKhachHang(); break;
			case 3: timTheoSoDienThoai();break;
			case 0: return;
			default: System.out.println("Lua chon khong hop le");
			}
		} while (true);
	}

	private static void timTheoIdKhachHang() {
		System.out.print("Nhap ma khach hang can tim: ");
		int id = Integer.parseInt(sc.nextLine());
		int index = ManagerCustomer.findById(id);
		if (index == -1) {
			System.out.println("Khach hang khong co trong danh sach");
			return;
		}
		System.out.println("Thong tin khach hang tim duoc");
		ManagerCustomer.getDs_khachHang().get(index).hienThi();
	}

	private static void timTheoTenKhachHang() {
		System.out.print("Nhap ten khach hang can tim: ");
		String name = sc.nextLine();
		int index = ManagerCustomer.findByName(name);
		
		if (index == -1) {
			System.out.println("Khach hang khong co trong danh sach");
			return;
		}
		System.out.println("Thong tin khach hang tim duoc");
		ManagerCustomer.getDs_khachHang().get(index).hienThi();
		
	}

	private static void timTheoSoDienThoai() {
		// TODO Auto-generated method stub
		
	}

}