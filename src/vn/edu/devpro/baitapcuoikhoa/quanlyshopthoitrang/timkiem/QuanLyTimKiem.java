package vn.edu.devpro.baitapcuoikhoa.quanlyshopthoitrang.timkiem;

import java.util.Scanner;

import vn.edu.devpro.baitapcuoikhoa.quanlyshopthoitrang.timkiem.find.FindCart;
import vn.edu.devpro.baitapcuoikhoa.quanlyshopthoitrang.timkiem.find.FindCustomer;
import vn.edu.devpro.baitapcuoikhoa.quanlyshopthoitrang.timkiem.find.FindProduct;
import vn.edu.devpro.baitapcuoikhoa.quanlyshopthoitrang.timkiem.find.FindProvider;
import vn.edu.devpro.baitapcuoikhoa.quanlyshopthoitrang.timkiem.find.FindTypeOfProduct;

public class QuanLyTimKiem {
	static Scanner sc = new Scanner(System.in);

	public static void quanLyTimKiem() {

		do {
			System.out.println("\n-------- TIM KIEM THONG TIN HE THONG -------- ");
			System.out.println("Chon thong tin muon tim kiem ");
			System.out.println("\t1. Tim kiem thong tin nha cung cap");
			System.out.println("\t2. Tim kiem thong tin loai san pham");
			System.out.println("\t3. Tim kiem thong tin san pham");
			System.out.println("\t4. Tim kiem thong tin khach hang");
			System.out.println("\t5. Tim kiem thong tin gio hang");
			System.out.println("\t0. Quay lai");
			System.out.print("\t>>> Lua chon cua ban: ");
			int chon = Integer.parseInt(sc.nextLine());

			switch (chon) {
			case 1:
				FindProvider.timKiemNhaCungCap();
				break;
			case 2:
				FindTypeOfProduct.timKiemLoaiHangHoa();
				break;
			case 3:
				FindProduct.timKiemSanPham();
				break;
			case 4:
				FindCustomer.timKiemKhachHang();
				break;
			case 5:
				FindCart.timKiemGioHang();
				break;
			case 0:
				return;
			default:
				System.out.println("Lua chon khong hop le ..");
			}

		} while (true);
	}
}
