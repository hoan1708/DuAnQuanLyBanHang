package vn.edu.devpro.baitapcuoikhoa.quanlyshopthoitrang.capnhat.product;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.Scanner;

import vn.edu.devpro.baitapcuoikhoa.quanlyshopthoitrang.capnhat.customer.Customer;
import vn.edu.devpro.baitapcuoikhoa.quanlyshopthoitrang.capnhat.provider.ManagerProvider;
import vn.edu.devpro.baitapcuoikhoa.quanlyshopthoitrang.capnhat.typeofproduct.ManagerType;
import vn.edu.devpro.baitapcuoikhoa.quanlyshopthoitrang.quanlybanhang.thongke.QuanLyDSGioHang;

public class ManagerProduct {

	static Scanner sc = new Scanner(System.in);
	public static ArrayList<Product> ds_sanPham = new ArrayList<Product>();

	public static ArrayList<Product> getDs_sanPham() {
		return ds_sanPham;
	}

	public static void setDs_sanPham(ArrayList<Product> ds_sanPham) {
		ManagerProduct.ds_sanPham = ds_sanPham;
	}

	public static int autoID = 300;

	public static void init() {
		ds_sanPham.add(new Product(autoID++, 100, 200, "Ao coc tay chat cotton", 10, 200000));
		ds_sanPham.add(new Product(autoID++, 101, 201, "Quan au den", 12, 250000));
		ds_sanPham.add(new Product(autoID++, 102, 202, "Ao khoac gio", 6, 450000));
		ds_sanPham.add(new Product(autoID++, 100, 201, "Ao coc tay mau hong", 30, 150000));

	}

	public static void capNhatSanPham() {
		do {
			System.out.println("\n\n\n-------- CAP NHAT THONG TIN SAN PHAM -------- ");
			System.out.println("Chon thong tin cap nhat ");
			System.out.println("\t1. Xem danh sach san pham ");
			System.out.println("\t2. Them san pham moi");
			System.out.println("\t3. Sua thong tin san pham");
			System.out.println("\t4. Xoa thong tin san pham");
			System.out.println("\t5. Sap xep danh sach san pham theo ten san pham");
			System.out.println("\t0. Quay lai");
			System.out.print("\n\t>>> Lua chon cua ban: ");
			int chon = Integer.parseInt(sc.nextLine());

			System.out.println("\n");

			switch (chon) {
			case 1:
				display();
				break;
			case 2:
				add();
				break;
			case 3:
				update();
				break;
			case 4:
				remove();
				break;
			case 5:
				sort();
				System.out.println("Sap xep danh sach san pham theo ten san pham thanh cong");
				break;
			case 0:
				return;
			default:
				System.out.println("Lua chon khong hop le ..");
			}

		} while (true);
	}


	private static void sort() {
		Collections.sort(ds_sanPham, new Comparator<Product>() {
			@Override
			public int compare(Product o1, Product o2) {
				return o1.getNameSP().trim().compareToIgnoreCase(o2.getNameSP().trim());
			}
		});
	}

	private static void remove() {
		System.out.println("\n----------XOA THONG TIN SAN PHAM----------");
		System.out.print("Nhap id san pham tu 300 - " + (autoID-1) + " muon xoa: ");
		int id = Integer.parseInt(sc.nextLine());

		int index = getIDByFind(id);
		if (index == -1) {
			System.out.println("San pham khong co trong danh sach");
			return;
		}
		// Kiem tra rang buoc lien ket voi gio hang ma khach hang da thanh toan - De sau
		if(QuanLyDSGioHang.findByIDProduct(id)!=-1) {
			System.out.println("San pham dang duoc su dung trong gio hang, nen khong the xoa");
			return;
		}
		

		ds_sanPham.remove(index);
		System.out.println("Xoa san pham thanh cong!");
	}

	private static void update() {
		System.out.println("\n\n----------SUA THONG TIN SAN PHAM ----------");
		System.out.print("Nhap id san pham tu 300 - " + (autoID-1) + " muon xoa: ");
		int id = Integer.parseInt(sc.nextLine());

		int index = getIDByFind(id);
		if (index == -1) {
			System.out.println("San pham khong co trong danh sach");
			return;
		}

		do {
			System.out.println("\n\n\tSua thong tin san pham: " + id);
			System.out.println("\tChon thong tin can sua");
			System.out.println("\t1. Sua loai nha cung cap");
			System.out.println("\t2. Sua loai san pham");
			System.out.println("\t3. Sua ten san pham");
			System.out.println("\t4. Sua so luong san pham");
			System.out.println("\t5. Sua gia san pham");
			System.out.println("\t0. Quay lai");

			System.out.print("\t>>> Lua chon cua ban: ");
			int chon = Integer.parseInt(sc.nextLine());

			System.out.println();
			switch (chon) {
			case 1:
				ds_sanPham.get(index).updateNhaCungCap();
				break;
			case 2:
				ds_sanPham.get(index).updateLoaiSanPham();
				break;
			case 3:
				ds_sanPham.get(index).updateTenSanPham();
				break;
			case 4:
				ds_sanPham.get(index).updateSoLuongSanPham();
				break;
			case 5:
				ds_sanPham.get(index).updateGiaSanPham();
				break;
			case 0:
				return;
			default:
				System.out.println("Lua chon khong hop le");
			}
		} while (true);
	}

