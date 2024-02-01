package vn.edu.devpro.baitapcuoikhoa.quanlyshopthoitrang.quanlybanhang.customerbuy;

import java.util.List;
import java.util.Scanner;

import vn.edu.devpro.baitapcuoikhoa.quanlyshopthoitrang.capnhat.customer.Customer;
import vn.edu.devpro.baitapcuoikhoa.quanlyshopthoitrang.capnhat.customer.ManagerCustomer;
import vn.edu.devpro.baitapcuoikhoa.quanlyshopthoitrang.capnhat.product.ManagerProduct;
import vn.edu.devpro.baitapcuoikhoa.quanlyshopthoitrang.capnhat.product.Product;
import vn.edu.devpro.baitapcuoikhoa.quanlyshopthoitrang.quanlybanhang.thongke.QuanLyDSGioHang;

public class ManagerCart {

	static Scanner sc = new Scanner(System.in);

	public static void quanLyGioHang() {
		// Khoi tao gio hang cho khach
		Cart gio = new Cart();
		System.out.println("\n--------Chao mung ban den voi cua hang ban quan ao---------");
		do {
			System.out.println("\n\n----- Quan ly gio hang cua ban ------");
			System.out.println("\t1. Xem gio hang");
			System.out.println("\t2. Them hang vao gio");
			System.out.println("\t3. Sua hang trong gio");
			System.out.println("\t4. Xoa hang trong gio");
			System.out.println("\t5. Huy gio hang");
			System.out.println("\t6. Thanh toan gio hang");
			System.out.println("\t0. Quay lai");

			System.out.print("\t>> Lua chon cua ban: ");
			int chon = Integer.parseInt(sc.nextLine());

			switch (chon) {
			case 1:
				System.out.println("\n--------GIO HANG CUA BAN---------\n");
				gio.display();
				break;
			case 2:
				add(gio);
				break;
			case 3:
				update(gio);
				break;
			case 4:
				remove(gio);
				break;
			case 5:
				gio = new Cart();
				break;
			case 6:
				payment(gio);
				return;
			case 0:
				gio = null;
				return;
			default: 
				System.out.println("Lua chon cua ban khong hop le !! \n");
			}
		} while (true);
	}

	private static void add(Cart gio) {
		System.out.println("\n--------THEM HANG VAO GIO--------------");
		System.out.print(">> Nhap vao id hang hoa tu > 299 : ");
		int idh = Integer.parseInt(sc.nextLine());

		int index = ManagerProduct.findById(idh);
		if (index == -1) {
			System.out.println("Hang hoa nay khong co trong danh sach ban");
			return;
		}

		System.out.print(">> Nhap so luong can mua > 0 : ");
		double amount = Double.parseDouble(sc.nextLine());
		if (amount <= 0) {
			System.out.println("So luong mua phai la so duong");
			return;
		}

		int indexGio = gio.findByIdh(idh);
		if (indexGio != -1) {
			amount += gio.getList().get(indexGio).getAmount();
		}
		
		if (amount > ManagerProduct.getDs_sanPham().get(index).getAmount()) {
			System.out.println("So luong hang khong du ban, mong ban thong cam");
			return;
		}

		if (indexGio != -1) { 
			gio.getList().get(indexGio).setAmount(amount);
		} else { 
			gio.getList().add(new Hang(idh, amount));
		}
		System.out.println("\nThem hang vao gio thanh cong!");
	}

	private static void update(Cart gio) {
		System.out.println("\n--------SUA HANG TRONG GIO----------");
		System.out.print(">> Nhap ma hang hoa can sua > 299 : ");
		int idh = Integer.parseInt(sc.nextLine());

		// Tim xem hang co trong gio khong
		int index = gio.findByIdh(idh);
		if (index == -1) {
			System.out.println("Hang hoa khong co trong gio");
			return;
		}
		// Kiem tra so luong phai la so duong
		System.out.print(">> Nhap so luong moi: ");
		double amount = Double.parseDouble(sc.nextLine());
		if (amount <= 0) {
			System.out.println("So luong mua phai la so duong");
			return;
		}
		// So luong mua phai khong duoc vuot qua so luong trong danh sach ban
		if (amount > ManagerProduct.getDs_sanPham().get(index).getAmount()) {
			System.out.println("So luong hang khong du ban, mong ban thong cam");
			return;
		}
		gio.getList().get(index).setAmount(amount);
		System.out.println("\nSua hang hoa trong gio thanh cong!");
	}

	private static void remove(Cart gio) {
		System.out.println("\n--------XOA HANG TRONG GIO----------");
		System.out.print(">> Nhap ma hang hoa > 299 can xoa: ");
		int idh = Integer.parseInt(sc.nextLine()); 

		// Tim xem hang co trong gio khong
		int index = gio.findByIdh(idh);
		if (index == -1) {
			System.out.println("\nHang hoa khong co trong gio");
			return;
		}
		gio.getList().remove(index);
		System.out.println("\nDa xoa hang hoa khoi gio hang!");
	}

	private static void payment(Cart gio) {
		// Thanh toan gio hang
		System.out.println("\n-----------THANH TOAN GIO HANG-------------");
		System.out.print(">> Nhap ma khach hang > 9 : ");
		int idkh = Integer.parseInt(sc.nextLine());

		// Tim xem khach hang co trong danh sach khach hang chua?
		int indexKhach = ManagerCustomer.getIDByFind(idkh);
		if (indexKhach == -1) {// Khach hang chua co trong danh sach, them moi
			String name = "";
			String sdt = "";
			do {
				System.out.print(">> Nhap ten khach hang moi: ");
				name = sc.nextLine();
				if (name.trim().length() == 0) {
					System.out.println("Ten khach hang khong duoc de trong");
				}

				System.out.print(">> Nhap so dien thoai cua khach hang: ");
				sdt = sc.nextLine();
				if (sdt.trim().length() == 0) {
					System.out.println("So dien thoai khong duoc de trong");
				}

			} while (name.trim().length() == 0 || sdt.trim().length() == 0);
			// Them khach hang vao danh sach khach hang
			idkh = ManagerCustomer.autoID++;
			ManagerCustomer.getDs_khachHang().add(new Customer(idkh, name, name));
		}

		// Thiet lap id, idkh cho gio hang
		gio.setId(QuanLyDSGioHang.autoId++);
		gio.setIdkh(idkh);

		System.out.println("\n----------HOA DON BAN LE----------");
		gio.display();
		// Luu gio hang vao danh sach gio hang
		QuanLyDSGioHang.listCart.add(gio);
		// Tru di so luong hang trong danh sach hang ban
		for (Hang x : gio.getList()) {
			for (Product y : ManagerProduct.getDs_sanPham()) {
				if (y.getIdSP() == x.getIdh()) {
					y.setAmount(y.getAmount() - x.getAmount());
				}
			}
		}
	}
	
	
	

}
