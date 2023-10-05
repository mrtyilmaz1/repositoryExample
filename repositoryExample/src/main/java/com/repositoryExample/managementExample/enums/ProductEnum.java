package com.repositoryExample.managementExample.enums;

public enum ProductEnum {

    COMPUTER("laptop"), // "laptop" yazma sebebimiz aşağıdaki string dönüşümünde alacağı değeri belirtmek.

    PHONE("mobil phone"),

    KEYPAD("keypad"),

    MOUSE("mouse");

    private final String product;
    //Her enum sabiti için bir String değeri temsil etmek için bir alan tanımlanıyor.

    ProductEnum(final String product){this.product = product;}
    //  Enum sabitlerinin oluşturulması sırasında her sabitin karşılık gelen product değeri atanıyor.

    public String getProduct() { return this.name();}
    // enum sabitlerinin adlarını döndüren bir metodu tanımlıyor.
    // This.name() metodu, Java'da enum sabitlerinin adını döndürür.
    // Yani, getProduct() metodu, ilgili enum sabitinin adını bir String olarak döndürüyor.



}
