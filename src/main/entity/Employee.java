package entity;

public class Employee {
    private int id;
    private String name;
    private String status;
    private int companyId;

    public Employee(int id, String name, String status, int companyId) {
        this.id = id;
        this.name = name;
        this.status = status;
        this.companyId = companyId;
    }

    public Employee() {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public int getCompanyId() {
        return companyId;
    }

    public void setCompanyId(int companyId) {
        this.companyId = companyId;
    }

    @Override
    public String toString() {
        return "Employee{" +
               "id=" + id +
               ", name='" + name + '\'' +
               ", status='" + status + '\'' +
               ", companyId=" + companyId +
               '}';
    }
}
