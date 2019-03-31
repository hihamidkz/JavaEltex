package ru.eltex;

public final class UrUser extends User {
    private String registrationDate;

    public UrUser() {
        super();
    }

    public UrUser(int id) {
        super(id);
    }

    public UrUser(String FIO, String phone, String registrationDate) {
        super(FIO, phone);
        this.registrationDate = registrationDate;
    }

    public String getRegistrationDate() {
        return registrationDate;
    }

    public void setRegistrationDate(String registrationDate) {
        this.registrationDate = registrationDate;
    }

    @Override
    public String toCSV() {
        return this.id + "; " + this.FIO + "; " + this.phone + "; " + this.registrationDate + "\n";
    }

    @Override
    public void fromCSV(String csv) {
        String[] arr = csv.split(";");
        this.id = Integer.valueOf(arr[0]);
        this.FIO = arr[1];
        this.phone = arr[2];
        this.registrationDate = arr[3];
    }
}
