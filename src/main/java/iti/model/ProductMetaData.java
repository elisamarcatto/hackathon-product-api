package iti.model;

public class ProductMetaData {

    private final String sku;
    private final String name;

    public ProductMetaData(String sku, String name) {
        this.sku = sku;
        this.name = name;
    }

    public String getSku() {
        return sku;
    }

    public String getTaskName() {
        return name;
    }
}
