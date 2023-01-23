package homework4.phonebook;

public class Notation {
    private String name;
    private int phone;

    public Notation(String name, int phone) {
        this.name = name;
        this.phone = phone;
    }


    public int getPhone() {
        return phone;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setPhone(int phone) {
        this.phone = phone;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (!(obj instanceof Notation notation)) return false;
        return phone == notation.phone;
    }
}
