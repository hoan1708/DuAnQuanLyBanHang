package vn.edu.devpro.baitapcuoikhoa.quanlyshopthoitrang.timkiem.find;

import java.util.Scanner;

import vn.edu.devpro.baitapcuoikhoa.quanlyshopthoitrang.capnhat.product.ManagerProduct;

public class FindProduct {

	static Scanner sc = new Scanner(System.in);
	
	public static void timKiemSanPham() {
		do {
			System.out.println("\n-----------TIM KIEM THONG TIN HANG HOA----------");
			System.out.println("Tieu chi tim kiem");
			System.out.println("\t1. Tim theo ma hang hoa");
			System.out.println("\t2. Tim theo ten hang hoa");
			System.out.println("\t3. Tim theo khoang gia cua san pham");
			System.out.println("\t0. Quay lai");
			
			System.out.print("\t>>> Lua chon cua ban: ");
			int chon = Integer.parseInt(sc.nextLine());
			
			switch (chon) {
			case 1: timTheoIdHangHoa(); break;
			case 2: timTheoTenHangHoa(); break;
			case 3: timTheoKhoangGiaSanPham();break;
			case 0: return;
			default: System.out.println("Lua chon khong hop le");
			}
		} while (true);
	}

	private static void timTheoIdHangHoa() {
		System.out.print("Nhap ma hang hoa can tim: ");
		int id = Integer.parseInt(sc.nextLine());
		int index = ManagerProduct.findById(id);
		if (index == -1) {
			System.out.println("Hang hoa khong co trong danh sach");
			return;
		}
		System.out.println("Thong tin hang hoa tim duoc");
		ManagerProduct.getDs_sanPham().get(index).display();
	}

	private static void timTheoTenHangHoa() {
		System.out.print("Nhap ten hang hoa can tim: ");
		String name = sc.nextLine();
		int index = ManagerProduct.findByName(name);
		
		if (index == -1) {
			System.out.println("Hang hoa khong co trong danh sach");
			return;
		}
		System.out.println("Thong tin hang hoa tim duoc");
		ManagerProduct.getDs_sanPham().get(index).display();
		
	}

	private static void timTheoKhoangGiaSanPham() {
		System.out.println("\n\n Tim kiem san pham theo khoang gia:");
		System.out.print("Tim khoang gia tu: ");
		Double x = Double.parseDouble(sc.nextLine());
		System.out.print("Den khoang gia: ");
		Double y = Double.parseDouble(sc.nextLine());

		System.out.println("Thong tin hang hoa tim duoc");
		int index = ManagerProduct.timKiemTheoKhoangGia(x,y);
		if (index == 0) {
			System.out.println("Hang hoa khong co khoang gia ban muon tim");
			return;
		}
	}

}