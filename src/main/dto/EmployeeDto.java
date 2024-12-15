package dto;

public class EmployeeDto {
    private int id;
    private String name;
    private String status;

    public EmployeeDto(int id, String name, String status) {
        this.id = id;
        this.name = name;
        this.status = status;
    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getStatus() {
        return status;
    }

    @Override
    public String toString() {
        return "EmployeeDto{" +
               "id=" + id +
               ", name='" + name + '\'' +
               ", status='" + status + '\'' +
               '}';
    }
}
