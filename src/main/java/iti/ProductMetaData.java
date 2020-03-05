package iti;

public class ProductMetaData {

    private final Integer id;
    private final String name;

    public ProductMetaData(Integer id, String name) {
        this.id = id;
        this.name = name;
    }

    public Integer getId() {
        return id;
    }

    public String getTaskName() {
        return name;
    }
}
