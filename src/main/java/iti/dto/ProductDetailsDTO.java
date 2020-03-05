package iti.dto;

import iti.model.Price;
import iti.model.Product;

public class ProductDetailsDTO {

    private String id;
    private String sku;
    private String name;
    private String shortDescription;
    private String longDescription;
    private String imageUrl;
    private Price price;

    public static ProductDetailsDTO fromProduct(Product product) {
        final ProductDetailsDTO productDetailsDTO = new ProductDetailsDTO();
        productDetailsDTO.setId(product.getId());
        productDetailsDTO.setImageUrl(product.getImageUrl());
        productDetailsDTO.setLongDescription(product.getLongDescription());
        productDetailsDTO.setName(product.getName());
        productDetailsDTO.setPrice(product.getPrice());
        productDetailsDTO.setShortDescription(product.getShortDescription());
        productDetailsDTO.setSku(product.getSku());
        return productDetailsDTO;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getSku() {
        return sku;
    }

    public void setSku(String sku) {
        this.sku = sku;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getShortDescription() {
        return shortDescription;
    }

    public void setShortDescription(String shortDescription) {
        this.shortDescription = shortDescription;
    }

    public String getLongDescription() {
        return longDescription;
    }

    public void setLongDescription(String longDescription) {
        this.longDescription = longDescription;
    }

    public String getImageUrl() {
        return imageUrl;
    }

    public void setImageUrl(String imageUrl) {
        this.imageUrl = imageUrl;
    }

    public Price getPrice() {
        return price;
    }

    public void setPrice(Price price) {
        this.price = price;
    }
}
