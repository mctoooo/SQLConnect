package com.mycompany.sqlconnect;

import java.util.List;

public class Product {
    private String prodName;
    private String prodType;
    private String prodAmt;
    private String prodPrice;
    private String prodDiscount;

public Product(List<String> list)

    public void setProdName(String prodName) {
        this.prodName = prodName;
    }

    public void setProdType(String prodType) {
        this.prodType = prodType;
    }

    public void setProdAmt(String prodAmt) {
        this.prodAmt = prodAmt;
    }

    public void setProdPrice(String prodPrice) {
        this.prodPrice = prodPrice;
    }

    public void setProdDiscount(String prodDiscount) {
        this.prodDiscount = prodDiscount;
    }

    public String getProdName() {
        return prodName;
    }

    public String getProdType() {
        return prodType;
    }

    public String getProdAmt() {
        return prodAmt;
    }

    public String getProdPrice() {
        return prodPrice;
    }

    public String getProdDiscount() {
        return prodDiscount;
    }
}
