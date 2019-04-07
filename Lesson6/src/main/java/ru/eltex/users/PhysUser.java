package ru.eltex.users;

public class PhysUser extends User {
	private String address;

	public PhysUser() {
		super();
	}

	public PhysUser(int id, String FIO, String phone, String address) {
		super(id, FIO, phone);
		this.address = address;
	}

	public PhysUser(String FIO, String phone, String address) {
		super(FIO, phone);
		this.address = address;
	}

	public String getAddress() {
		return this.address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	@Override
	public String toCSV() {
		return this.id + ";" + this.FIO + ";" + this.phone + ";" + this.address + "\n";
	}

	@Override
	public void fromCSV(String csv) {
		String[] arr = csv.split(";");
		this.id = Integer.valueOf(arr[0]);
		this.FIO = arr[1];
		this.phone = arr[2];
		this.address = arr[3];
	}
}
