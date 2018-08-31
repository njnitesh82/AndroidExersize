package learncode.nj.com.contact;

public class contact {
    public String fid;
    public String name;
    public String email;
    public String number;

    public contact() {
    }

    public contact(String fid, String name, String email, String number) {
        this.fid = fid;
        this.name = name;
        this.email = email;
        this.number = number;
    }


    public String getFid() {
        return fid;
    }

    public String getName() {
        return name;
    }

    public String getEmail() {
        return email;
    }

    public String getNumber() {
        return number;
    }


    //setter


    public void setFid(String fid) {
        this.fid = fid;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public void setNumber(String number) {
        this.number = number;
    }
}
