package iti;

import com.amazonaws.services.dynamodbv2.datamodeling.*;
import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;

@DynamoDBDocument
public class Price {

    private Integer amount;
    private Integer scale;
    private String currencyCode;

    @JsonCreator
    public Price(
            @JsonProperty("taskItem") Integer amount,
            @JsonProperty("scale") Integer scale,
            @JsonProperty("currencyCode") String currencyCode) {
        this.amount = amount;
        this.scale = scale;
        this.currencyCode = currencyCode;
    }

    public Price() {

    }

    @DynamoDBAttribute(attributeName = "amount")
    public Integer getAmount() {
        return amount;
    }

    public void setAmount(Integer amount) {
        this.amount = amount;
    }

    @DynamoDBAttribute(attributeName = "scale")
    public Integer getScale() {
        return scale;
    }

    public void setScale(Integer scale) {
        this.scale = scale;
    }

    @DynamoDBAttribute(attributeName = "currencyCode")
    public String getCurrencyCode() {
        return currencyCode;
    }

    public void setCurrencyCode(String currencyCode) {
        this.currencyCode = currencyCode;
    }
}