	private static void add() {
		System.out.println("\nThem moi 1 san pham");
		
		// nhap id nha cung cap 
		System.out.println("Nhap id nha cung cap tu >199 : ");
		int idNCC = Integer.parseInt(sc.nextLine());
		
		
		int indexNCC = ManagerProvider.getIDByFind(idNCC);
		if(indexNCC==-1) {
			System.out.println("id nha cung cap khong co trong danh sach");
			return;
		}
		
		// nhap id loai san pham 
		System.out.println("Nhap id loai san pham >99 : ");
		int idLsp = Integer.parseInt(sc.nextLine());
		
		
		int indexLsp = ManagerType.getIDByFind(idLsp);
		if(indexLsp==-1) {
			System.out.println("id loai san pham khong co trong danh sach");
			return;
		}
		
		// nhap ten san pham 
		System.out.print("Nhap ten san pham moi: ");
		String name = sc.nextLine();

		if (name.equals("")) {
			System.out.println("Khong duoc de trong ten san pham");
			return;
		}

		Boolean check = checkTrung(name);
		if (check) {
			System.out.println("Ten san pham nay da co trong danh sach");
			return;
		}

		// nhap so luong san pham 
		System.out.print("Nhap so luong san pham: ");
		double amount = Double.parseDouble(sc.nextLine());
		
		if (amount < 0) {
			System.out.println("So luong khong duoc la so am");
			return;
		}
		
		
		// nhap gia san pham 
		System.out.print("Nhap don gia ban san pham: ");
		double price = Double.parseDouble(sc.nextLine());
		
		if (price < 0) {
			System.out.println("Don gia ban khong duoc la so am");
			return;
		}
		
		ds_sanPham.add(new Product(autoID++, idLsp, idNCC, name, amount, price));
		System.out.println("Them moi san pham thanh cong ^^ ");
	}
	
	private static void display() {
		System.out.println("================= HIEN THI DANH SACH SAN PHAM =====================");
		System.out.printf("%-5s  %-7s  %-6s %-30s %-8s %15s%n"
				,"ID SP","ID loai","ID NCC", "Ten SP","So luong","Don gia");
		for(Product sp :ds_sanPham) {
			sp.display();
		}
	}


	// cac ham ho tro
	public static Boolean checkTrung(String name) {
		for (Product kh : ds_sanPham) {
			if (kh.getNameSP().trim().equalsIgnoreCase(name.trim())) {
				return true;
			}
		}
		return false;
	}

	// lay ra id
	public static int getIDByFind(int id) {
		for (int i = 0; i < ds_sanPham.size(); i++) {
			if (ds_sanPham.get(i).getIdSP() == id) {
				return i;
			}
		}
		return -1;
	}
	
	// find by id loai san pham - de xoa
	public static int findByIDType(int idType) {
		for(int i=0; i<ds_sanPham.size();i++) {
			if(ds_sanPham.get(i).getIdLoaiSP()==idType) {
				return i;
			}
		}
		return -1;
	}
	
	
	// find by id nha cung cap - de xoa
	public static int findByIDProvider(int idPro) {
		for(int i=0;i<ds_sanPham.size();i++) {
			if(ds_sanPham.get(i).getIdNhaCungCap()==idPro) {
				return i;
				
			}
		}
		return -1;
	}
	
	public static Product getHangHoaByID(int id) {
		for (Product x : ds_sanPham) {
			if (x.getIdSP() == id) {
				return x;
			}
		}
		return null;
	}
	
	//+ tim theo id hang hoa
	public static int findById(int id) {
		for (int index = 0; index < ds_sanPham.size(); index++) {
			if (ds_sanPham.get(index).getIdSP() == id) {
				return index;
			}
		}
		return -1;
	}
	
	public static int findByName(String name) {
		for (int index = 0; index < ds_sanPham.size(); index++) {
			if (ds_sanPham.get(index).getNameSP().trim().equalsIgnoreCase(name.trim())) {
				return index;
			}
		}
		return -1;
	}
	
	public static int timKiemTheoKhoangGia(Double x, Double y) {
		int check = 0;
		for (int index = 0; index < ds_sanPham.size(); index++) {
			if (ds_sanPham.get(index).getPrice() >= x && ds_sanPham.get(index).getPrice() <= y) {
				 ds_sanPham.get(index).display();
				 check++;
			}
		}
		return check;
	}
	
}
