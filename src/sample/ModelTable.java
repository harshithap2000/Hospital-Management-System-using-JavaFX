package sample;

import javafx.beans.property.SimpleStringProperty;

public class ModelTable {
    SimpleStringProperty dname,dept_name,did;

    public String getDid() {
        return did.get();
    }

    public void setDid(String did) {
        this.did.set(did);
    }

    public String getDname() {
        return dname.get();
    }

    public void setDname(String dname) {
        this.dname.set(dname);

    }

    public String getDept_name() {
        return dept_name.get();
    }

    public void setDept_name(String dept_name) {
        this.dept_name.set(dept_name);
    }

    public ModelTable(String did, String dname, String dept_name) {
        this.did =new SimpleStringProperty(did);
        this.dname = new SimpleStringProperty(dname);
        this.dept_name = new SimpleStringProperty(dept_name);
    }
}
