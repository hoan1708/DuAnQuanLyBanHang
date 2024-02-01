package vn.edu.devpro.baitapcuoikhoa.quanlyshopthoitrang.quanlybanhang.customerbuy;

import java.util.ArrayList;

import vn.edu.devpro.baitapcuoikhoa.quanlyshopthoitrang.capnhat.customer.ManagerCustomer;

public class Cart extends Hang {

	private int id;
	private int idkh;
	private double tongTienKH;
	
	public Cart(int id, int idkh, double tongTienKH, ArrayList<Hang> list) {
		super();
		this.id = id;
		this.idkh = idkh;
		this.tongTienKH = tongTienKH;
		this.listHang = list;
	}


	private ArrayList<Hang> listHang = new ArrayList<Hang>();
	
	public void display() {
		System.out.println("\tMa gio hang: " + this.id);
		System.out.println("\tTen khach hang: " + ManagerCustomer.getNameById(this.idkh));
		System.out.println("\nDanh sach hang hoa: ");
		System.out.printf("%-30s %10s %15s %15s %n", "Ten hang hoa",
				"So luong", "Don gia", "Thanh tien");
		double total = 0;
		for (Hang x : listHang) {
			x.display();
			total += x.thanhTien();
		}
		System.out.printf("\n\tCong thanh tien: %,.2f%n", total);
		this.tongTienKH = total;
	}
	
	
	public double getTongTienKH() {
		return tongTienKH;
	}


	public void setTongTienKH(double tongTienKH) {
		this.tongTienKH = tongTienKH;
	}


	public Cart() {
	}

	public Cart(int id, int idkh, ArrayList<Hang> list) {
		super();
		this.id = id;
		this.idkh = idkh;
		this.listHang = list;
	}
	
	

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public int getIdkh() {
		return idkh;
	}

	public void setIdkh(int idkh) {
		this.idkh = idkh;
	}

	public ArrayList<Hang> getList() {
		return listHang;
	}

	public void setList(ArrayList<Hang> list) {
		this.listHang = list;
	}
	
	
	public int findByIdh(int idh) {
		for (int i = 0; i < this.listHang.size(); i++) {
			if (this.listHang.get(i).getIdh() == idh) {
				return i;
			}
		}
		return -1;
	}
	
	
	
}
