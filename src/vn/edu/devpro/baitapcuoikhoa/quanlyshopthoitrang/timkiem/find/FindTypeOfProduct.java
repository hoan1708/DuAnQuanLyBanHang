package vn.edu.devpro.baitapcuoikhoa.quanlyshopthoitrang.timkiem.find;

import java.util.Scanner;

import vn.edu.devpro.baitapcuoikhoa.quanlyshopthoitrang.capnhat.provider.ManagerProvider;
import vn.edu.devpro.baitapcuoikhoa.quanlyshopthoitrang.capnhat.typeofproduct.ManagerType;

public class FindTypeOfProduct {

	static Scanner sc = new Scanner(System.in);
	
	public static void timKiemLoaiHangHoa() {
		do {
			System.out.println("\n-----------TIM KIEM THONG TIN LOAI SAN PHAM----------");
			System.out.println("Tieu chi tim kiem");
			System.out.println("\t1. Tim theo ma loai san pham");
			System.out.println("\t2. Tim theo ten loai san pham");
			System.out.println("\t0. Quay lai");
			
			System.out.print("\t>>> Lua chon cua ban: ");
			int chon = Integer.parseInt(sc.nextLine());
			
			switch (chon) {
			case 1: timTheoIdLoaiSanPham(); break;
			case 2: timTheoTenLoaiSanPham(); break;
			case 0: return;
			default: System.out.println("Lua chon khong hop le");
			}
		} while (true);
	}

	private static void timTheoIdLoaiSanPham() {
		System.out.print("Nhap ma loai san pham can tim: ");
		int id = Integer.parseInt(sc.nextLine());
		int index = ManagerType.getIDByFind(id);
		if (index == -1) {
			System.out.println("Loai san pham khong co trong danh sach");
			return;
		}
		System.out.println("Thong tin loai san pham tim duoc");
		ManagerType.getDs_type().get(index).display();
	}

	private static void timTheoTenLoaiSanPham() {
		System.out.print("Nhap ten loai san pham can tim: ");
		String name = sc.nextLine();
		int index = ManagerType.findByName(name);
		
		if (index == -1) {
			System.out.println("Loai san pham khong co trong danh sach");
			return;
		}
		System.out.println("Thong tin loai san pham tim duoc");
		ManagerType.getDs_type() .get(index).display();
	}

}
