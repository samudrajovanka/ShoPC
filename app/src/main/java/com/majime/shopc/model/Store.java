package com.majime.shopc.model;

import java.util.ArrayList;

public class Store {
    private String name, address;
    private ArrayList<Product> products;

    public Store() {
        this.name = "ShoPC";
        this.address = "Address";
        this.products = new ArrayList<Product>();
    }

    public Store(String name, String address) {
        this.name = name;
        this.address = address;
        this.products = new ArrayList<Product>();
    }

    public Store(String name, String address, ArrayList<Product> products) {
        this.name = name;
        this.address = address;
        this.products = products;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public ArrayList<Product> getProducts() {
        return this.products;
    }

    public Product getProduct(String nameProduct) {
        for(Product product: this.products) {
            if(product.name.equalsIgnoreCase(nameProduct)) {
                return product;
            }
        }
        return null;
    }

    public void addProduct(Product product) {
        this.products.add(product);
    }

    public void addAllProduct(ArrayList<Product> products) {
        this.products.addAll(products);
    }

    public boolean removeProduct(String nameProduct) {
        int i = 0;
        for(Product product: this.products) {
            if(product.name.equalsIgnoreCase(nameProduct)) {
                this.removeProduct(i);

                return true;
            }

            i++;
        }
        return false;
    }

    public boolean removeProduct(int index) {
        if(index < 0 || index >= this.products.size()) {
            return false;
        }

        this.products.remove(index);
        return true;
    }

    public boolean removeAllWaitingCartProducts() {
        if(this.products.size() == 0) return false;

        for(int i = this.products.size(); i <= 0; i--) {
            this.removeProduct(i);
        }

        return true;
    }

    public int getAmountOfProduct() {
        return this.products.size();
    }

    public int calculate(Product product, Shipping shipping, Payment payment) {
        return 0;
    }

    public int calculate(ArrayList<Product> products, Shipping shipping, Payment payment) {
        return 0;
    }

    public boolean buy(User user, Shipping shipping, Payment payment) {
        int totalPrice = 0;
        if(user.amountOfCartProduct() == 1)
            totalPrice = calculate(user.getWaitingCartProducts().get(0), shipping, payment);
        else
            totalPrice = calculate(user.getWaitingCartProducts(), shipping, payment);

        if(user.getSaldo() >= totalPrice) {
            user.setSaldo(user.getSaldo() - totalPrice);
            return true;
        } else {
            return false;
        }
    }

}
