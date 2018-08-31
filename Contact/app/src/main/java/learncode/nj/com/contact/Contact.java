package learncode.nj.com.contact;

public class Contact {

    String name;
    String contact;
    String Email;
    String Address;
    byte[] image;


    Contact(String Uname,String Ucontact, String Uemail, String Uaddress ){
        this.name=Uname;
        this.contact=Ucontact;
        this.Email=Uemail;
        this.Address=Uaddress;
    }

    Contact(String Uname,String Ucontact, String Uemail, String Uaddress, byte[] Uimage){
        this.name=Uname;
        this.contact=Ucontact;
        this.Email=Uemail;
        this.Address=Uaddress;
        this.image=Uimage;
    }

    public String getName() {
        return name;
    }

    public String getContact() {
        return contact;
    }

    public String getEmail() {
        return Email;
    }

    public String getAddress() {
        return Address;
    }

    public byte[] getImage() {
        return image;
    }
}
