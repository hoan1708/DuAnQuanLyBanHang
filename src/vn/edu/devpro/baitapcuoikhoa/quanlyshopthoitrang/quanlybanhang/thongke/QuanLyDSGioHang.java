package vn.edu.devpro.baitapcuoikhoa.quanlyshopthoitrang.quanlybanhang.thongke;

import java.util.ArrayList;
import java.util.Scanner;

import vn.edu.devpro.baitapcuoikhoa.quanlyshopthoitrang.capnhat.customer.ManagerCustomer;
import vn.edu.devpro.baitapcuoikhoa.quanlyshopthoitrang.quanlybanhang.customerbuy.Cart;

public class QuanLyDSGioHang {
	public static int autoId = 201;

	public static ArrayList<Cart> listCart = new ArrayList<>();
	public static ArrayList<Cart> listSumByIDkhachHang = new ArrayList<>();
	

	static Scanner sc = new Scanner(System.in);

	public static void quanLyGioHang() {
		Cart gio = new Cart();
		System.out.println("\n--------CAC CHUC NANG DANH CHO QUAN LY---------");
		do {
			System.out.println("\n\n----- Quan ly gio hang cua ban ------");
			System.out.println("\t1. Hien thi danh sach gio hang");
			System.out.println("\t2. Hien thi tong tien thu duoc cua khach hang ");
			System.out.println("\t0. Quay lai");

			System.out.print("\t>> Lua chon cua ban: ");
			int chon = Integer.parseInt(sc.nextLine());

			switch (chon) {
			case 1:
				hienThiDanhSachGioHang();
				break;
			case 2:
				thongKeTongHoaDonTheoKh();
				break;
			case 0:
				return;
			default:
				System.out.println("Lua chon cua ban khong hop le !! \n");
			}
		} while (true);
	}

	public static void hienThiDanhSachGioHang() {
		System.out.println("\n-------------DANH SACH GIO HANG----------");
		for (Cart x : listCart) {
			x.display();
			Cart cart = new Cart(x.getId(), x.getIdkh(), x.getTongTienKH(), x.getList());
			listSumByIDkhachHang.add(cart);
			System.out.println("---------------------------------------");
		}
	}

	public static void thongKeTongHoaDonTheoKh() {
		System.out.println("\n------------THONG KE TONG HOA DON THEO KHACH HANG----------");
		System.out.print(">> Nhap id khach hang tu >9 : ");
		int idKH = Integer.parseInt(sc.nextLine());
		
		int check = findByIdCustomer(idKH);
		if(check==-1) {
			System.out.println("Khach hang nay khong co trong gio hang");
			return;
		}
		
		double sum = 0;
		for (Cart x : listSumByIDkhachHang) {
			if(x.getIdkh()==idKH) {
				sum+= x.getTongTienKH();
			}
		}
		System.out.println("---------------------------------------");
		System.out.printf("Tong tien thu duoc cua khach hang %d: %,.2f", ManagerCustomer.getIDByFind(idKH), sum);
	}
	

	public static ArrayList<Cart> getList() {
		return listCart;
	}

	public static void setList(ArrayList<Cart> listCart) {
		QuanLyDSGioHang.listCart = listCart;
	}
	
	// find by id khach hang - de xoa khach hang
	public static int findByIdCustomer(int idkh) {
		for (int i = 0; i < listSumByIDkhachHang.size(); i++) {
			if (listSumByIDkhachHang.get(i).getIdkh() == idkh) {
				System.out.println("ID kh: " + listSumByIDkhachHang.get(i).getIdkh());
				return i;
			}
		}
		return -1;
	}
	
	
	// find by id san pham - de xoa san pham
	public static int findByIDProduct(int idHang) {
		for(int i=0;i<listCart.size();i++) {
			if(listSumByIDkhachHang.get(i).getIdh()==idHang) {
				System.out.println("ID hang hoa: " + listSumByIDkhachHang.get(i).getIdh());
				return i;
			}
		}
		return -1;
	}
	
}


