package by.grouptopprogers.entity;

import java.util.ArrayList;
import java.util.List;

public class Category {
    private String nameCategory;
    private List<Product> listProducts = new ArrayList<>();

    public List<Product> getListProducts() {
        return listProducts;
    }

    public void setListProducts(List<Product> listProducts) {
        this.listProducts = listProducts;
    }

    public String getNameCategory() {
        return nameCategory;
    }

    public void setNameCategory(String nameCategory) {
        this.nameCategory = nameCategory;
    }

    @Override
    public String toString() {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("\ncategory : " + nameCategory);
        stringBuilder.append(getListProducts());

        return stringBuilder.toString();
    }
}
