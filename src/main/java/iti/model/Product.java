package iti.model;

import com.amazonaws.services.dynamodbv2.datamodeling.*;
import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.UUID;

@DynamoDBTable(tableName = "Product")
public class Product {

    private String id;
    private String sku;
    private String name;
    private String shortDescription;
    private String longDescription;
    private String imageUrl;
    private Price price;

    @JsonCreator
    public Product(
            @JsonProperty("sku") String sku,
            @JsonProperty("name") String name,
            @JsonProperty("shortDescription") String shortDescription,
            @JsonProperty("longDescription") String longDescription,
            @JsonProperty("imageUrl") String imageUrl,
            @JsonProperty("price") Price price) {
        this.id = UUID.randomUUID().toString();
        this.sku = sku;
        this.name = name;
        this.shortDescription = shortDescription;
        this.longDescription = longDescription;
        this.imageUrl = imageUrl;
        this.price = price;
    }

    public Product(){

    }

    @DynamoDBAttribute(attributeName = "id")
    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    @DynamoDBHashKey(attributeName = "sku")
    public String getSku() {

        return sku;
    }

    public void setSku(String sku) {

        this.sku = sku;
    }

    @DynamoDBAttribute(attributeName = "name")
    public String getName() {

        return name;
    }

    public void setName(String name) {

        this.name = name;
    }

    @DynamoDBAttribute(attributeName = "shortDescription")
    public String getShortDescription() {

        return shortDescription;
    }

    public void setShortDescription(String shortDescription) {
        this.shortDescription = shortDescription;
    }

    @DynamoDBAttribute(attributeName = "longDescription")
    public String getLongDescription() {
        return longDescription;
    }

    public void setLongDescription(String longDescription) {

        this.longDescription = longDescription;
    }

    @DynamoDBAttribute(attributeName = "imageUrl")
    public String getImageUrl() {

        return imageUrl;
    }

    public void setImageUrl(String imageUrl) {

        this.imageUrl = imageUrl;
    }

    @DynamoDBAttribute(attributeName = "price")
    public Price getPrice() {

        return price;
    }

    public void setPrice(Price price) {

        this.price = price;
    }

    @Override
    public String toString() {
        return "Product [id=" + id + "sku=" + sku + ", name=" + name + ", shortDescription=" + shortDescription + ", longDescription="
                + longDescription + ", imageUrl=" + imageUrl + ", price=" + price + "]";
    }
}
